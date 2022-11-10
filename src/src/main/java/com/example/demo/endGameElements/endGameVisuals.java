package com.example.demo.endGameElements;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class endGameVisuals {
    private final Button quitButton = new Button("QUIT");
    private final Text title = new Text("GAME OVER");
    private final Text newHighScoreText = new Text("IT'S A NEW HIGHSCORE!");
    public Button getQuitButton() {
        return quitButton;
    }
    public void setEndTitle(Group root){
        title.relocate(250,250);
        title.setFont(Font.font(80));
        root.getChildren().add(title);
    }
    public void setEndScore(Group root,long score){
        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,350);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);
    }
    public void setEndButton(Group root){
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.PINK);
        root.getChildren().add(quitButton);
        quitButton.relocate(250,450);
    }
    public void setNewHighScore(Group root){
        newHighScoreText.setFill(Color.BLACK);
        newHighScoreText.relocate(250,550);
        newHighScoreText.setFont(Font.font(80));
        root.getChildren().add(newHighScoreText);
    }
}
