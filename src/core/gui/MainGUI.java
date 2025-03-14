package core.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        GUIManager.initialize(primaryStage);
        GUIManager.switchScreen("MainMenu");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
