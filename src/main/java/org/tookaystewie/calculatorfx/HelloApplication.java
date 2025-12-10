package org.tookaystewie.calculatorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calculatorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 357, 400);
        stage.setTitle("CalculatorFX");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
