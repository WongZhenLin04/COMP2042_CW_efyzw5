package com.example.demo;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;
class GameScene {
    private static final int HEIGHT = 700;
    protected static int n = 4;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private final TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[n][n];
    private Group root;
    private long score = 0;
    private int haveEmptyCell;
    private final scoreBoard scoreBoard = new scoreBoard();
    private final stateChecker stateChecker = new stateChecker();
    private final tileChecker tileChecker = new tileChecker();
    private movement movement = new movement();
    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }
    static double getLENGTH() {
        return LENGTH;
    }
    private void randomFillNumber(int turn) {
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
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }
    private void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(i, j, tileChecker.passDestination(cells,i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    private void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(i, j, tileChecker.passDestination(cells,i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    private void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(i, j, tileChecker.passDestination(cells,i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    private void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(i, j, tileChecker.passDestination(cells,i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (tileChecker.isValidDesH(cells,i, j, des, sign)) {
            score=movement.sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);

        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }
    private void moveVertically(int i, int j, int des, int sign) {
        if (tileChecker.isValidDesV(cells,i, j, des, sign)) {
            score=movement.sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            haveEmptyCell = stateChecker.haveEmptyCell(cells,n);
            cells[i][j].changeCell(cells[des][j]);
        }
    }
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }
    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private void makeBgRekt(Group root){
        Rectangle bgrekt = new Rectangle();
        bgrekt.setFill(Color.rgb(186, 186, 186));
        bgrekt.setHeight(Main.HEIGHT-40);
        bgrekt.setWidth(Main.WIDTH-500);
        root.getChildren().add(bgrekt);
        bgrekt.setX(-25);
        bgrekt.setY(-15);
    }
    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        root.setLayoutX(150.0);
        root.setLayoutY(25);
        makeBgRekt(root);
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }
        Text text = new Text();
        scoreBoard.addScoreBoard(root,text);
        Text scoreText = new Text();
        scoreBoard.initializeScore(root,scoreText);
        randomFillNumber(1);
        randomFillNumber(1);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    movement.setScore(score);
                    if (key.getCode() == KeyCode.DOWN) {
                        if(!stateChecker.isStaticMove(cells,'d',n)) {
                            GameScene.this.moveDown();
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber(2);
                            }
                        }
                    } else if (key.getCode() == KeyCode.UP) {
                        if(!stateChecker.isStaticMove(cells,'u',n)) {
                            GameScene.this.moveUp();
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber(2);
                            }
                        }
                    } else if (key.getCode() == KeyCode.LEFT) {
                        if(!stateChecker.isStaticMove(cells,'l',n)) {
                            GameScene.this.moveLeft();
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber(2);
                            }
                        }
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        if(!stateChecker.isStaticMove(cells,'r',n)) {
                            GameScene.this.moveRight();
                            if(stateChecker.haveEmptyCell(cells,n)==1){
                                GameScene.this.randomFillNumber(2);
                            }
                        }
                    }
                    scoreText.setText(score + "");
                    haveEmptyCell = stateChecker.haveEmptyCell(cells,n);
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    }
                });
                score=movement.getScore();
            });
    }
}
