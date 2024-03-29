package com.example.demo.gameElements;

import com.example.demo.Controllers.gameSceneControlllers.fillPlayingField;
import com.example.demo.Controllers.gameSceneControlllers.switchToEndGame;
import com.example.demo.Main;
import com.example.demo.observerPattern.DogeSubject;
import com.example.demo.Controllers.gameSceneControlllers.stateChecker;
import com.example.demo.Controllers.gameSceneControlllers.tileMovement;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is the main class for all operations that shall be orchestrated within the game scene (i.e. calling the correct class and the correct method at the appropriate time) to ensure all functions as intended when the user is playing through the game.
 * Mainly the what, how and the order in which the elements shall appear in will be determined here.The class is instantiated whenever the user has made a choice in their mode that they wish to play.
 * @author Zhen Lin Wong-modified
 */
public class GameScene extends DogeSubject {
    public static final int HEIGHT = 700;
    protected static int n = 4;
    public final static int distanceBetweenCells = 10;
    public static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private Cell[][] cells = new Cell[n][n];
    private Group root;
    private long score = 0;
    private int haveEmptyCell;
    private TextMaker textMaker;
    private gameVisuals gameVisuals;
    private stateChecker stateChecker;
    private tileMovement movement;
    private fillPlayingField fillPlayingField;
    /**
     *Constructor for the GameScene class. When instantiated, the class shall create instances of the following classes, textMaker, gameVisuals,
     * stateChecker and movement. Reason being that these classes hold the methods that are key to the success of the operations within the gameScene.
     * Class itself is instantiated in the modeSelectSceneController after the user has selected their mode of choice.
     */
    public GameScene(){
        gameVisuals = new gameVisuals();
        stateChecker = new stateChecker();
        movement = new tileMovement();
        textMaker = TextMaker.getSingleInstance();
        attach(textMaker);
        fillPlayingField = new fillPlayingField();
    }
    /**
     * method that returns the dimensions that was chosen by the user. Used in utility classes to check the boundaries of the game.
     * @return The dimension of the playing field.
     */
    public static int getN() {
        return n;
    }
    /**
     * Method used in setting the dimensions of the playing field (tiles). Used when the user has made a choice in the choice box in the mode selection screen. Always defaults to
     * 4 when the user has made no choice (not determined by this specific method). Method also calculates the exact length of the cells. Length (one side) of the cell is also set as the
     * length of each cell varies from dimension to dimension.
     * @param number the dimensions (number x number) in which the tiles will set in.
     */
    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }
    /**
     * Method that returns the length of one side of a single cell. Value is never constant for each mode, therefore it is important for the utility functions to be up-to-date with the
     * exact measurements.
     * @return the length of one side of one cell in pixels.
     */
    public static double getLENGTH() {
        return LENGTH;
    }
    /**
     * Generally the method is employed as an initializer and a controller. The responsibilities of the class includes determining the position of the playing space, the order in which
     * the elements appear in, calling the correct methods from other classes for movement related activities and shall also detect the instance when the user has lost or won and act accordingly
     * to the situation. Method mainly utilizes all the utility methods from the utility package in order to achieve a coherent experience.
     * @param gameScene The scene that shall be filled with the correct elements in the correct order by the method.
     * @param root cluster of elements that shall appear in the game scene. Will be filled by the method.
     */
    public void game(Scene gameScene, Group root,Stage primaryStage) {
        notifyAllObservers(Main.isDogeMode());
        root.setLayoutX(150.0);
        root.setLayoutY(25);
        gameVisuals.makeBgRekt(root);
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
                attach(cells[i][j]);
            }

        }
        notifyAllObservers(Main.isDogeMode());
        gameVisuals.makeScoreRekt(root);
        Text text = new Text();
        gameVisuals.addScoreText(root,text);
        Text scoreText = new Text();
        gameVisuals.initializeScore(root,scoreText);
        fillPlayingField.randomFillNumber(cells,n,root);
        fillPlayingField.randomFillNumber(cells,n,root);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    movement.setScore(score);
                    if (key.getCode() == KeyCode.DOWN) {
                        if(!stateChecker.isStaticMove(cells,'d',n)) {
                            movement.moveDown(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                fillPlayingField.randomFillNumber(cells,n,root);
                            }
                        }
                    } else if (key.getCode() == KeyCode.UP) {
                        if(!stateChecker.isStaticMove(cells,'u',n)) {
                            movement.moveUp(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                fillPlayingField.randomFillNumber(cells,n,root);
                            }
                        }
                    } else if (key.getCode() == KeyCode.LEFT) {
                        if(!stateChecker.isStaticMove(cells,'l',n)) {
                            movement.moveLeft(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                fillPlayingField.randomFillNumber(cells,n,root);
                            }
                        }
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        if(!stateChecker.isStaticMove(cells,'r',n)) {
                            movement.moveRight(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                fillPlayingField.randomFillNumber(cells,n,root);
                            }
                        }
                    }
                    score=movement.getScore();
                    scoreText.setText(score + "");
                    haveEmptyCell = stateChecker.haveEmptyCell(cells,n);
                    if (haveEmptyCell == -1) {
                        if (stateChecker.canNotMove(cells)) {
                            try {
                                switchToEndGame switcheroo = new switchToEndGame(haveEmptyCell,score,primaryStage);
                                switcheroo.switchToEndGame();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            root.getChildren().clear();
                            score = 0;
                        }
                    }
                    if (haveEmptyCell==0){
                        try {
                            switchToEndGame switcheroo = new switchToEndGame(haveEmptyCell,score,primaryStage);
                            switcheroo.switchToEndGame();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        root.getChildren().clear();
                        score = 0;
                    }
                });
            });
    }
}
