package com.example.demo.gameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
/**
 * This class' main functionality is to display the visual elements within the game scene, those being mainly the score board coupled with the score text and
 * the background rectangle for the playing field to enhance visibility. The class is not interactive by nature and it's functionalities are purely for aesthetics.
 */
public class gameVisuals {
    /**
     * Method for initializing the Score text for the score board. Only used to indicate the actual position of the score counter.
     * @param root cluster of elements that shall appear in the game scene. Method will add the Score text to it.
     * @param text The score text that shall be written on the game scene and positioned by the method.
     */
    public void addScoreText(Group root, Text text){
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.setFill(Color.rgb(81, 84, 82));
        text.relocate(850, 100);
    }
    /**
     * Method for initializing the Score for the game, that being 0. Will be changed when the game progresses, but it is not handled by this method specifically.
     * @param root  cluster of elements that shall appear in the game scene. Method will add the initial Score to it.
     * @param text The score that shall be written on the game scene and positioned by the method.
     */
    public void initializeScore(Group root, Text text){
        root.getChildren().add(text);
        text.relocate(900, 200);
        text.setFont(Font.font(20));
        text.setFill(Color.rgb(81, 84, 82));
        text.setText("0");
    }
    /**
     * Method for initializing the background rectangle for the playing field. Used for allowing better visuals when indicating where the tiles in game are.
     * @param root cluster of elements that shall appear in the game scene. Method will add the game rectangle to it.
     */
    public void makeBgRekt(Group root){
        Rectangle bgRekt = new Rectangle();
        bgRekt.setFill(Color.rgb(153, 173, 168));
        bgRekt.setHeight(Main.HEIGHT-40);
        bgRekt.setWidth(Main.WIDTH-500);
        root.getChildren().add(bgRekt);
        bgRekt.setX(-25);
        bgRekt.setY(-15);
    }
    /**
     * Method for initializing the background rectangle for the score board. Method also creates a slightly larger black rectangle behind the scoreboard to simulate a border effect.
     * The border rectangle is added before the scoreboard rectangle.
     * @param root cluster of elements that shall appear in the game scene. Method will add both the border rectangle and scoreboard rectangle to it.
     */
    public void makeScoreRekt(Group root){
        Rectangle scoreRekt = new Rectangle();
        Rectangle border = new Rectangle();
        scoreRekt.setFill(Color.rgb(252, 252, 252));
        border.setFill(Color.rgb(153, 173, 168));
        scoreRekt.setWidth(250);
        scoreRekt.setHeight(150);
        border.setWidth(260);
        border.setHeight(160);
        root.getChildren().add(border);
        border.relocate(800, 85);
        root.getChildren().add(scoreRekt);
        scoreRekt.relocate(805, 90);
    }
}
