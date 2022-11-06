package com.example.demo.Controllers;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

abstract public class sceneController {
    private int DogeKeysPressed=0;
    protected Stage primaryStage;
    protected Group gameRoot;
    protected Scene gameScene;
    protected Parent getAccountRoot;
    protected Scene getAccountScene;
    protected final FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("FXMLFiles/accountsScene.fxml"));
    protected final FXMLLoader modeSelLoader = new FXMLLoader(getClass().getResource("FXMLFiles/gameModeSelect.fxml"));
    protected Parent modeRoot;
    protected Scene modeScene;
    public void setSetModeRoot(Parent setModeRoot) {
        this.modeRoot = setModeRoot;
    }
    public void setSetModeScene(Scene setModeScene) {
        this.modeScene = setModeScene;
    }
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
    public abstract void switchToScene() throws IOException;
    public abstract void detectEvent(Event event) throws IOException;

}
