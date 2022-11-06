package com.example.demo.Controllers;

import com.example.demo.Controllers.sceneController;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.demo.Main.*;
import java.io.IOException;

public class getProfileSceneController extends sceneController {
    @Override
    public void switchToScene() throws IOException {
        setSetModeRoot(modeSelLoader.load());
        setSetModeScene(new Scene(modeRoot, WIDTH, HEIGHT));
        primaryStage.setScene(modeScene);
    }

    @Override
    public void detectEvent(Event event) throws IOException {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        switchToScene();
    }
}
