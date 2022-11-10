package com.example.demo.endGameElements;
import com.example.demo.Controllers.modeSelectSceneController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import static com.example.demo.Controllers.getProfileSceneController.getAccountName;

public class highScore {
    private final String pathToScore="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\highScore.txt";
    private final String pathToTemp="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\temp.txt";
    private final modeSelectSceneController modeSelectSceneController=new modeSelectSceneController();
    public String getHighscore(){
        try {
            File scoreFile = new File(pathToScore);
            Scanner reader = new Scanner(scoreFile);
            
            return reader.nextLine().split(":", 0)[1];
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return "0";
        }
    }
    public boolean newHighscore(long score){
        return Integer.parseInt(getHighscore()) < (score);
    }
    public void writeHighScore(long score){
        try {
            FileWriter writer = new FileWriter(pathToScore);
            writer.write(getAccountName()+":"+score+","+modeSelectSceneController.getChoice());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
