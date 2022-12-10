package com.example.demo.gameElements;

import com.example.demo.observerPattern.DogeObserver;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * This class' main responsibility revolves around the texts (numbers) within the cells on the playing field. It operates and manipulates the elements given to it and is always
 * called upon as a single instance, as multiple instances of the TextMaker class would essentially make the structure of the game more complex than it should be and would be pointless to have multiple instances of the class.
 * The class is mainly called upon by the game scene and the cell class as both of these classes needs the text inside the cells to be manipulated (visually) inorder to operate as indented.
 * @author Zhen Lin Wong - modified
 */
public class TextMaker extends DogeObserver {
    private boolean dogeMode;
    private static TextMaker singleInstance = null;
    /**
     * Method that was implemented from the Observer class, used to change the dogeMode boolean to the state entered.
     * @param state The state of the boolean doge mode.
     *              <code>true</code> means that the Easter egg has been activated.
     *              <code>false</code> means that the game is played normally.
     */
    @Override
    public void update(boolean state) {
        dogeMode=state;
    }
    /**
     * The constructor of the class,necessary for only having a single instance of the class.
     */
    private TextMaker() {

    }
    /**
     * Method that instantiates the only copy of the class. If any classes wishes to employ the operations and methods within the class they shall do so by calling this static method.
     * Generally, the method only instantiates the class if and only if the singleInstance variable is null (meaning that no instances of the class exists at all) and will always return the singleInstance after being called the first time.
     * @return The TextMaker class. The only copy of the class that will ever exist in a single runtime of the code.
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }
    /**
     * Method creates a text class using the given parameters (the String of text to be displayed and the position it's supposed to be displayed at) and returns it. The method
     * has the ability to detect if the Easter egg has been activated, if it is so, then the Text will not be necessary therefore the text will be hidden if the Easter egg is active
     * (by changing the colour of the font to match the background). Class also determines how the text looks (aesthetically) and the font size of the text will
     * be directly proportional to the length of the cell.
     * @param input The text to be displayed. To be made as a parameter when instantiating the text class.
     * @param xCell The X position of text to be displayed at. Not really utilized when the Easter egg  is activated.
     * @param yCell The Y position of text to be displayed at. Not really utilized when the Easter egg  is activated.
     * @return The text class based on the String input with its properties predetermined.
     */
    public Text madeText(String input, double xCell, double yCell) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFill(Color.rgb(153, 173, 168));
        if(!dogeMode) {
            text.setFont(Font.font(fontSize));
            text.relocate((xCell + (1.2) * length / 7.0), (yCell + 2 * length / 7.0));
            text.setFill(Color.WHITE);
        }
        return text;
    }
    /**
     * Method acts as a swapper by swapping the text and position of two given cells. It is important to note that the value of the cells are also swapped due to the value of the cells
     * are tied to its contents. Method is used when cells are to be moved and in most cases, one of the cells is an empty cell.
     * @param first the first of the two cells to be swapped with. Contents shall be altered once the method is applied.
     * @param second the second of the two cells to be swapped with. Contents shall be altered once the method is applied.
     */
    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }


}
