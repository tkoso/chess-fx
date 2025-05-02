package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import javafx.scene.image.ImageView;

public abstract class AbstractPiece {
    private final PieceType type;
    private final Color color;

    // only checks if given type of piece can move in such way
    public abstract boolean isValid(Board board, Position start, Position end);


    public AbstractPiece(PieceType type, Color color) {
        this.type = type;
        this.color = color;

    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return (color == Color.WHITE ? "w" : "b") + "-" + type.name().toLowerCase(); // so that it matches file name format
    }

}
