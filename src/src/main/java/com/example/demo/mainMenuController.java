package com.example.demo;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainMenuController extends sceneController{
    private final FXMLLoader specialMenuLoader = new FXMLLoader(getClass().getResource("specialMainMenu.fxml"));

    @Override
    public void switchToScene() throws IOException {
        setGetAccountRoot(accountLoader.load());
        setGetAccountScene(new Scene(getAccountRoot, Main.WIDTH, Main.HEIGHT));
        primaryStage.setScene(getAccountScene);
    }

    @Override
    public void detectEvent(Event event) throws IOException {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchToScene();
    }
    public void switchToSpecialMenu(){
        try {
            Parent specialMenuRoot = specialMenuLoader.load();
            Scene specialMenuScene = new Scene(specialMenuRoot, Main.WIDTH, Main.HEIGHT);
            String css = this.getClass().getResource("menuStyle.css").toExternalForm();
            specialMenuScene.getStylesheets().add(css);
            primaryStage.setScene(specialMenuScene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
