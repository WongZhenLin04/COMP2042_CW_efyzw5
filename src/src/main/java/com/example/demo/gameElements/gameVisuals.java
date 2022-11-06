package com.example.demo.gameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class gameVisuals {
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
    public void makeBgRekt(Group root){
        Rectangle bgrekt = new Rectangle();
        bgrekt.setFill(Color.rgb(186, 186, 186));
        bgrekt.setHeight(Main.HEIGHT-40);
        bgrekt.setWidth(Main.WIDTH-500);
        root.getChildren().add(bgrekt);
        bgrekt.setX(-25);
        bgrekt.setY(-15);
    }
}
