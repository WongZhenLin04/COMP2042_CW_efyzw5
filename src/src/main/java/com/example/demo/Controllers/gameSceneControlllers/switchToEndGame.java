package com.example.demo.Controllers.gameSceneControlllers;

import com.example.demo.Main;
import com.example.demo.endGameElements.EndGame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static com.example.demo.Controllers.sceneController.*;
/**
 * Class is used in GameScene and is used to switch to the end game scene by instantiating the end game scene first with the correct condition.
 */
public class switchToEndGame{
    private int cond;
    private long score;
    private Stage primaryStage;
    /**
     * The constructor of the class, sets the end game conditions when it's instantiated.
     * @param cond The state of the game that was ended upon. Two possible values <code>0</code> indicating that the user has won, <code>-1</code> indicates that the user has lost and has no more valid moves to make.
     * @param score The score that the user has ended the game with.
     * @param primaryStage The stage on which the scenes and elements play out.
     */
    public switchToEndGame(int cond, long score, Stage primaryStage){
        this.cond=cond;
        this.score=score;
        this.primaryStage=primaryStage;
    }
    /**
     * Method that switches the Game scene to the end game scene based on the given conditions that the user has ended the game with.
     */
    public void switchToEndGame(){
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
