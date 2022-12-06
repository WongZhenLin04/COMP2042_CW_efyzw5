package com.example.demo.Controllers.gameSceneControlllers;

import com.example.demo.Controllers.gameSceneControlllers.stateChecker;
import com.example.demo.gameElements.Cell;
import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;
import static com.example.demo.gameElements.GameScene.LENGTH;
import static com.example.demo.gameElements.GameScene.distanceBetweenCells;
import static org.junit.jupiter.api.Assertions.*;

class stateCheckerTest {
    private int n = 4;
    com.example.demo.Controllers.gameSceneControlllers.stateChecker stateChecker = new stateChecker();
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
    void haveEmptyCellAll() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertEquals(1,stateChecker.haveEmptyCell(testCell,n));
    }
    @Test
    void haveEmptyCellWin() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[3][3].setTextClass(new Text("2048"));
        assertEquals(0,stateChecker.haveEmptyCell(testCell,n));
    }
    @Test
    void haveEmptyCellFilled() {
        Cell[][] testCell=makeEmptyCell(cells);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                testCell[i][j].setTextClass(new Text("2"));
            }
        }
        assertEquals(-1,stateChecker.haveEmptyCell(testCell,n));
    }
    @Test
    void haveEmptyCellOne() {
        Cell[][] testCell=makeEmptyCell(cells);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                testCell[i][j].setTextClass(new Text("2"));
            }
        }
        testCell[3][3].setTextClass(new Text("0"));
        assertEquals(1,stateChecker.haveEmptyCell(testCell,n));
    }
    @Test
    void isStaticMoveValEmptyL() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertTrue(stateChecker.isStaticMove(testCell,'l',n));
    }
    @Test
    void isStaticMoveOneValL() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[1][1].setTextClass(new Text("2"));
        assertFalse(stateChecker.isStaticMove(testCell,'l',n));
    }
    @Test
    void isStaticMoveInvalL() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i=0;i<n;i++){
            testCell[i][0].setTextClass(new Text("2"));
        }
        assertTrue(stateChecker.isStaticMove(testCell,'l',n));
    }
    @Test
    void isStaticMoveValEmptyR() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertTrue(stateChecker.isStaticMove(testCell,'r',n));
    }
    @Test
    void isStaticMoveValOneR() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[1][1].setTextClass(new Text("2"));
        assertFalse(stateChecker.isStaticMove(testCell,'r',n));
    }
    @Test
    void isStaticMoveInvalR() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i=0;i<n;i++){
            testCell[i][3].setTextClass(new Text("2"));
        }
        assertTrue(stateChecker.isStaticMove(testCell,'r',n));
    }
    @Test
    void isStaticMoveValEmptyU() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertTrue(stateChecker.isStaticMove(testCell,'u',n));
    }
    @Test
    void isStaticMoveValOneU() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[1][1].setTextClass(new Text("2"));
        assertFalse(stateChecker.isStaticMove(testCell,'u',n));
    }
    @Test
    void isStaticMoveInvalU() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int k=0;k<n;k++){
            testCell[0][k].setTextClass(new Text("2"));
        }
        assertTrue(stateChecker.isStaticMove(testCell,'u',n));
    }
    @Test
    void isStaticMoveValEmptyD() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertTrue(stateChecker.isStaticMove(testCell,'d',n));
    }
    @Test
    void isStaticMoveValOneD() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[1][1].setTextClass(new Text("2"));
        assertFalse(stateChecker.isStaticMove(testCell,'d',n));
    }
    @Test
    void isStaticMoveInvalD() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int k=0;k<n;k++){
            testCell[3][k].setTextClass(new Text("2"));
        }
        assertTrue(stateChecker.isStaticMove(testCell,'d',n));
    }
    @Test
    void canNotMoveEmpty() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertFalse(stateChecker.canNotMove(testCell));
    }
    @Test
    void canNotMoveFullTrue() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i = 0;i<n;i++){
            for (int k = 0;k<n;k++){
                if((i+k)%2==0){
                    testCell[i][k].setTextClass(new Text("2"));
                }
                else {
                    testCell[i][k].setTextClass(new Text("4"));
                }
            }
        }
        assertTrue(stateChecker.canNotMove(testCell));
    }
    @Test
    void canNotMoveFullFalse() {
        Cell[][] testCell=makeEmptyCell(cells);
        for(int i = 0;i<n;i++){
            for (int k = 0;k<n;k++){
                if(i%2==0){
                    testCell[i][k].setTextClass(new Text("2"));
                }
                else {
                    testCell[i][k].setTextClass(new Text("4"));
                }
            }
        }
        assertFalse(stateChecker.canNotMove(testCell));
    }
    @Test
    void haveSameNumberNearlyInvalIn() {
        Cell[][] testCell=makeEmptyCell(cells);
        assertFalse(stateChecker.haveSameNumberNearly(testCell,4,4));
    }
    @Test
    void haveSameNumberNearlyDown() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[1][0].setTextClass(new Text("2"));
        assertTrue(stateChecker.haveSameNumberNearly(testCell,0,0));
    }
    @Test
    void haveSameNumberNearlyRight() {
        Cell[][] testCell=makeEmptyCell(cells);
        testCell[0][0].setTextClass(new Text("2"));
        testCell[0][1].setTextClass(new Text("2"));
        assertTrue(stateChecker.haveSameNumberNearly(testCell,0,0));
    }
}