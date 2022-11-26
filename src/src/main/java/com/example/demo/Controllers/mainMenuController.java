package com.example.demo.Controllers;

import com.example.demo.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
/**
 * This class is a specialized class derived from "sceneController", in which handles the various activities that shall be conducted within
 * the main menu. Mainly it has two functionalities, to switch from main menu to the profile select scene or to switch from the normal menu to
 * the special menu when the Easter egg is triggered.
 * @author Zhen Lin Wong
 */
public class mainMenuController extends sceneController {
    private Parent getAccountRoot;
    private Scene getAccountScene;
    private final FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("FXMLFiles/accountsScene.fxml"));
    private final FXMLLoader specialMenuLoader = new FXMLLoader(getClass().getResource("FXMLFiles/specialMainMenu.fxml"));
    /**
     * Method used in setting the Parent getAccountRoot in the class mainMenuController.
     * @param getAccountRoot The Group to be set.
     */
    public void setGetAccountRoot(Parent getAccountRoot) {
        this.getAccountRoot = getAccountRoot;
    }
    /**
     * Method used in setting the Scene getAccountScene in the class mainMenuController.
     * @param getAccountScene The Scene to be set.
     */
    public void setGetAccountScene(Scene getAccountScene) {
        this.getAccountScene = getAccountScene;
    }
    /**
     * Method that switches the scene from the main menu scene to the profile selection scene.
     * Method loads the css file from the correct directory and applies that to the profile selection scene before
     * instantiating the scene. After the application is finished, the scene is changed.
     */
    @Override
    public void switchToScene() throws IOException {
        setGetAccountRoot(accountLoader.load());
        setGetAccountScene(new Scene(getAccountRoot, Main.WIDTH, Main.HEIGHT));
        getAccountScene.getStylesheets().add(css);
        primaryStage.setScene(getAccountScene);
    }
    /**
     * Method to switch to special scene when the Easter egg has been activated, method loads the FXML file for the
     * special menu and applies the same css to the menu. Has the same dimensions as the main menu.
     */
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
