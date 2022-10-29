package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneController {
    private int DogeKeysPressed=0;
    private Stage primaryStage;
    private Group gameRoot;
    private Scene gameScene;
    private Parent getAccountRoot;
    private Scene getAccountScene;

    public int getDogeKeysPressed() {
        return DogeKeysPressed;
    }
    public void setDogeKeysPressed(int dogeKeysPressed) {
        this.DogeKeysPressed = dogeKeysPressed;
    }
    public void dogeKeyIncrement() {
        this.DogeKeysPressed += 1;
    }
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    public void setGetAccountRoot(Parent getAccountRoot) {
        this.getAccountRoot = getAccountRoot;
    }
    public void setGetAccountScene(Scene getAccountScene) {
        this.getAccountScene = getAccountScene;
    }
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage=primaryStage;
    }
    public void switchFromProfileToGame(){
        setGameRoot(new Group());
        setGameScene(new Scene(gameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(189, 177, 92)));
        GameScene game = new GameScene();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(250, 20, 100, 0.2));
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setScene(gameScene);
    }
    public void switchFromMenuToProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("accountsScene.fxml"));
        setGetAccountRoot(loader.load());
        setGetAccountScene(new Scene(getAccountRoot, Main.WIDTH, Main.HEIGHT));
        primaryStage.setScene(getAccountScene);
    }
    public void detectStartButton(Event event) throws IOException{
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchFromMenuToProfile();
    }
    public void detectAccountChosen(Event event) throws IOException{
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchFromProfileToGame();
    }
}
