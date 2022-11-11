package com.example.demo.gameElements;

import com.example.demo.endGameElements.EndGame;
import com.example.demo.gameElements.Utilities.stateChecker;
import com.example.demo.gameElements.Utilities.tileMovement;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
public class GameScene {
    private static final int HEIGHT = 700;
    protected static int n = 4;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private final TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[n][n];
    private Group root;
    private long score = 0;
    private int haveEmptyCell;
    private final gameVisuals gameVisuals = new gameVisuals();
    private final stateChecker stateChecker = new stateChecker();
    private final tileMovement movement = new tileMovement();
    public static int getN() {
        return n;
    }
    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }
    public static double getLENGTH() {
        return LENGTH;
    }
    private void randomFillNumber() {
        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }
        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }
    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        root.setLayoutX(150.0);
        root.setLayoutY(25);
        gameVisuals.makeBgRekt(root);
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }
        gameVisuals.makeScoreRekt(root);
        Text text = new Text();
        gameVisuals.addScoreText(root,text);
        Text scoreText = new Text();
        gameVisuals.initializeScore(root,scoreText);
        randomFillNumber();
        randomFillNumber();
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    movement.setScore(score);
                    if (key.getCode() == KeyCode.DOWN) {
                        if(!stateChecker.isStaticMove(cells,'d',n)) {
                            movement.moveDown(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber();
                            }
                        }
                    } else if (key.getCode() == KeyCode.UP) {
                        if(!stateChecker.isStaticMove(cells,'u',n)) {
                            movement.moveUp(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber();
                            }
                        }
                    } else if (key.getCode() == KeyCode.LEFT) {
                        if(!stateChecker.isStaticMove(cells,'l',n)) {
                            movement.moveLeft(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber();
                            }
                        }
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        if(!stateChecker.isStaticMove(cells,'r',n)) {
                            movement.moveRight(cells);
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber();
                            }
                        }
                    }
                    score=movement.getScore();
                    scoreText.setText(score + "");
                    haveEmptyCell = stateChecker.haveEmptyCell(cells,n);
                    if (haveEmptyCell == -1) {
                        if (stateChecker.canNotMove(cells)) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShowLose(endGameRoot, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    }
                });
            });
    }
}
