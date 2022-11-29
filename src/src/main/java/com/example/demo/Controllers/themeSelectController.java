package com.example.demo.Controllers;

import com.example.demo.Main;
import com.example.demo.gameElements.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class themeSelectController extends sceneController implements Initializable {
    @FXML
    private ChoiceBox<String> themeSelectBox;
    private final String[] themes = {"Dark Mode","Light Mode"};
    private static String choice="Light Mode";
    private Parent profileSelectRoot;
    private Scene profileSelectScene;
    private final FXMLLoader profileSelectLoader = new FXMLLoader(getClass().getResource("FXMLFiles/accountsScene.fxml"));
    @Override
    public void switchToScene() throws IOException {
        setProfileSelectRoot(profileSelectLoader.load());
        setProfileSelectScene(new Scene(profileSelectRoot, Main.WIDTH, Main.HEIGHT));
        profileSelectScene.getStylesheets().add(cssLight);
        primaryStage.setScene(profileSelectScene);
    }
    public void setProfileSelectRoot(Parent profileSelectRoot) {
        this.profileSelectRoot = profileSelectRoot;
    }
    public void setProfileSelectScene(Scene profileSelectScene) {
        this.profileSelectScene = profileSelectScene;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeSelectBox.getItems().addAll(themes);
        themeSelectBox.setOnAction(this::getChoice);
    }
    public void getChoice(ActionEvent event){
        
    }
}
