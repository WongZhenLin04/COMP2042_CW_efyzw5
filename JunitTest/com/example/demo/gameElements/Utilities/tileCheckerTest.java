package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static com.example.demo.gameElements.GameScene.LENGTH;
import static com.example.demo.gameElements.GameScene.distanceBetweenCells;
import static org.junit.jupiter.api.Assertions.*;

class tileCheckerTest {
    private int n = 4;
    tileChecker tileChecker = new tileChecker(n);
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
    void passDestinationInvalid() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertEquals(-1,tileChecker.passDestination(testCell,0,0,'h'));
    }
    @Test
    void passDestinationBoundL() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[3][3].setTextClass(new Text("2"));
        assertEquals(0,tileChecker.passDestination(testCell,3,3,'l'));
    }
    @Test
    void passDestinationCellL() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[3][3].setTextClass(new Text("2"));
        testCell[3][0].setTextClass(new Text("2"));
        assertEquals(1,tileChecker.passDestination(testCell,3,3,'l'));
    }
    @Test
    void passDestinationBoundR() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        assertEquals(3,tileChecker.passDestination(testCell,0,0,'r'));
    }
    @Test
    void passDestinationCellR() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[0][3].setTextClass(new Text("2"));
        assertEquals(2,tileChecker.passDestination(testCell,0,0,'r'));
    }
    @Test
    void passDestinationBoundU() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[3][0].setTextClass(new Text("2"));
        assertEquals(0,tileChecker.passDestination(testCell,3,0,'u'));
    }
    @Test
    void passDestinationCellU() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[3][0].setTextClass(new Text("2"));
        testCell[0][0].setTextClass(new Text("2"));
        assertEquals(1,tileChecker.passDestination(testCell,3,0,'u'));
    }
    @Test
    void passDestinationBoundD() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        assertEquals(3,tileChecker.passDestination(testCell,0,0,'d'));
    }
    @Test
    void passDestinationCellD() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[3][0].setTextClass(new Text("2"));
        assertEquals(2,tileChecker.passDestination(testCell,0,0,'d'));
    }
    @Test
    void isValidDesVTrue() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[3][0].setTextClass(new Text("2"));
        assertTrue(tileChecker.isValidDesV(testCell,0,0, tileChecker.passDestination(testCell,0,0,'d'),1));
    }
    @Test
    void isValidDesVFalse() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[3][0].setTextClass(new Text("3"));
        assertFalse(tileChecker.isValidDesV(testCell,0,0, tileChecker.passDestination(testCell,0,0,'d'),1));
    }
    @Test
    void isValidDesVBoundary() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        assertFalse(tileChecker.isValidDesV(testCell,0,0, tileChecker.passDestination(testCell,0,0,'d'),1));
    }
    @Test
    void isValidDesHTrue() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[0][3].setTextClass(new Text("2"));
        assertTrue(tileChecker.isValidDesH(testCell,0,0, tileChecker.passDestination(testCell,0,0,'r'),1));
    }
    @Test
    void isValidDesHFalse() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[0][3].setTextClass(new Text("3"));
        assertFalse(tileChecker.isValidDesH(testCell,0,0, tileChecker.passDestination(testCell,0,0,'r'),1));
    }
    @Test
    void isValidDesHBoundary() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        assertFalse(tileChecker.isValidDesH(testCell,0,0, tileChecker.passDestination(testCell,0,0,'r'),1));
    }
}