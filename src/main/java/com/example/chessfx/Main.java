package com.example.chessfx;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import com.example.chessfx.view.PieceView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.LIGHTCORAL);

        Board board = Board.getInstance();

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Rectangle rectangle = new Rectangle();
                rectangle.setX(i * 100);
                rectangle.setY(j * 100);
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setFill(((i + j) % 2 == 0) ? Color.LIGHTGRAY : Color.ROSYBROWN);
                rectangle.setStrokeType(StrokeType.INSIDE);
                rectangle.setStroke(Color.BLACK);
                root.getChildren().add(rectangle);
            }
        }

        List<Position> arr = Board.getInstance().getAllPositions();
        for (Position position : arr) {
            System.out.println(position);
            PieceView pieceView = new PieceView();
            Board.addSubscriber(position, pieceView);
        }


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}