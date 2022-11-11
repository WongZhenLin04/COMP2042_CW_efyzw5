package com.example.demo.Controllers;

import com.example.demo.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class mainMenuController extends sceneController {
    private final FXMLLoader specialMenuLoader = new FXMLLoader(getClass().getResource("FXMLFiles/specialMainMenu.fxml"));
    @Override
    public void switchToScene() throws IOException {
        setGetAccountRoot(accountLoader.load());
        setGetAccountScene(new Scene(getAccountRoot, Main.WIDTH, Main.HEIGHT));
        getAccountScene.getStylesheets().add(css);
        primaryStage.setScene(getAccountScene);
    }

    public void switchToSpecialMenu(){
        try {
            Parent specialMenuRoot = specialMenuLoader.load();
            Scene specialMenuScene = new Scene(specialMenuRoot, Main.WIDTH, Main.HEIGHT);
            specialMenuScene.getStylesheets().add(css);
            primaryStage.setScene(specialMenuScene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
