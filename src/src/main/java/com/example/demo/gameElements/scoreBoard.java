package com.example.demo.gameElements;

import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class scoreBoard {
    public void addScoreBoard(Group root, Text text){
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(850, 100);
    }
    public void initializeScore(Group root, Text text){
        root.getChildren().add(text);
        text.relocate(900, 200);
        text.setFont(Font.font(20));
        text.setText("0");
    }
}
