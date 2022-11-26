package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;
import static com.example.demo.gameElements.GameScene.*;
import static org.junit.jupiter.api.Assertions.*;

class generalMovementTest {
    private Cell[][] cells3 = new Cell[3][3];
    private Cell[][] cells4 = new Cell[4][4];
    private Cell[][] cells5 = new Cell[5][5];
    private long score = 0;
    private  double LENGTH3 = (HEIGHT - ((3 + 1) * distanceBetweenCells)) / (double) 3;
    private  double LENGTH4 = (HEIGHT - ((4 + 1) * distanceBetweenCells)) / (double) 4;
    private  double LENGTH5 = (HEIGHT - ((5 + 1) * distanceBetweenCells)) / (double) 5;
    private Group root=new Group();
    private generalMovement generalMovement = new generalMovement();
    @Test
    void sumCellNumbersToScoreZero3() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells3[i][j] = new Cell((j) * LENGTH3 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH3 + (i + 1) * distanceBetweenCells, LENGTH3, root);
            }
        }
        generalMovement.setN(3);
        assertEquals(0,generalMovement.sumCellNumbersToScore(cells3,score));
    }
    @Test
    void sumCellNumbersToScoreAll3(){
        Text two = new Text("2");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells3[i][j] = new Cell((j) * LENGTH3 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH3 + (i + 1) * distanceBetweenCells, LENGTH3, root);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells3[i][j].setTextClass(two);
            }
        }
        generalMovement.setN(3);
        assertEquals(18,generalMovement.sumCellNumbersToScore(cells3,score));
    }
    @Test
    void sumCellNumbersToScoreZero4() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells4[i][j] = new Cell((j) * LENGTH4 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH4 + (i + 1) * distanceBetweenCells, LENGTH4, root);
            }
        }
        generalMovement.setN(4);
        assertEquals(0,generalMovement.sumCellNumbersToScore(cells4,score));
    }
    @Test
    void sumCellNumbersToScoreAll4(){
        Text two = new Text("2");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells4[i][j] = new Cell((j) * LENGTH4 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH4 + (i + 1) * distanceBetweenCells, LENGTH4, root);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells4[i][j].setTextClass(two);
            }
        }
        generalMovement.setN(4);
        assertEquals(32,generalMovement.sumCellNumbersToScore(cells4,score));
    }
    @Test
    void sumCellNumbersToScoreZero5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells5[i][j] = new Cell((j) * LENGTH5 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH5 + (i + 1) * distanceBetweenCells, LENGTH5, root);
            }
        }
        generalMovement.setN(5);
        assertEquals(0,generalMovement.sumCellNumbersToScore(cells5,score));

    }
    @Test
    void sumCellNumbersToScoreAll5(){
        Text two = new Text("2");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells5[i][j] = new Cell((j) * LENGTH5 + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH5 + (i + 1) * distanceBetweenCells, LENGTH5, root);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells5[i][j].setTextClass(two);
            }
        }
        generalMovement.setN(5);
        assertEquals(50,generalMovement.sumCellNumbersToScore(cells5,score));
    }
}