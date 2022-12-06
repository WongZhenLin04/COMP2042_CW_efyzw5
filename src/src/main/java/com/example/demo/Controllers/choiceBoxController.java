package com.example.demo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
/**
 * Abstract class for scenes that have choice box, meant to ensure that the scenes with choice boxes have the appropriate methods and implementations.
 */
public abstract class choiceBoxController extends sceneController implements Initializable {
    /**
     * Abstract method for getting values from choice boxes, the proceeding operations shall be determined by the class specific implementation.
     * @param event Detects when the button is clicked on and when user makes a choice.
     */
    public abstract void getChoice(ActionEvent event);
}
