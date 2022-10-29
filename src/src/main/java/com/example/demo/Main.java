package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.*;

import java.io.File;
import java.util.Scanner;

public class Main extends Application {
    static final int WIDTH = 1250;
    static final int HEIGHT = 768;
    static boolean dogeMode=false;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        String musicFile = "bork.mp3";
        Media bork = new Media(new File(musicFile).toURI().toString());
        MediaPlayer borkPlayer = new MediaPlayer(bork);
        Parent menuRoot = loader.load();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        String css = this.getClass().getResource("menuStyle.css").toExternalForm();
        sceneController sceneController = loader.getController();
        menuScene.getStylesheets().add(css);
        menuScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.ENTER)||(event.getCode() == KeyCode.SPACE)){
                    try {
                        sceneController.detectStartButton(event);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if ((event.getCode()== KeyCode.D)&&(sceneController.getDogeKeysPressed()==0)){
                    sceneController.dogeKeyIncrement();
                }
                else if ((event.getCode()== KeyCode.O)&&(sceneController.getDogeKeysPressed()==1)){
                    sceneController.dogeKeyIncrement();
                }
                else if ((event.getCode()== KeyCode.G)&&(sceneController.getDogeKeysPressed()==2)){
                    sceneController.dogeKeyIncrement();
                }
                else if ((event.getCode()== KeyCode.E)&&(sceneController.getDogeKeysPressed()==3)){
                    sceneController.setDogeKeysPressed(0);
                    System.out.println("dog");
                    borkPlayer.play();
                    dogeMode=true;
                }
                else{
                    sceneController.setDogeKeysPressed(0);
                }
            }
        });

        /*
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        */

        /*
        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);
        */

        primaryStage.setScene(menuScene);
        sceneController menuScene1 = new sceneController();
        menuScene1.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
