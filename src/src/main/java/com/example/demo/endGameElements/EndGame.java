package com.example.demo.endGameElements;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static com.example.demo.Controllers.getProfileSceneController.*;
import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;


public class EndGame {
    private long score;
    private endGameVisuals endGameVisuals = new endGameVisuals();
    private static EndGame singleInstance = null;
    private final String pathToScore="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\highScore.txt";
    private EndGame(){
    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }
    public String getHighscore(){
        try {
            File scoreFile = new File(pathToScore);
            Scanner reader = new Scanner(scoreFile);
            return reader.nextLine().split(":", 0)[1];
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return "0";
        }
    }
    public boolean newHighscore(){
        return Integer.parseInt(getHighscore()) < (score);
    }
    public void writeHighScore(){
        try {
            FileWriter writer = new FileWriter(pathToScore);
            writer.write(getAccountName()+":"+score);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void endGameShowLose(Group root, long score){
        this.score=score;
        if(newHighscore()){
            writeHighScore();
        }
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
