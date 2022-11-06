package com.example.demo.gameElements;

import com.example.demo.Main;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.io.File;

public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean getModify() {
        return modify;
    }

    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

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

    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
                break;
            case 2:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
                }else {
                    Image doge2 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\2doge.gif").toURI().toString());
                    ImagePattern doge2View = new ImagePattern(doge2);
                    rectangle.setFill(doge2View);
                }
                break;
            case 4:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
                }else {
                    Image doge4 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\4doge.gif").toURI().toString());
                    ImagePattern doge4View = new ImagePattern(doge4);
                    rectangle.setFill(doge4View);
                }
                break;
            case 8:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
                }else {
                    Image doge8 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\8doge.gif").toURI().toString());
                    ImagePattern doge8View = new ImagePattern(doge8);
                    rectangle.setFill(doge8View);
                }
                break;
            case 16:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
                }else {
                    Image doge16 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\16doge.gif").toURI().toString());
                    ImagePattern doge16View = new ImagePattern(doge16);
                    rectangle.setFill(doge16View);
                }
                break;
            case 32:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
                }else {
                    Image doge32 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\32doge.gif").toURI().toString());
                    ImagePattern doge32View = new ImagePattern(doge32);
                    rectangle.setFill(doge32View);
                }
                break;
            case 64:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
                }else {
                    Image doge64 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\64doge.gif").toURI().toString());
                    ImagePattern doge64View = new ImagePattern(doge64);
                    rectangle.setFill(doge64View);
                }
                break;
            case 128:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
                }else {
                    Image doge128 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\128doge.gif").toURI().toString());
                    ImagePattern doge128View = new ImagePattern(doge128);
                    rectangle.setFill(doge128View);
                }
                break;
            case 256:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
                }else {
                    Image doge256 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\256doge.gif").toURI().toString());
                    ImagePattern doge256View = new ImagePattern(doge256);
                    rectangle.setFill(doge256View);
                }
                break;
            case 512:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
                }else {
                    Image doge512 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\512doge.gif").toURI().toString());
                    ImagePattern doge512View = new ImagePattern(doge512);
                    rectangle.setFill(doge512View);
                }
                break;
            case 1024:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
                }else {
                    Image doge1024 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\1024doge.gif").toURI().toString());
                    ImagePattern doge1024View = new ImagePattern(doge1024);
                    rectangle.setFill(doge1024View);
                }
                break;
            case 2048:
                if(!Main.isDogeMode()) {
                    rectangle.setFill(Color.rgb(250,0,0,1));
                }else {
                    Image doge2048 = new Image(new File("COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\2048doge.gif").toURI().toString());
                    ImagePattern doge2048View = new ImagePattern(doge2048);
                    rectangle.setFill(doge2048View);
                }


        }

    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
