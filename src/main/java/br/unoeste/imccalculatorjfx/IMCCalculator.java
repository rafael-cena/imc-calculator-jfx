package br.unoeste.imccalculatorjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IMCCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 397, 439);
        stage.setTitle("IMC Calculator FX v0.1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}