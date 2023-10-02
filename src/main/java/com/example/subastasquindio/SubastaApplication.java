package com.example.subastasquindio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SubastaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SubastaApplication.class.getResource("SubastaView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
            stage.setTitle("Subastas Quindio");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}