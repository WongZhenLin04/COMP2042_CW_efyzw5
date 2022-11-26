package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import com.example.demo.gameElements.GameScene;

/**
 * Class acts as a general blueprint and foundation for movement based interactions throughout the game. The main responsibility of the class is to keep track of the user's score (as when
 * there is movement there might be a point in which the one or more pairs of cells merging), which involves the manipulation of the score as well, and to determine how the cells move
 * and shift as well. Class is never instantiated but is fully utilized by its inheritor, tileChecker.
 * @author Zhen Lin Wong
 */
public class generalMovement {
    private long score;
    protected int n = GameScene.getN();
    protected final tileChecker tileChecker = new tileChecker(n);
    /**
     * Method that sets the dimension value of the playing field.
     * @param n The dimension of the playing field to be set.
     */
    public void setN(int n) {
        this.n = n;
    }
    /**
     * Method used for returning the current score of the user. Used when the score is needed to be displayed for the user (i.e. updated)
     * @return The current score of the user at a given instance.
     */
    public long getScore() {
        return score;
    }
    /**
     * Method that is to change the score variable when it is called. Only used as an initializer when the game is created. Always initialized as 0
     * @param score The initial score from the GameScene that is to be set in the
     */
    public void setScore(long score) {
        this.score = score;
    }
    /**
     * Method that "moves" the tiles and is the main core for all the operations concerning horizontal movements. Generally, the method checks to see if the cells next to the targeted
     * cell in the direction that the user has set is valid for merging (by employing a method from the class tileChecker), if true, then the method will go ahead and merge the cells together, if false,
     * then the cell is swapped with the targeted cell by using the changeCell method.
     * @param cells The entire playing field that is to be modified.
     * @param i The row number of the targeted cell
     * @param j The column number of the targeted cell
     * @param des The targeted position of the "moving" cell. In this method specifically, it is the targeted column.
     * @param sign The direction in which the cell is moving in, used to determine if a merge is valid or not.
     */
    public void moveHorizontally(Cell[][] cells, int i, int j, int des, int sign) {
        if (tileChecker.isValidDesH(cells,i, j, des, sign)) {
            score=sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);

        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }
    /**
     * Method that "moves" the tiles and is the main core for all the operations concerning vertical movements. Generally, the method checks to see if the cells next to the targeted
     * cell in the direction that the user has set is valid for merging (by employing a method from the class tileChecker), if true, then the method will go ahead and merge the cells together, if false,
     * then the cell is swapped with the targeted cell by using the changeCell method.
     * @param cells The entire playing field that is to be modified.
     * @param i The row number of the targeted cell
     * @param j The column number of the targeted cell
     * @param des The targeted position of the "moving" cell. In this method specifically, it is the targeted column.
     * @param sign The direction in which the cell is moving in, used to determine if a merge is valid or not.
     */
    public void moveVertically(Cell[][] cells,int i, int j, int des, int sign) {
        if (tileChecker.isValidDesV(cells,i, j, des, sign)) {
            score=sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
    /**
     * Method sequentially goes through the tiles left to right for all the rows and grabs the value of each cell and adding them to the current score. This method is used only
     * and only when the user has made a successful merge with any pairs of cells.
     * @param cells The entirety of the cells to be traversed and analyzed.
     * @param score The current score the user has set, passed in from the GameScene class.
     * @return The sum of values in every cell within the playing field and the score made before the method was called.
     */
    public long sumCellNumbersToScore(Cell[][] cells,long score) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
        return score;
    }
}
