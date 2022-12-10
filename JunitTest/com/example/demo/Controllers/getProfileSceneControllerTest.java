package com.example.demo.Controllers;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import static com.example.demo.Main.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class getProfileSceneControllerTest {
    getProfileSceneController getProfileSceneController=new getProfileSceneController();
    @Test
    void readAccounts() {
        File accountFile = new File(resourceHeader+"Accounts.txt");
        ArrayList<String> correctArr = new ArrayList<>();
        try {
            Scanner reader = new Scanner(accountFile);
            while (reader.hasNextLine()) {
                correctArr.add(reader.nextLine());
            }
            assertArrayEquals(correctArr.toArray(), getProfileSceneController.getAccounts().toArray());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}