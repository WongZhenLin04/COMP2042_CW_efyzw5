package com.example.demo.gameElements;

import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    Group root =new Group();
    @Test
    void changeCell() {
        Cell cell1=new Cell(1,1,5,root);
        Cell cell2=new Cell(2,2,5,root);
        cell1.setTextClass(new Text("2"));
        cell2.setTextClass(new Text("4"));
        cell1.changeCell(cell2);
        assertEquals(4,cell1.getNumber());
        assertEquals(2,cell2.getNumber());
    }
    @Test
    void setColorByNumber0() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("0"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xfcfcfcff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber2() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("2"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xeee4daff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber4() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("4"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xede0c8ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber8() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("8"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xf2b179ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber16() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("16"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xf59563ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber32() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("32"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xf67c60ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber64() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("64"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xf65e3bff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber128() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("128"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xedcf73ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber256() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("256"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xedcc62ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber512() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("512"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xedc850ff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber1024() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("1024"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xedc53fff",cell.getRectangle().getFill().toString());
    }
    @Test
    void setColorByNumber2048() {
        Cell cell = new Cell(1,1,5,root);
        cell.setTextClass(new Text("2048"));
        cell.setColorByNumber(cell.getNumber());
        assertEquals("0xedc22dff",cell.getRectangle().getFill().toString());
    }
    @Test
    void adder() {
        Cell cell1=new Cell(1,1,5,root);
        Cell cell2=new Cell(2,2,5,root);
        cell1.setTextClass(new Text("2"));
        cell2.setTextClass(new Text("2"));
        cell1.adder(cell2);
        assertEquals(0,cell1.getNumber());
        assertEquals(4,cell2.getNumber());
        assertEquals("0xfcfcfcff",cell1.getRectangle().getFill().toString());
        assertEquals("0xede0c8ff",cell2.getRectangle().getFill().toString());
    }
}