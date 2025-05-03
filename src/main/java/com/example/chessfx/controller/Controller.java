package com.example.chessfx.controller;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import com.example.chessfx.pieces.AbstractPiece;
import com.example.chessfx.view.PieceView;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Controller {
    private final Board board;

    private PieceView initPieceView(AbstractPiece piece, Position position) throws FileNotFoundException { // maybe make it viewfactory or somethihg?
        Image image = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/"
                + piece + ".png"));
        PieceView pieceView = new PieceView(image);
        pieceView.update(null, position);
        return pieceView;
    }


    public Controller() {
        board = Board.getInstance();
    }

    public void initBoard(Group root) {
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
    }

    public void initPieces(Group root) throws FileNotFoundException {
        List<Position> arr = board.getAllPositions();
        for (Position position : arr) {
            PieceView pieceView = null;
            Optional<AbstractPiece> optPiece = board.getPiece(position);
            if (optPiece.isPresent()) {
                AbstractPiece piece = optPiece.get();
                pieceView = initPieceView(piece, position);
            }

            if (pieceView != null) {
                root.getChildren().add(pieceView);
            }
            board.setSubscriber(position, pieceView);
        }
    }

    public void handleClick(double eventX, double eventY) {
        int x = (int)(eventX / 100) + 'A';
        int y = (int)(8 - eventY / 100 + 1) + '0';

        // assert that x is within A-H and y within 1-8

        System.out.println((char)x + "" + (char)y);
        board.handleClick(new Position((char)x, (char)y));
    }

}
