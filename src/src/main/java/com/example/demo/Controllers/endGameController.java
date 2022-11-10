package com.example.demo.Controllers;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.IOException;

public class endGameController extends sceneController{
    @Override
    public void switchToScene() throws IOException {
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(250, 20, 100, 0.2));

    }
}
