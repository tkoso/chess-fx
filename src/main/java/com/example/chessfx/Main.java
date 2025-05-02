package com.example.chessfx;

import com.example.chessfx.controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, javafx.scene.paint.Color.LIGHTCORAL);

        Controller controller = new Controller();
        controller.initBoard(root);
        controller.initPieces(root);
        scene.setOnMouseClicked(event -> {
            controller.handleClick(event.getX(), event.getY());
        });







        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}