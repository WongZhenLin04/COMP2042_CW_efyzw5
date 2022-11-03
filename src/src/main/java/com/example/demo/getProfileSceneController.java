package com.example.demo;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class getProfileSceneController extends sceneController{
    @Override
    public void switchToScene() throws IOException {
        setSetModeRoot(modeSelLoader.load());
        setSetModeScene(new Scene(modeRoot, Main.WIDTH, Main.HEIGHT));
        primaryStage.setScene(modeScene);
    }

    @Override
    public void detectEvent(Event event) throws IOException {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchToScene();
    }
}
