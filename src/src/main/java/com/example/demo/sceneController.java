package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneController {
    private Stage primaryStage;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(189, 177, 92));
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage=primaryStage;
    }
    public void switchFromMenuToGame(){
        GameScene game = new GameScene();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(250, 20, 100, 0.2));
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setScene(gameScene);
    }
    public void detectButton(ActionEvent event) throws IOException{
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchFromMenuToGame();
    }
}
