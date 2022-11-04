package com.example.demo;

import static com.example.demo.GameScene.n;

public class movement {
    private long score;
    private final tileChecker tileChecker = new tileChecker();
    public long getScore() {
        return score;
    }
    public void setScore(long score) {
        this.score = score;
    }
    private void moveHorizontally(Cell[][] cells,int i, int j, int des, int sign) {
        if (tileChecker.isValidDesH(cells,i, j, des, sign)) {
            score=sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);

        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }
    private void moveVertically(Cell[][] cells,int i, int j, int des, int sign) {
        if (tileChecker.isValidDesV(cells,i, j, des, sign)) {
            score=sumCellNumbersToScore(cells,score);
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
    public long sumCellNumbersToScore(Cell[][] cells,long score) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
        return score;
    }
}
