package com.example.demo.gameElements.Utilities;

import com.example.demo.gameElements.Cell;
import com.example.demo.gameElements.GameScene;

public class tileMovement extends generalMovement {
    private int n = GameScene.getN();
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
