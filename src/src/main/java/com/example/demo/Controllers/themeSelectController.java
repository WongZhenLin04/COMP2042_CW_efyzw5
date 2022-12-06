package com.example.demo.Controllers;
import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
/**
 * Class that handles the events within the scene "themeSelect". Mainly notifying the appropriate classes of the mode the user has chosen.
 * @author Zhen Lin Wong
 */
public class themeSelectController extends choiceBoxController {
    @FXML
    private ChoiceBox<String> themeSelectBox;
    private final String[] themes = {"Dark Mode","Light Mode"};
    private Parent profileSelectRoot;
    private Scene profileSelectScene;
    private final FXMLLoader profileSelectLoader = new FXMLLoader(getClass().getResource("FXMLFiles/accountsScene.fxml"));
    /**
     * Method that switches to the Profile Select screen by first instantiating the scene with the appropriate root and setting the stage to be of the scene.
     */
    @Override
    public void switchToScene() throws IOException {
        setProfileSelectRoot(profileSelectLoader.load());
        setProfileSelectScene(new Scene(profileSelectRoot, Main.WIDTH, Main.HEIGHT));
        if(!darkMode) {
            profileSelectScene.getStylesheets().add(cssLight);
        }else {
            profileSelectScene.getStylesheets().add(cssDark);
        }
        primaryStage.setScene(profileSelectScene);
    }
    /**
     * Method that sets the Profile Select Root. Usually paired with the FXML loader.
     * @param profileSelectRoot The elements within the profile select scene.
     */
    public void setProfileSelectRoot(Parent profileSelectRoot) {
        this.profileSelectRoot = profileSelectRoot;
    }
    /**
     * Method that sets the Profile Select Scene. Usually paired with the profile select root.
     * @param profileSelectScene The scene to be set on the primary stage.
     */
    public void setProfileSelectScene(Scene profileSelectScene) {
        this.profileSelectScene = profileSelectScene;
    }
    /**
     * Method that adds all the available themes to the choice box in the form of Strings.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeSelectBox.getItems().addAll(themes);
        themeSelectBox.setOnAction(this::getChoice);
    }
    /**
     * Method that gets the choice of the user once button is clicked.
     * @param event Detects when the button is clicked on and when user makes a choice.
     */
    @Override
    public void getChoice(ActionEvent event){
        String choice=themeSelectBox.getValue();
        if (Objects.equals(choice, "Dark Mode")){
            super.darkMode=true;
        }
    }
}
