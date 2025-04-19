package com.example.chessfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.LIGHTCORAL);



        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Rectangle rectangle = new Rectangle();
                rectangle.setX(i * 100);
                rectangle.setY(j * 100);
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setFill(((i + j) % 2 == 0) ? Color.LIGHTGRAY : Color.ROSYBROWN);
                root.getChildren().add(rectangle);
            }
        }

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}