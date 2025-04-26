package com.example.chessfx;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SceneDrawer {
    private final Group root;



    private void drawBishops() throws FileNotFoundException {
        // white bishops
        Image wBishopImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-bishop.png"));
        ImageView wBishopImageViewL = new ImageView(wBishopImage);
        wBishopImageViewL.setX(200);
        wBishopImageViewL.setY(700);
        root.getChildren().add(wBishopImageViewL);

        ImageView wBishopImageViewR = new ImageView(wBishopImage);
        wBishopImageViewR.setX(500);
        wBishopImageViewR.setY(700);
        root.getChildren().add(wBishopImageViewR);

        // black bishops
        Image bBishopImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-bishop.png"));
        ImageView bBishopImageViewL = new ImageView(bBishopImage);
        bBishopImageViewL.setX(200);
        bBishopImageViewL.setY(0);
        root.getChildren().add(bBishopImageViewL);

        ImageView bBishopImageViewR = new ImageView(bBishopImage);
        bBishopImageViewR.setX(500);
        bBishopImageViewR.setY(0);
        root.getChildren().add(bBishopImageViewR);
    }

    private void drawPawns() throws FileNotFoundException {
        Image wPawnImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-pawn.png"));
        for (int i = 0; i < 8; ++i) {
            ImageView wPawnImageView = new ImageView(wPawnImage);
            wPawnImageView.setX(i * 100);
            wPawnImageView.setY(600);
            root.getChildren().add(wPawnImageView);
        }

        Image bPawnImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-pawn.png"));
        for (int i = 0; i < 8; ++i) {
            ImageView bPawnImageView = new ImageView(bPawnImage);
            bPawnImageView.setX(i * 100);
            bPawnImageView.setY(100);
            root.getChildren().add(bPawnImageView);
        }
    }

    private void drawKnights() throws FileNotFoundException {
        // white knights
        Image wKnightImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-knight.png"));
        ImageView wKnightImageViewL = new ImageView(wKnightImage);
        wKnightImageViewL.setX(100);
        wKnightImageViewL.setY(700);
        root.getChildren().add(wKnightImageViewL);

        ImageView wKnightImageViewR = new ImageView(wKnightImage);
        wKnightImageViewR.setX(600);
        wKnightImageViewR.setY(700);
        root.getChildren().add(wKnightImageViewR);

        // black knights
        Image bKnightImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-knight.png"));
        ImageView bKnightImageViewL = new ImageView(bKnightImage);
        bKnightImageViewL.setX(100);
        bKnightImageViewL.setY(0);
        root.getChildren().add(bKnightImageViewL);

        ImageView bKnightImageViewR = new ImageView(bKnightImage);
        bKnightImageViewR.setX(600);
        bKnightImageViewR.setY(0);
        root.getChildren().add(bKnightImageViewR);
    }

    private void drawRooks() throws FileNotFoundException {
        // white rooks
        Image wRookImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-rook.png"));
        ImageView wRookImageViewL = new ImageView(wRookImage);
        wRookImageViewL.setX(0);
        wRookImageViewL.setY(700);
        root.getChildren().add(wRookImageViewL);

        ImageView wRookImageViewR = new ImageView(wRookImage);
        wRookImageViewR.setX(700);
        wRookImageViewR.setY(700);
        root.getChildren().add(wRookImageViewR);

        // black rooks
        Image bRookImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-rook.png"));
        ImageView bRookImageViewL = new ImageView(bRookImage);
        bRookImageViewL.setX(0);
        bRookImageViewL.setY(0);
        root.getChildren().add(bRookImageViewL);

        ImageView bRookImageViewR = new ImageView(bRookImage);
        bRookImageViewR.setX(700);
        bRookImageViewR.setY(0);
        root.getChildren().add(bRookImageViewR);
    }

    private void drawKings() throws FileNotFoundException {
        Image wKingImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-king.png"));
        ImageView wKingImageView = new ImageView(wKingImage);
        wKingImageView.setX(400);
        wKingImageView.setY(700);
        root.getChildren().add(wKingImageView);

        Image bKingImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-king.png"));
        ImageView bKingImageView = new ImageView(bKingImage);
        bKingImageView.setX(400);
        bKingImageView.setY(0);
        root.getChildren().add(bKingImageView);
    }

    private void drawQueens() throws FileNotFoundException {
        Image wQueenImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/w-queen.png"));
        ImageView wKQueenImageView = new ImageView(wQueenImage);
        wKQueenImageView.setX(300);
        wKQueenImageView.setY(700);
        root.getChildren().add(wKQueenImageView);

        Image bQueenImage = new Image(new FileInputStream("/home/tomek/Desktop/random_stuff/java/CHESSFX/src/main/resources/graphics/b-queen.png"));
        ImageView bQueenImageView = new ImageView(bQueenImage);
        bQueenImageView.setX(300);
        bQueenImageView.setY(0);
        root.getChildren().add(bQueenImageView);
    }

    private void drawPieces() throws FileNotFoundException {
        drawBishops();
        drawPawns();
        drawKnights();
        drawRooks();
        drawKings();
        drawQueens();
    }

    public SceneDrawer(Group root) {
        this.root = root;
    }

    public void updateScene() throws FileNotFoundException {
//        drawBoard();
        drawPieces();
    }
}
