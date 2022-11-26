package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static com.example.demo.gameElements.GameScene.LENGTH;
import static com.example.demo.gameElements.GameScene.distanceBetweenCells;
import static org.junit.jupiter.api.Assertions.*;

class tileMovementTest {
    private int n = 4;
    tileMovement tileMovement = new tileMovement();
    private Cell[][] cells = new Cell[n][n];
    private Group root = new Group();
    private Cell[][] makeEmptyCell(Cell[][] cells){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }
        }
        return cells;
    }
    @Test
    void moveLeft() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i = 0;i<n;i++){
            testCell[i][3].setTextClass(new Text("2"));
            testCell[i][3].setModify(true);
        }
        tileMovement.moveLeft(testCell);
        for(int i = 0;i<n;i++){
            assertEquals(2,testCell[i][0].getNumber());
            assertFalse(testCell[i][0].getModify());
        }
    }
    @Test
    void moveRight() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i = 0;i<n;i++){
            testCell[i][0].setTextClass(new Text("2"));
            testCell[i][0].setModify(true);
        }
        tileMovement.moveRight(testCell);
        for(int i = 0;i<n;i++){
            assertEquals(2,testCell[i][3].getNumber());
            assertFalse(testCell[i][3].getModify());
        }
    }

    @Test
    void moveUp() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int k = 0;k<n;k++){
            testCell[3][k].setTextClass(new Text("2"));
            testCell[3][k].setModify(true);
        }
        tileMovement.moveUp(testCell);
        for(int k = 0;k<n;k++){
            assertEquals(2,testCell[0][k].getNumber());
            assertFalse(testCell[0][k].getModify());
        }
    }
    @Test
    void moveDown() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int k = 0;k<n;k++){
            testCell[0][k].setTextClass(new Text("2"));
            testCell[0][k].setModify(true);
        }
        tileMovement.moveDown(testCell);
        for(int k = 0;k<n;k++){
            assertEquals(2,testCell[3][k].getNumber());
            assertFalse(testCell[3][k].getModify());
        }
    }
}