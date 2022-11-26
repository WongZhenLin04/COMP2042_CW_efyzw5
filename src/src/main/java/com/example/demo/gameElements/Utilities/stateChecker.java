package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import com.example.demo.gameElements.GameScene;
/**
 * The class is concerned with the operations that happens within the game, more specifically it determines the state the game is in at the time that any of the method from within
 * the class is called. Class is utilized to determine weather the state of the game needs to be manipulated in order to return the game into a state where it is functioning properly and
 * as intended.
 * @author Zhen Lin Wong
 */
public class stateChecker {
    private int n = GameScene.getN();
    /**
     * Method for determining if there is an empty cell (meaning a cell that has the value 0 within in) and if there exists a cell that has the value 2048 within it. Essentially,the
     * method is used for determining the win and lose condition of the game and is used after every single key press (as any move could lead to a win or a lost). Works by scanning the
     * playing field from left to right for all rows.
     * @param cells The entirety of the playing field to be analyzed.
     * @param n The size of the playing field, used to determine the boundaries of the game while traversing the cells.
     * @return <code>1</code> means that there exists an empty cell and the user can continue playing.
     *         <code>0</code> means that there exists a cell that holds the value 2048 and the user has won.
     *         <code>-1</code> means that there are no empty cells and the user has lost.
     */
    public int haveEmptyCell(Cell[][] cells, int n) {
        int res=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    res = 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return res;
    }
    /**
     * Method is used to check if the user's move is a static move, meaning that if when pressing a key to move, none of the cells move (no changing in position) or merge.
     * The use in the method lies in preventing the game from creating more and more cells if the user presses and holds a key, also prevents it from overwhelming the user with too
     * many tiles within the game scene and making the likelihood of loosing less likely. Works by determining the direction the cell is moving in, and checking to see if there are any pairs of
     * cells that are able to merge or if there exists an empty space when using the move that the user is making. It is important to note that the way the playing field is analyzed is dependent on the direction on the move that the
     * user has made (same way the method "passDestination" in the class "tileChecker" analyzes the playing field).
     * @param cells The entirety of the playing field that is to be analyzed by the method.
     * @param direction The direction in which the user has commanded the cells to move in. Used determining how the playing field is analyzed.
     * @param n The size of the playing field, used in determining the boundaries of the analysis.
     * @return <code>true</code>, means that making that particular move will result in the cells not moving or merging.
     *         <code>false</code>, means that making that particular move will result in making at least one cell moving or one pair of cells merging.
     */
    public boolean isStaticMove(Cell[][] cells, char direction, int n){
        switch (direction){
            case 'r':{
                for (int i = 0; i < n; i++) {
                    for (int j = n - 2; j >= 0; j--) {
                        if(cells[i][j].getNumber()!=0) {
                            if ((cells[i][j + 1].getNumber() == 0) | (cells[i][j].getNumber() == cells[i][j + 1].getNumber())) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            case 'l':{
                for (int i = 0; i < n; i++) {
                    for (int j = 1; j < n; j++) {
                        if(cells[i][j].getNumber()!=0) {
                            if ((cells[i][j - 1].getNumber() == 0) | (cells[i][j].getNumber() == cells[i][j - 1].getNumber())) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            case 'u': {
                for (int j = 0; j < n; j++) {
                    for (int i = 1; i < n; i++) {
                        if (cells[i][j].getNumber() != 0) {
                            if ((cells[i - 1][j].getNumber() == 0) | (cells[i][j].getNumber() == cells[i - 1][j].getNumber())) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            case 'd':{
                for (int j = 0; j < n; j++) {
                    for (int i = n - 2; i >= 0; i--) {
                        if (cells[i][j].getNumber() != 0) {
                            if ((cells[i + 1][j].getNumber() == 0) | (cells[i][j].getNumber() == cells[i + 1][j].getNumber())) {
                                return false;
                            }
                        }
                    }
                }
            }
            default:{return true;}
        }
    }
    /**
     * Method is used to identify if there are any valid merges to be made. It is employed when the playing field has no more empty tiles and a decision to end the game is needed to be
     * made.The losing state of the game shall be dictated by this method and this method alone. Works by scanning the cells from left to right for all rows and employing the method "haveSameNumberNearly",
     * which is used to check if there are any valid merges to be made.
     * @param cells The entirety of the playing field to be analyzed.
     * @return <code>true</code> if there are no valid moves to be made when the playing field is full and informs the GameScene class to switch to the GameEnd scene with the losing condition.
     *         <code>false</code> if there are cells to be merged, i.e. there is a valid move to be made even though the playing field is full.
     */
    public boolean canNotMove(Cell[][] cells) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(cells,i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Method is to check if neighbouring cells are able to merge with the currently analysed cell. The operations of the cell are to check the cell bellow and the cell to the right of the cell
     * that is currently being analysed are equal. Method is only used by another method within the same class which is the method "canNotMove".
     * @param cells The entirety of the playing field to be analyzed.
     * @param i The row number of the cell
     * @param j The column number of the cell
     * @return <code>true</code> means that either the cells beneath or under the currently analysed cell is equal to the value of the analysed cell.
     *         <code>false</code> neither cells beneath nor under the currently analysed cell is equal to the value of the analysed cell.
     */
    public boolean haveSameNumberNearly(Cell[][] cells,int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }
}
