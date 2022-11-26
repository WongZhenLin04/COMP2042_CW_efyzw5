package com.example.demo.endGameElements;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import java.util.Optional;
/**
 * The main class for the end game scene itself and is the core for all operations relating to the end game scene, albeit there only being a few functionalities. The decisions in
 * these methods mainly focus on deciding on which class is appropriate to show depending on the outcome of the user's play-through.
 * @author Zhen Lin Wong-modified
 */
public class EndGame {
    private endGameVisuals endGameVisuals;
    private highScore highScore;
    private char cond;
    /**
     * Constructor of the class, the context in which it's instantiated is always when the user has either won or lost the game, therefore the condition of the game must be set
     * whenever this class is instantiated in order to determine the text that is to be displayed in the end game scene.
     * @param cond the condition in which the user has ended the game in. 'l' for lose and 'w' for win.
     */
    public EndGame(char cond){
        endGameVisuals = new endGameVisuals();
        highScore = new highScore();
        this.cond=cond;
    }
    /**
     * Method that determines the end game scene elements (meaning what should go into the end game screen) and the order in which they'll appear in. The method also adds functionality
     * to the quit button so that it'll actually quit when the user presses on the quit button.
     * @param root the container of the elements in which shall be displayed on the scene
     * @param score the score that the user has set on their play through of the game before losing
     */
    public void endGameShow(Group root, long score){
        endGameVisuals.makeBgRekt(root);
        highScore.setHighscore(score, root);
        if(cond=='l'){
            endGameVisuals.setLoseEndTitle(root);
        }
        else {
            endGameVisuals.setWinEndTitle(root);
        }
        endGameVisuals.setEndScore(root,score);
        endGameVisuals.setEndButton(root);
        endGameVisuals.getQuitButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                }
            }
        });
    }
}
