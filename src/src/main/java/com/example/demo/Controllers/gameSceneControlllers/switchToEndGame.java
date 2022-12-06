package com.example.demo.Controllers.gameSceneControlllers;

import com.example.demo.Main;
import com.example.demo.endGameElements.EndGame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static com.example.demo.Controllers.sceneController.*;
public class switchToEndGame{
    private int cond;
    private long score;
    private Stage primaryStage;
    public switchToEndGame(int cond, long score, Stage primaryStage){
        this.cond=cond;
        this.score=score;
        this.primaryStage=primaryStage;
    }
    public void switchToScene(){
        Group endgameRoot = new Group();
        Scene endGameScene;
        if(!isDarkMode()) {
            endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(240, 240, 240));
        }
        else {
            endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(150,150,150));
        }
        primaryStage.setScene(endGameScene);
        EndGame endGame=null;
        if(cond==-1){
            endGame = new EndGame('l');
        } else if (cond == 0) {
            endGame = new EndGame('w');
        }
        endGame.endGameShow(endgameRoot,score,primaryStage);
    }
}
