package com.example.demo.endGameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static com.example.demo.Controllers.getProfileSceneController.*;
import static com.example.demo.Controllers.modeSelectSceneController.*;
public class endGameVisuals {
    private final Button quitButton = new Button("QUIT");
    private final Text title = new Text("GAME OVER");
    private final Text newHighScoreText = new Text("IT'S A NEW HIGHSCORE!\nSet by: "+ getAccountName()+"\nFor mode: "+getChoice());
    public Button getQuitButton() {
        return quitButton;
    }
    public void setEndTitle(Group root){
        title.relocate(150,150);
        title.setFont(Font.font(80));
        title.setFill(Color.WHITE);
        root.getChildren().add(title);
    }
    public void setEndScore(Group root,long score){
        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.WHITE);
        scoreText.relocate(150,250);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);
    }
    public void setEndButton(Group root){
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(150,325);
    }
    public void setNewHighScore(Group root){
        newHighScoreText.setFill(Color.WHITE);
        newHighScoreText.relocate(150,450);
        newHighScoreText.setFont(Font.font(80));
        root.getChildren().add(newHighScoreText);
    }
    public void makeBgRekt(Group root){
        Rectangle bgRekt = new Rectangle();
        bgRekt.setFill(Color.rgb(153, 173, 168));
        bgRekt.setHeight(Main.HEIGHT-100);
        bgRekt.setWidth(Main.WIDTH-200);
        root.getChildren().add(bgRekt);
        bgRekt.setX(100);
        bgRekt.setY(50);
    }
}
