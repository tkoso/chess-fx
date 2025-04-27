package com.example.chessfx;

import com.example.chessfx.controller.Controller;
import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import com.example.chessfx.pieces.AbstractPiece;
import com.example.chessfx.pieces.Color;
import com.example.chessfx.pieces.PieceType;
import com.example.chessfx.view.PieceView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, javafx.scene.paint.Color.LIGHTCORAL);

//        Controller controller = new Controller();
//        controller.init();
        Board board = Board.getInstance();

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Rectangle rectangle = new Rectangle();
                rectangle.setX(i * 100);
                rectangle.setY(j * 100);
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setFill(((i + j) % 2 == 0) ? javafx.scene.paint.Color.LIGHTGRAY : javafx.scene.paint.Color.ROSYBROWN);
                rectangle.setStrokeType(StrokeType.INSIDE);
                rectangle.setStroke(javafx.scene.paint.Color.BLACK);
                root.getChildren().add(rectangle);
            }
        }

        List<Position> arr = Board.getInstance().getAllPositions();
        for (Position position : arr) {
//            System.out.println(position);
            PieceView pieceView = null;
            Optional<AbstractPiece> optPiece = board.getPiece(position);
            if (optPiece.isPresent()) {
                AbstractPiece piece = optPiece.get();
                switch (piece.getType()) {
                    case PAWN:
                        if (piece.getColor() == Color.WHITE) {
                            Image image = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-pawn.png"));
                            pieceView = new PieceView(image);
                            pieceView.update(null, position);
                        } else if (piece.getColor() == Color.BLACK) {
                            Image image = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-pawn.png"));
                            pieceView = new PieceView(image);
                            pieceView.update(null, position);
                        }
                        break;
                    case ROOK:

                        break;
                    case KNIGHT:

                        break;
                    case KING:

                        break;
                    case BISHOP:

                        break;
                    case QUEEN:

                        break;
                }
            }

            if (pieceView != null) {
                root.getChildren().add(pieceView);
            }
            board.setSubscriber(position, pieceView);
        }

        scene.setOnMouseClicked(event -> {
            int x = (int)(event.getX() / 100) + 'A';
            int y = (int)(8 - event.getY() / 100 + 1) + '0';

            // assert that x is within A-H and y within 1-8

            System.out.println((char)x + "" + (char)y);
            board.handleClick(new Position((char)x, (char)y));
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}