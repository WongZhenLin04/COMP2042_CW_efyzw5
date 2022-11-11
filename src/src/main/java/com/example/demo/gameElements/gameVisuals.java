package com.example.demo.gameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class gameVisuals {
    public void addScoreText(Group root, Text text){
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.setFill(Color.rgb(81, 84, 82));
        text.relocate(850, 100);
    }
    public void initializeScore(Group root, Text text){
        root.getChildren().add(text);
        text.relocate(900, 200);
        text.setFont(Font.font(20));
        text.setFill(Color.rgb(81, 84, 82));
        text.setText("0");
    }
    public void makeBgRekt(Group root){
        Rectangle bgRekt = new Rectangle();
        bgRekt.setFill(Color.rgb(153, 173, 168));
        bgRekt.setHeight(Main.HEIGHT-40);
        bgRekt.setWidth(Main.WIDTH-500);
        root.getChildren().add(bgRekt);
        bgRekt.setX(-25);
        bgRekt.setY(-15);
    }
    public void makeScoreRekt(Group root){
        Rectangle scoreRekt = new Rectangle();
        Rectangle border = new Rectangle();
        scoreRekt.setFill(Color.rgb(252, 252, 252));
        border.setFill(Color.rgb(153, 173, 168));
        scoreRekt.setWidth(250);
        scoreRekt.setHeight(150);
        border.setWidth(260);
        border.setHeight(160);
        root.getChildren().add(border);
        border.relocate(800, 85);
        root.getChildren().add(scoreRekt);
        scoreRekt.relocate(805, 90);
    }
}
