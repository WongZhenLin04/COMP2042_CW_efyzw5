package com.example.demo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.example.demo.Main.*;
/**
 * This class is a specialized class derived from "sceneController", in which handles the various activities that shall be conducted within
 * the profile Select menu. The functionalities of the class includes filling the choice box within the profile choice box
 * , getting the user's choice from the aforementioned box and switching from the profile select scene to the mode select screen.
 * @author Zhen Lin Wong
 */
public class getProfileSceneController extends choiceBoxController {
    private Parent modeRoot;
    private Scene modeScene;
    private final FXMLLoader modeSelLoader = new FXMLLoader(getClass().getResource("FXMLFiles/gameModeSelect.fxml"));
    private static String accountName="No Name";
    private ArrayList<String> accounts =new ArrayList<String>();
    private String newName;
    private final File accountFile = new File(resourceHeader+"Accounts.txt");
    @FXML
    private Label nameLabel;
    @FXML
    private TextField accountTextBox;
    @FXML
    private ChoiceBox<String> accountSelect;
    /**
     * Constructor of the class, initializes the list of accounts available to prevent multiple reads of the accounts file.
     */
    public getProfileSceneController(){
        readAccounts();
    }
    /**
     * Method used in setting the modeRoot to the input Parent "setModeRoot".
     * @param setModeRoot input Parent in which the user wants to set modeSelectRoot to.
     */
    public void setSetModeRoot(Parent setModeRoot) {
        this.modeRoot = setModeRoot;
    }
    /**
     * Method used in setting the modeScene to the input Scene "setModeScene".
     * @param setModeScene input Scene in which the user wants to set modeSelectSene to.
     */
    public void setSetModeScene(Scene setModeScene) {
        this.modeScene = setModeScene;
    }
    /**
     * Method that returns the accounts as an array list. Used in the test cases for the method.
     * @return Account names in the form of an array list.
     */
    public ArrayList<String> getAccounts() {
        return accounts;
    }
    /**
     * Method to return the account name chosen by the user, used by the end game scene to be displayed if a new highscore is set
     * @return the account that the user has chosen to be displayed
     */
    public static String getAccountName(){
        return accountName;
    }
    /**
     * Method that switches the scene from the profile select scene to the mode selection scene.
     * Method loads the css file from the correct directory and applies that to the mode selection scene before
     * instantiating the scene. After the application is finished, the scene is changed.
     */
    @Override
    public void switchToScene() throws IOException {
        setSetModeRoot(modeSelLoader.load());
        setSetModeScene(new Scene(modeRoot, WIDTH, HEIGHT));
        if(!darkMode) {
            modeScene.getStylesheets().add(cssLight);
        }
        else {
            modeScene.getStylesheets().add(cssDark);
        }
        primaryStage.setScene(modeScene);
    }
    /**
     * Method that was implemented from the javaFX interface "Initializable". In this context the method is adding all accounts
     * to the choice box within the scene and getting the choice of the user through the method "getChoice"
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountSelect.getItems().addAll(accounts.toArray(new String[accounts.size()]));
        accountSelect.setOnAction(this::getChoice);
    }
    /**
     * Method to import names from the accounts file to be used in filling the choice box. Scanner reads the file line by line
     * until it reaches the end of the text file. The names of the accounts are stored in the array list "accounts"
     */
    public void readAccounts(){
        try {
            Scanner reader = new Scanner(accountFile);
            while (reader.hasNextLine()){
                accounts.add(reader.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Method that sets the variable "accountName" to the user's selected account when a choice in the choice box has been made.
     * The event that is being referenced here is the event of the user making a choice.
     * @param event used in the FXML file to detect when the user has made a choice.
     */
    @Override
    public void getChoice(ActionEvent event){
        accountName = accountSelect.getValue();
    }
    /**
     * Method that checks the user submitted name (if it is already in the account file or null), appends it to the account file if valid and switches to the mode select scene.
     * @param event Event when button is clicked.
     */
    public void submitName(ActionEvent event){
        newName = accountTextBox.getText();
        if(accounts.contains(newName)){
            nameLabel.setText("Already in accounts, Try another name!");
        }else if(newName.isEmpty()){
            nameLabel.setText("Don't submit empty names!");
        }else {
            try{
                FileWriter accountApp = new FileWriter(accountFile,true);
                accountApp.write("\n"+newName);
                accountApp.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                accountName=newName;
                try {
                    detectEvent(event);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
