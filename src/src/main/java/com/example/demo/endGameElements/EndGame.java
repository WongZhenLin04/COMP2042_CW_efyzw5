package com.example.demo.endGameElements;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import java.util.Optional;

public class EndGame {
    private final endGameVisuals endGameVisuals = new endGameVisuals();
    private static EndGame singleInstance = null;
    private final highScore highScore = new highScore();
    private EndGame(){
    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }
    public void endGameShowLose(Group root, long score){
        /*
        if(highScore.newHighscore(score)){
            endGameVisuals.setNewHighScore(root);
            highScore.writeHighScore(score);
        }
         */
        highScore.writeHighScore(score);
        endGameVisuals.setEndTitle(root);
        endGameVisuals.setEndScore(root,score);
        endGameVisuals.setEndButton(root);
        endGameVisuals.getQuitButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                }
            }
        });
    }
}
