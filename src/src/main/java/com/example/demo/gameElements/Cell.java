package com.example.demo.gameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.io.File;
/**
 * This class is used in instantiating the tiles we see on the game scene with the dimension that the user has chosen (that being nxn dimensions). The class also has the responsibility of setting the contents of a given cell (i.e. the number displayed and the colour of the cell) and is also responsible for the addition function for when two of the same tiles collide. It is important to note that the terms tiles and cells are used interchangeably. The actual generation of the numbers to be displayed aren't handled by this class, but it is responsible for getting the actual value of the cell for the use of other classes.
 * @author Zhen Lin Wong-modified
 */
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;
    /**
     * This method is used to indicate whether a particular cell has been combined with another cell in one turn. The resulting cell after a move will hold whatever boolean value the code has deemed it to hold depending on the conditions.
     * @param modify the condition of the cell in a single turn.
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }
    /**
     * Method is utilized when the game needs to know if a particular cell has been combined with another equal cell beforehand. Prevents the situation in which multiple additions for one cell can happen in a single turn
     * @return <code>true</code> within one user key press, the tile has been combined with another tile.
     *         <code>false</code> within one user key press, the cell has collided with either the boundary of the game or a non-equal cell.
     */
    public boolean getModify() {
        return modify;
    }
    /**
     * The constructor of the class. When instantiated, at first, the cell will be a plain square with no text and will contain the value of "0". This is considered to be the "base state" of the cell in which it holds no values and cannot be combined with other cells.
     * @param x the horizontal position of the cell
     * @param y the vertical position of the cell
     * @param scale the length of a side of the cell (the resulting cell should be a square therefore the scale is used to determine both the height and width of the cell.)
     * @param root the container of the elements in which shall be displayed on the scene
     */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(252, 252, 252));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y);
        root.getChildren().add(rectangle);
    }
    /**
     * Method that sets the number that should be displayed by the cell, occurs when the cell is "moving" or when the cell is combining with a different cell.
     * @param textClass the number that should be displayed on the cell
     */
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }
    /**
     * Method calls the "changeTwoText" method from the class Text maker to swap the contents of the two cells and then swap the position of both of the cells. After that it checks if the contents of both of the cells to determine the non-empty cell. The contents of the non-empty cell is then copied onto the calling cell and the calling cell and the targeted cell shall switch colours according to the current contents of each cell. This method is only utilized when the cell is moved and does not merge with any other cells.
     * @param cell the targeted cell in which the calling cell shall be swapped with.
     */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);
        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }
    /**
     * The method is used when two cells are merging together. It starts off by getting the integer from the calling cell and the targeted cell and adding them together and converting the result into a String. The targeted cell will display the added contents (and will have its colour changed into the corresponding colour for the resulting number) and the calling cell will be converted to an empty cell.
     * @param cell the targeted cell that is to be converted into the result.
     */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }
    /**
     * Method employed during initialization of cells and when a change in value in cell occurs. It takes in the number of the cell and sets the calling cell's colour based on the number inputted. The method fills the calling cell's with solid colour if the Easter egg is not active, else for each possible number, the method will load in the corresponding GIF file from the resource and fill in the cell with the loaded GIF.
     * @param number the number that is to be associated with a colour in the switch statement. Used to pick the correct colour for all same valued cells.
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(252, 252, 252));
                break;
            case 2:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(238,228,218));
                }else {
                    Image doge2 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\2doge.gif").toURI().toString());
                    ImagePattern doge2View = new ImagePattern(doge2);
                    rectangle.setFill(doge2View);
                }
                break;
            case 4:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,224,200));
                }else {
                    Image doge4 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\4doge.gif").toURI().toString());
                    ImagePattern doge4View = new ImagePattern(doge4);
                    rectangle.setFill(doge4View);
                }
                break;
            case 8:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(242,177,121));
                }else {
                    Image doge8 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\8doge.gif").toURI().toString());
                    ImagePattern doge8View = new ImagePattern(doge8);
                    rectangle.setFill(doge8View);
                }
                break;
            case 16:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(245,149,99));
                }else {
                    Image doge16 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\16doge.gif").toURI().toString());
                    ImagePattern doge16View = new ImagePattern(doge16);
                    rectangle.setFill(doge16View);
                }
                break;
            case 32:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(246,124,96));
                }else {
                    Image doge32 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\32doge.gif").toURI().toString());
                    ImagePattern doge32View = new ImagePattern(doge32);
                    rectangle.setFill(doge32View);
                }
                break;
            case 64:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(246,94,59));
                }else {
                    Image doge64 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\64doge.gif").toURI().toString());
                    ImagePattern doge64View = new ImagePattern(doge64);
                    rectangle.setFill(doge64View);
                }
                break;
            case 128:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,207,115));
                }else {
                    Image doge128 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\128doge.gif").toURI().toString());
                    ImagePattern doge128View = new ImagePattern(doge128);
                    rectangle.setFill(doge128View);
                }
                break;
            case 256:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,204,98));
                }else {
                    Image doge256 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\256doge.gif").toURI().toString());
                    ImagePattern doge256View = new ImagePattern(doge256);
                    rectangle.setFill(doge256View);
                }
                break;
            case 512:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,200,80,255));
                }else {
                    Image doge512 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\512doge.gif").toURI().toString());
                    ImagePattern doge512View = new ImagePattern(doge512);
                    rectangle.setFill(doge512View);
                }
                break;
            case 1024:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,197,63));
                }else {
                    Image doge1024 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\1024doge.gif").toURI().toString());
                    ImagePattern doge1024View = new ImagePattern(doge1024);
                    rectangle.setFill(doge1024View);
                }
                break;
            case 2048:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(237,194,45));
                }else {
                    Image doge2048 = new Image(new File("COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\2048doge.gif").toURI().toString());
                    ImagePattern doge2048View = new ImagePattern(doge2048);
                    rectangle.setFill(doge2048View);
                }


        }

    }
    /**
     * Method gets the X position of the cell relative to the screen.
     * @return the X position of the cell relative to the screen.
     */
    public double getX() {
        return rectangle.getX();
    }
    /**
     * Method gets the Y position of the cell relative to the screen.
     * @return the Y position of the cell relative to the screen.
     */
    public double getY() {
        return rectangle.getY();
    }
    /**
     * Method gets the Text within the cell, since it is always a number, the method will convert the text into an int before returning.
     * @return the number that is held within the cell in int format.
     */
    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }
    /**
     * Method returns the text that is held within the cell, the method is private as the only time this method is used is within the class.
     * @return the text within the cell. Usually a number.
     */
    private Text getTextClass() {
        return textClass;
    }

}
