package com.example.demo.endGameElements;
import javafx.scene.Group;

import static com.example.demo.Controllers.getProfileSceneController.*;
import static com.example.demo.Controllers.modeSelectSceneController.*;
import java.io.*;
import java.util.Objects;

public class highScore {
    private final String pathToScore="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\highScore.txt";
    private final String pathToTemp="COMP2042_CW_efyzw5\\src\\src\\main\\resources\\com\\example\\demo\\temp.txt";
    private final endGameVisuals endGameVisuals = new endGameVisuals();
    public void setHighscore(long score, Group root){
        try {
            String currentLine;
            File scoreFile = new File(pathToScore);
            File tempFile = new File(pathToTemp);
            BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(Objects.equals(trimmedLine.split(",", 0)[1], getChoice())){
                    int highScoreForMode = Integer.parseInt(trimmedLine.split(":", 0)[1].split(",",0)[0]);
                    if(highScoreForMode<score){
                        endGameVisuals.setNewHighScore(root);
                        writer.write(getAccountName()+":"+score+","+getChoice() + System.getProperty("line.separator"));
                        continue;
                    }
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean delete = scoreFile.delete();
            boolean successful = tempFile.renameTo(scoreFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
