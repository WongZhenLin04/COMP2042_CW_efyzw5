package com.example.demo.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainMenuControllerTest {
    private final mainMenuController mainMenuController = new mainMenuController();
    @Test
    void dogeKeyIncrement() {
        mainMenuController.dogeKeyIncrement();
        assertEquals(1,mainMenuController.getDogeKeysPressed());
    }
}