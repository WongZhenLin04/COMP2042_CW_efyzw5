package com.example.demo.Controllers;

import com.example.demo.Main;
import com.example.demo.gameElements.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class modeSelectSceneController extends sceneController implements Initializable {

    @FXML
    private ChoiceBox<String> modeSelectBox;
    private final String[] dimensions = {"3x3","4x4","5x5"};
    private static String choice="4x4";
    public static String getChoice() {
        return choice;
    }
    @Override
    public void switchToScene() throws IOException {
        Image Bg = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\back_nor.jpg").toURI().toString());
        ImageView pat = new ImageView(Bg);
        setGameRoot(new Group(pat));
        setGameScene(new Scene(gameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(246,250,249)));
        GameScene game = new GameScene();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(240, 240, 240));
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setScene(gameScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modeSelectBox.getItems().addAll(dimensions);
        modeSelectBox.setOnAction(this::getChoice);
    }
    public void getChoice(ActionEvent event){
        this.choice = modeSelectBox.getValue();
        switch (choice){
            case "4x4":{
                GameScene.setN(4);
                break;
            }
            case "5x5":{
                GameScene.setN(5);
                break;
            }
            case "3x3":{
                GameScene.setN(3);
                break;
            }
            default:GameScene.setN(4);
        }
    }
}
