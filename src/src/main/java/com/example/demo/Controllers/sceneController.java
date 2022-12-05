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
