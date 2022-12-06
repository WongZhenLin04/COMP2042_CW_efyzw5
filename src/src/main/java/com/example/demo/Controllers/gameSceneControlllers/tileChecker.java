package com.example.demo.Controllers.gameSceneControlllers;

import com.example.demo.gameElements.Cell;
/**
 * The Class "tileChecker" has the distinct responsibility of conducting where the cells should go and if the cell moving in a certain direction are eligible for a merge operation.
 * It is instantiated in the generalMovement class and is considered to be a core part of the operations within the class as this is the class for analysing the target locations of cells
 * whenever the user has pressed a key for the movement of cells. Decisions about updating the user's score is also made here.
 * @author Zhen Lin Wong
 */
public class tileChecker{
    private int n;
    /**
     * The constructor of the class. It is a requirement that the class knows the boundaries of the playing field, hence why it is passed into the class when it is instantiated in the general movement
     * class.
     * @param n The size of the playing field. Acts as a boundary for analysis.
     */
    public tileChecker(int n){
        this.n=n;
    }
    /**
     * Method to determine the location of where the contents of a given cell should be swapped to when the user makes a move in any direction. Generally, the method gets the position of the input
     * cell as a parameter and depending on the direction, will analyse the furthest a cell can move until it either hits another cell or till it his a boundary, then the position (row or column) of
     * the last accessed cell is returned. For horizontal movements the row of the current cell is analysed, while for vertical movements the column of the cell is analysed.
     * @param cells The entirety of the playing field to be analysed and manipulated.
     * @param i The row number of the currently analysed cell.
     * @param j The column number of the currently analysed cell.
     * @param direct The direction in which the user has dictated the cells to move in. There only exists 4 possible inputs, 'l' for left, 'r' for right, 'u' for up and 'd' for down.
     * @return The targeted row or column the cell should swap with. Row number for vertical movements and column number for horizontal movement.
     */
    public int passDestination(Cell[][] cells, int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }
    /**
     * Method that is used for cells that are moving vertically and wants to check the neighbouring cell if it's valid for merging (i.e. both cells have equal value). Method is used for
     * determining if user's score needs to be incremented and if two cells are valid for merging in the class "generalMovement". The operations of the method works as such, checks to
     * see if the next step (depending on the value of sign) leads to being out of bounds, if not the method checks the cell that is above (when sign is equal to -1) contains the same
     * value as the cell at position (1,j), same process for the cell bellow if the sign is equal to 1.
     * @param cells The entirety of the playing field to be analysed.
     * @param i The row number of the currently analysed cell.
     * @param j The column number of the currently analysed cell.
     * @param des The row of the cell that the currently analysed cell intends to move to.
     * @param sign The direction in which the cell is moving in, used in determining if the cell bellow or above should be analysed. 1 for bellow and -1 for above.
     * @return <code>true</code> means that the pair of cells are equal and can proceed with merging and subsequently the increment of the user's score should happen.
     *         <code>false</code> means that the pair of cells are not equal and therefore no merging should occur.
     */
    public boolean isValidDesV(Cell[][] cells,int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }
    /**
     * Method that is used for cells that are moving horizontally and wants to check the neighbouring cell if it's valid for merging (i.e. both cells have equal value). Method is used for
     * determining if user's score needs to be incremented and if two cells are valid for merging in the class "generalMovement". The operations of the method works as such, checks to
     * see if the next step (depending on the value of sign) leads to being out of bounds, if not the method checks the cell that is to the left (when sign is equal to -1) contains the same
     * value as the cell at position (1,j), same process for the cell to the right if the sign is equal to 1.
     * @param cells The entirety of the playing field to be analysed.
     * @param i The row number of the currently analysed cell.
     * @param j The column number of the currently analysed cell.
     * @param des The column of the cell that the currently analysed cell intends to move to.
     * @param sign The direction in which the cell is moving in, used in determining if the cell to the right or to the left should be analysed. 1 for right and -1 for left.
     * @return <code>true</code> means that the pair of cells are equal and can proceed with merging and subsequently the increment of the user's score should happen.
     *         <code>false</code> means that the pair of cells are not equal and therefore no merging should occur.
     */
    public boolean isValidDesH(Cell[][] cells,int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }
}
