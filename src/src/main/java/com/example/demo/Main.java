package com.example.demo;

import com.example.demo.Controllers.mainMenuController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;
import java.io.File;

public class Main extends Application {
    public static final int WIDTH = 1250;
    public static final int HEIGHT = 768;
    private static boolean dogeMode=false;
    private final String borkFile = "COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\bork.mp3";
    private final String bgMusic_egg = "COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\bgMusic_egg.mp3";
    private final String bgMusic_nor="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\bgMus_normal.mp3";
    private final Media bgMusicMedia_egg = new Media(new File(bgMusic_egg).toURI().toString());
    private final Media bork = new Media(new File(borkFile).toURI().toString());
    private final Media bgMusicMedia_nor = new Media(new File(bgMusic_nor).toURI().toString());
    private final MediaPlayer bgMusicPlayer_egg = new MediaPlayer(bgMusicMedia_egg);
    private final MediaPlayer borkPlayer = new MediaPlayer(bork);
    private final MediaPlayer bgMusicPlayer_nor = new MediaPlayer(bgMusicMedia_nor);
    private final FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/FXMLFiles/mainMenu.fxml"));
    private final mainMenuController menuScene1 = new mainMenuController();
    public static boolean isDogeMode() {
        return dogeMode;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        bgMusicPlayer_nor.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                bgMusicPlayer_nor.seek(Duration.ZERO);
            }
        });
        bgMusicPlayer_nor.play();
        Parent menuRoot = loader.load();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        String css = this.getClass().getResource("Controllers/FXMLFiles/menuStyle.css").toExternalForm();
        mainMenuController sceneController = loader.getController();
        menuScene.getStylesheets().add(css);
        menuScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.ENTER)||(event.getCode() == KeyCode.SPACE)){
                    try {
                        sceneController.detectEvent(event);
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
                    menuScene1.switchToSpecialMenu();
                    bgMusicPlayer_nor.stop();
                    sceneController.setDogeKeysPressed(0);
                    borkPlayer.play();
                    dogeMode=true;
                    bgMusicPlayer_egg.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                            bgMusicPlayer_egg.seek(Duration.ZERO);
                        }
                    });
                    bgMusicPlayer_egg.play();
                }
                else{
                    sceneController.setDogeKeysPressed(0);
                }
            }
        });

        primaryStage.setScene(menuScene);
        menuScene1.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
