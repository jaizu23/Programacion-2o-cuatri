package main.java.PEC2.T5.Ejercicio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SystemTest extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemTest.class.getResource("ScreenPuente.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Puente Estrecho");
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setWidth(800);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}