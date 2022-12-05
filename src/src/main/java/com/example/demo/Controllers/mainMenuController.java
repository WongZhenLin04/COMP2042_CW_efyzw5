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
    private int DogeKeysPressed=0;
    private Parent themeSelectRoot;
    private Scene themeSelectScene;
    private final FXMLLoader themeSelectLoader = new FXMLLoader(getClass().getResource("FXMLFiles/themeSelect.fxml"));
    private final FXMLLoader specialMenuLoader = new FXMLLoader(getClass().getResource("FXMLFiles/specialMainMenu.fxml"));
    /**
     * Returns the amount of correct keys pressed in the main menu to activate the Easter egg
     * @return the amount of correct keys pressed. Resets when a wrong key is pressed
     */
    public int getDogeKeysPressed() {
        return DogeKeysPressed;
    }
    /**
     * Method is used when the user presses the correct key.
     * @param dogeKeysPressed amount of times the correct key has been pressed in the main menu
     */
    public void setDogeKeysPressed(int dogeKeysPressed) {
        this.DogeKeysPressed = dogeKeysPressed;
    }
    /**
     * Method is used to increment the amount of times the user has pressed the correct key to trigger the Easter egg by 1.
     * Only ever used when one key is pressed, there should be no way that the user is able to press two more or more keys at the same time
     */
    public void dogeKeyIncrement() {
        this.DogeKeysPressed += 1;
    }
    /**
     * Method used by other classes to switch scenes, done so by setting the primary stage to the desired scene with its corresponding elements.
     * @param primaryStage the stage in which all scenes play out and is the main window for the game.
     */
    /**
     * Method used in setting the Parent getAccountRoot in the class mainMenuController.
     * @param themeSelectRoot The Group to be set.
     */
    public void setThemeSelectRoot(Parent themeSelectRoot) {
        this.themeSelectRoot = themeSelectRoot;
    }
    /**
     * Method used in setting the Scene getAccountScene in the class mainMenuController.
     * @param themeSelectScene The Scene to be set.
     */
    public void setThemeSelectScene(Scene themeSelectScene) {
        this.themeSelectScene = themeSelectScene;
    }
    /**
     * Method that switches the scene from the main menu scene to the profile selection scene.
     * Method loads the css file from the correct directory and applies that to the profile selection scene before
     * instantiating the scene. After the application is finished, the scene is changed.
     */
    @Override
    public void switchToScene() throws IOException {
        setThemeSelectRoot(themeSelectLoader.load());
        setThemeSelectScene(new Scene(themeSelectRoot, Main.WIDTH, Main.HEIGHT));
        themeSelectScene.getStylesheets().add(cssLight);
        primaryStage.setScene(themeSelectScene);
    }
    /**
     * Method to switch to special scene when the Easter egg has been activated, method loads the FXML file for the
     * special menu and applies the same css to the menu. Has the same dimensions as the main menu.
     */
    public void switchToSpecialMenu(){
        try {
            Parent specialMenuRoot = specialMenuLoader.load();
            Scene specialMenuScene = new Scene(specialMenuRoot, Main.WIDTH, Main.HEIGHT);
            specialMenuScene.getStylesheets().add(cssLight);
            primaryStage.setScene(specialMenuScene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
