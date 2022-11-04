package com.example.demo;

public class stateChecker {
    public int haveEmptyCell(Cell[][] cells,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }
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
}
