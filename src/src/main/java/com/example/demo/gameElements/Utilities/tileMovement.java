package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
/**
 * The Class is a specialised version and inheritor of the generalMovement class. The class's responsibilities involves with moving all cells within the playing field in a specific direction.
 * The class is instantiated within the GameScene class and the methods within the class are called upon when the user presses any of the directional arrows on their keyboard.
 */
public class tileMovement extends generalMovement {
    /**
     * Method analyzes cells from left to right by checking their final position after the left key is pressed by calling the "passDestination" method from the tileChecker class.
     * the cell is then moved horizontally by using the superclass' method "moveHorizontally". Method then sets all cells modified status as false so that the cell may be manipulated on the
     * next button press. Each cell shall move as far left as possible after each call of the "moveHorizontally" method.
     * @param cells The entirety of the playing field, cells within shall be moved as far left as possible.
     */
    public void moveLeft(Cell[][] cells) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                moveHorizontally(cells,i, j, tileChecker.passDestination(cells,i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    /**
     * Method analyzes cells from right to left by checking their final position after the right key is pressed by calling the "passDestination" method from the tileChecker class.
     * the cell is then moved horizontally by using the superclass' method "moveHorizontally". Method then sets all cells modified status as false so that the cell may be manipulated on the
     * next button press. Each cell shall move as far right as possible after each call of the "moveHorizontally" method.
     * @param cells The entirety of the playing field, cells within shall be moved as far right as possible.
     */
    public void moveRight(Cell[][] cells) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                moveHorizontally(cells,i, j, tileChecker.passDestination(cells,i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                cells[i][j].setModify(false);
            }
        }
    }
    /**
     * Method analyzes cells from top to bottom by checking their final position after the up key is pressed by calling the "passDestination" method from the tileChecker class.
     * the cell is then moved vertically by using the superclass' method "moveVertically". Method then sets all cells modified status as false so that the cell may be manipulated on the
     * next button press. Each cell shall move as far up as possible after each call of the "moveVertically" method.
     * @param cells The entirety of the playing field, cells within shall be moved as far up as possible.
     */
    public void moveUp(Cell[][] cells) {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                moveVertically(cells,i, j, tileChecker.passDestination(cells,i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
    /**
     * Method analyzes cells from bottom to top by checking their final position after the down key is pressed by calling the "passDestination" method from the tileChecker class.
     * The cell is then moved vertically by using the superclass' method "moveVertically". Method then sets all cells modified status as false so that the cell may be manipulated on the
     * next button press. Each cell shall move as far down as possible after each call of the "moveVertically" method.
     * @param cells The entirety of the playing field, cells within shall be moved as far down as possible.
     */
    public void moveDown(Cell[][] cells) {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                moveVertically(cells,i, j, tileChecker.passDestination(cells,i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                cells[i][j].setModify(false);
            }
        }

    }
}
