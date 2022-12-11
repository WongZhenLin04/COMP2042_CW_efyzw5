package com.example.demo;

import com.example.demo.Controllers.mainMenuController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

/**
 * The execution class of all classes also contains information about the main menu (i.e. the path to files that it uses, the dimensions of the screen
 * and determines the state of a certain Easter egg)
 * @author Zhen Lin Wong-modified
 */
public class Main extends Application{
    public static final int WIDTH = 1250;
    public static final int HEIGHT = 768;
    private static boolean dogeMode=false;
    public static final String resourceHeader="src\\src\\main\\resources\\com\\example\\demo\\";
    private final Media bgMusicMedia_egg = new Media(new File(resourceHeader+"bgMusic_egg.mp3").toURI().toString());
    private final Media bork = new Media(new File(resourceHeader+"bork.mp3").toURI().toString());
    private final Media bgMusicMedia_nor = new Media(new File(resourceHeader+"bgMus_normal.mp3").toURI().toString());
    private final MediaPlayer bgMusicPlayer_egg = new MediaPlayer(bgMusicMedia_egg);
    private final MediaPlayer borkPlayer = new MediaPlayer(bork);
    private final MediaPlayer bgMusicPlayer_nor = new MediaPlayer(bgMusicMedia_nor);
    private final FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/FXMLFiles/mainMenu.fxml"));
    private final mainMenuController menuScene1 = new mainMenuController();
    /**
     * Method for determining the condition of "dogeMode"
     * @return <code>true</code> :activate events that coincide with the Easter egg activation
     *         <code>false</code> :run code as usual.
     */
    public static boolean isDogeMode() {
        return dogeMode;
    }
    /**
     * The main entry point for all JavaFX applications.
     * @param primaryStage the stage in which all the scenes within the game play out.
     */
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
        String css = this.getClass().getResource("Controllers/FXMLFiles/menuStyleLight.css").toExternalForm();
        mainMenuController sceneController = loader.getController();
        menuScene.getStylesheets().add(css);
        menuScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            /**
             * Invoked when a specific event of the type for which this handler is registered happens. In this specific implementation, the method is used to
             * detect the type of keys pressed within the main menu. If the correct key is pressed in the correct sequence, the amount of correct keys pressed
             * will increment, else decrease. If the amount of keys reaches 4 it will activate the Easter egg
             */
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
    /**
     * The driver method of all java code
     */
    public static void main(String[] args) {
        launch(args);
    }

}
