package com.example.demo.Controllers;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import static com.example.demo.Main.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class getProfileSceneController extends sceneController implements Initializable {
    private static String accountName="No Name";
    private ArrayList<String> accounts =new ArrayList<String>();
    @FXML
    private ChoiceBox<String> accountSelect;
    public static String getAccountName(){
        return accountName;
    }
    @Override
    public void switchToScene() throws IOException {
        setSetModeRoot(modeSelLoader.load());
        setSetModeScene(new Scene(modeRoot, WIDTH, HEIGHT));
        primaryStage.setScene(modeScene);
    }
    @Override
    public void detectEvent(Event event) throws IOException {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchToScene();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readAccounts();
        accountSelect.getItems().addAll(accounts.toArray(new String[accounts.size()]));
        accountSelect.setOnAction(this::getChoice);
    }
    public void readAccounts(){
        try {
            File accountFile = new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\Accounts.txt");
            Scanner reader = new Scanner(accountFile);
            while (reader.hasNextLine()){
                accounts.add(reader.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getChoice(ActionEvent event){
        accountName = accountSelect.getValue();
    }
}
