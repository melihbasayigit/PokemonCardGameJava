package com.example.pokemoncardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneClass extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneClass.class.getResource("GameArea.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        scene.getStylesheets().add(SceneClass.class.getResource("/fontstyle.css").toExternalForm());
        stage.setTitle("Pokemon Card Game!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
