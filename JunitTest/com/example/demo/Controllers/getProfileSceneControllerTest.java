package com.example.demo.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class getProfileSceneControllerTest {
    getProfileSceneController getProfileSceneController=new getProfileSceneController();
    @Test
    void readAccounts() {
        String[] correctArr={"Colin","Alex","Rex","Mercy","Matten","Quincy"};
        getProfileSceneController.readAccounts();
        assertArrayEquals(correctArr,getProfileSceneController.getAccounts().toArray(correctArr));
    }
}