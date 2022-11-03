package com.example.demo;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainMenuController extends sceneController{
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
}
