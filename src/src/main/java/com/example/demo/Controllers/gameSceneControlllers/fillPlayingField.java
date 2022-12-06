package com.example.demo.Controllers.gameSceneControlllers;

import com.example.demo.gameElements.Cell;
import javafx.scene.Group;
import javafx.scene.text.Text;
import com.example.demo.gameElements.TextMaker;
import java.util.Random;
/**
 * Class that handles new cell fill operations, meaning that it handles the occasion of when a random cell needs to be changed to a non-zero value.
 */
public class fillPlayingField {
    TextMaker textMaker;
    public fillPlayingField() {
        textMaker = TextMaker.getSingleInstance();
    }
    /**
     * Method that gets a random empty cell and fills it with properties that'll make the previously empty cell into either a 2 or 4 cell. This is done so by creating the area of which empty
     * cells exists and also creating the boundary variables for both the X and Y position. 3 random integers are then generated, two for the X and Y values (that are in between their respective bounds)
     * for the targeted cell and one for determining if 2 or 4 shall be the value of the targeted cell.
     * @param cells The entirety of the playing field.
     * @param n The value of the dimension of the playing field with n x n dimensions.
     * @param root The elements that are contained within a scene.
     */
    public void randomFillNumber(Cell[][] cells, int n, Group root) {
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
}
