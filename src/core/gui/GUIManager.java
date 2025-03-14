package core.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIManager {
    private static Stage primaryStage;

    public static void initialize(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Board Game Platform");
        primaryStage.setResizable(false);  // Optional: Prevent resizing
    }

    public static void switchScreen(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(GUIManager.class.getResource("/resources/fxml/" + fxmlFile + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading screen: " + fxmlFile);
        }
    }
}
