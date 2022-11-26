package com.example.demo.endGameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static com.example.demo.Controllers.getProfileSceneController.*;
import static com.example.demo.Controllers.modeSelectSceneController.*;
/**
 * This class' main functionality is to display the visual elements within the end game screen, those being mainly the score, the relevant texts and a button for the user to
 * quit the game. Most methods in this class only adds elements within the groups they're given. The class is not interactive by nature and it's functionalities are purely for aesthetics
 * @author Zhen Lin Wong
 */
public class endGameVisuals {
    private final Button quitButton = new Button("QUIT");
    private final Text Lose = new Text("GAME OVER");
    private final Text Win = new Text("You've Won!!!");
    private final Text newHighScoreText = new Text("IT'S A NEW HIGHSCORE!\nSet by: "+ getAccountName()+"\nFor mode: "+getChoice());
    /**
     * Method that gets the button within the end game scene, used in the EndGame class to add functionalities to it (i.e. the ability to quit the game by pressing on the
     * button.)
     * @return the quit button with no functionalities implemented into it.
     */
    public Button getQuitButton() {
        return quitButton;
    }
    public void setLoseEndTitle(Group root){
        Lose.relocate(150,150);
        Lose.setFont(Font.font(80));
        Lose.setFill(Color.WHITE);
        root.getChildren().add(Lose);
    }

    /**
     * Method takes in the group for the scene in order to insert the Win text ("You've Won!!!") into the scene. Only triggered when the user has a 2048 tile in their screen.
     * @param root the elements within the End Game scene
     */
    public void setWinEndTitle(Group root){
        Win.relocate(150,150);
        Win.setFont(Font.font(80));
        Win.setFill(Color.WHITE);
        root.getChildren().add(Win);
    }
    /**
     * Method takes in the group for the scene and the score that the user has set in order to insert the score number. The method does not have the functionality to detect a new highscore,
     * again this is purely visual.
     * @param root the elements within the End Game scene
     * @param score the score the user ahs set before triggering the game lost condition.
     */
    public void setEndScore(Group root,long score){
        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.WHITE);
        scoreText.relocate(150,250);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);
    }
    /**
     * Method used to add the quit button into the end game scene without any functionalities.
     * @param root the elements within the End Game scene
     */
    public void setEndButton(Group root){
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(150,325);
    }
    /**
     * Method used to add the text for when there is a new highscore set for a particular game mode. Whenever the class is instantiated, the mode is updated when the user has
     * made their choice.
     * @param root the elements within the End Game scene
     */
    public void setNewHighScore(Group root){
        newHighScoreText.setFill(Color.WHITE);
        newHighScoreText.relocate(150,450);
        newHighScoreText.setFont(Font.font(80));
        root.getChildren().add(newHighScoreText);
    }
    /**
     * Method that inserts the background rectangle for text visibility, due the fact that the background of the end game scene and the text in the scene is also white.
     * @param root the elements within the End Game scene
     */
    public void makeBgRekt(Group root){
        Rectangle bgRekt = new Rectangle();
        bgRekt.setFill(Color.rgb(153, 173, 168));
        bgRekt.setHeight(Main.HEIGHT-100);
        bgRekt.setWidth(Main.WIDTH-200);
        root.getChildren().add(bgRekt);
        bgRekt.setX(100);
        bgRekt.setY(50);
    }
}
