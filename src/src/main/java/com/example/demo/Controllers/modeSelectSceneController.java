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
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is a specialized class derived from "sceneController", in which handles the various activities that shall be conducted within
 * the mode select scene. Users in this scene should be able to choose between 3 game modes, those being 3x3, 4x4 and 5x5. The game mode
 * will always default to 4x4 if nothing is chosen. It implements the "Initializable" class in order to execute actions upon the user's
 * selection within the choice box.
 */
public class modeSelectSceneController extends sceneController implements Initializable {
    private Group gameRoot;
    private Scene gameScene;
    @FXML
    private ChoiceBox<String> modeSelectBox;
    private final String[] dimensions = {"3x3","4x4","5x5"};
    private static String choice="4x4";
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }
    /**
     * Method for getting the mode of choice that the user has, used by some classes to determine the next course of action.
     * This method is static due to the fact that a number of classes need to access this method.
     * @return  the mode choice that the user has made
     */
    public static String getChoice() {
        return choice;
    }
    /**
     * Method that switches the scene from the mode select scene to the actual game scene.
     * It loads an image from the resource file as a background and instantiates the GameScene class to set all the elements within.
     * The end game scene is also made here, but it is not filled with elements at this point in the runtime execution.
     */
    @Override
    public void switchToScene() {
        Image Bg = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\back_nor.jpg").toURI().toString());
        ImageView pat = new ImageView(Bg);
        setGameRoot(new Group(pat));
        setGameScene(new Scene(gameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(246,250,249)));
        GameScene game = new GameScene();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, Main.WIDTH, Main.HEIGHT, Color.rgb(240, 240, 240));
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setScene(gameScene);
    }

    /**
     * Method that was implemented from the javaFX interface "Initializable". In this context the method is adding all relevant choices
     * of dimensions to the choice box within the scene and getting the choice of the user through the method "getChoice"
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modeSelectBox.getItems().addAll(dimensions);
        modeSelectBox.setOnAction(this::getChoice);
    }

    /**
     * Method sets the preferred dimensions for the game based on user's choice by calling the static method of setN to determine the dimension of the playing
     * field. The choice is passed from the choice box within the scene.
     * @param event user's event of choosing their preferred game mode.
     */
    public void getChoice(ActionEvent event){
        choice = modeSelectBox.getValue();
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
