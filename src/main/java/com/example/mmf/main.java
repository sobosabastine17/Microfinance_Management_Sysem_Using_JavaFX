package com.example.mmf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class main extends Application {
    private static Stage stg;
    public Button btnCustomers;
    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("dashboard" +
                ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
         // stage.setTitle("Hello!");
        // stage.initModality(Modality.WINDOW_MODAL);
           stage.setScene(scene);
        // stage.initModality(Modality.WINDOW_MODAL);
       // stage.initOwner(btnCustomers.getScene().getWindow());
       // stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(fxml));
        stg.getScene().setRoot(fxmlLoader.load());
    }

    public static void main(String[] args) {

        launch();
    }
}