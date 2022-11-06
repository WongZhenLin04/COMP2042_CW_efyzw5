package com.example.demo.endGameElements;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class endGameVisuals {
    private Button quitButton = new Button("QUIT");
    private Text title = new Text("GAME OVER");
    public Button getQuitButton() {
        return quitButton;
    }
    public void setEndTitle(Group root){
        title.relocate(250,250);
        title.setFont(Font.font(80));
        root.getChildren().add(title);
    }
    public void setEndScore(Group root,long score){
        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,600);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);
    }
    public void setEndButton(Group root){
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.PINK);
        root.getChildren().add(quitButton);
        quitButton.relocate(100,300);
    }
}
