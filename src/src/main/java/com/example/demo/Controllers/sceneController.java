package com.example.demo.Controllers;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The abstract class sceneController acts as  a base for all operations regarding switching between scenes.
 * Classes that extend the sceneController class can have different interpretation in regard to the "switchToScene"
 * meaning different classes can switch to different scenes in different context. Most of the variables within this abstract class is protected mainly
 * to prevent any other classes (apart from inheriting classes) from manipulating the data within.
 * @author Zhen Lin Wong-modified
*/
abstract public class sceneController{
    private int DogeKeysPressed=0;
    protected Stage primaryStage;
    protected String cssLight = this.getClass().getResource("FXMLFiles/menuStyleLight.css").toExternalForm();
    protected String cssDark = this.getClass().getResource("FXMLFiles/menuStyleDark.css").toExternalForm();
    /**
     * Method to get the status of the DarkMode variable.
     * @return <code>Dark mode has been activated</code>
     *         <false>Light mode is activated</false>
     */
    public static boolean isDarkMode() {
        return darkMode;
    }
    protected static boolean darkMode=false;
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
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage=primaryStage;
    }
    /**
     * Typically called by the "detectEvent" method when an event occurs that indicates a switching of scene is needed.
     * Generally the method changes from one scene to the other scene by setting the parent/group and soon after the scene as well
     * as it employs the primary stage method "setScene" to change the scene.
     * @throws IOException exception handling for .load methods.
     */
    public abstract void switchToScene()throws IOException ;
    /**
     * Method is utilized to prepare the stage for scene switching by getting the event that triggers the change, it is used by all
     * inherited classes and has the same implementation.
     * @param event The event that triggers the scene switch, e.g. mouse clicks, button presses, etc...
     * @throws IOException needed for the switchToScene method
     */
    public void detectEvent(Event event) throws IOException{
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchToScene();
    }

}
