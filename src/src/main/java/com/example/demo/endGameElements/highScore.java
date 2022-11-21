package com.example.demo.endGameElements;
import javafx.scene.Group;

import static com.example.demo.Controllers.getProfileSceneController.*;
import static com.example.demo.Controllers.modeSelectSceneController.*;
import java.io.*;
import java.util.Objects;
/**
 * The highscore class is utilized through its function of determining if a new highscore is made after each user's gaming session. Generally, after each session, the class reads
 * from the highscore file and grabs the correct score for the correct mode (as class knows the mode chosen due to the fact that the getChoice method is a static) by checking each
 * line in the file sequentially. It is important to note that the operations of the file ultimately ends up creating a new file (temp) and destroying the aforementioned file.
 */
public class highScore {
    private final String pathToScore="COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\highScore.txt";
    private final String pathToTemp="COMP2042_CW_efyzw5-main\\src\\src\\main\\resources\\com\\example\\demo\\temp.txt";
    private final endGameVisuals endGameVisuals = new endGameVisuals();
    /**
     * The method for determining if a new highscore for a certain game mode by the user. The method reads the highscore file line by line (in doing so also separating the game mode
     * part of the line, since the format of the line is as such: Name:Score,game mode). After the correct line has been found, the highscore of that mode is compared to the current score,
     * if it's a new highscore, then we write the contents of the highscore file, expect for the line with the old highscore, onto the temp file and finally write the new highscore onto
     * the temp file and finally deleting the highscore file and renaming our temp file to match the old highscore file. Else, the highscore file essentially duplicates and one of the file is
     * deleted (that being the older file).
     * @param score the score that the user has set on their play through of the game before losing
     * @param root the container of the elements in which shall be displayed on the scene
     */
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
