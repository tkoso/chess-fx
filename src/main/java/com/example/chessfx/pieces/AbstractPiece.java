package com.example.chessfx.pieces;

import com.example.chessfx.utils.Board;
import com.example.chessfx.utils.Position;
import javafx.scene.image.ImageView;

enum PieceType { PAWN, ROOK, KNIGHT, BISHOP, KING, QUEEN }

public abstract class AbstractPiece {
    PieceType type;
    ImageView imageView; // the one we will modify

    // only checks if given type of piece can move in such way
    public abstract boolean isValid(Board board, Position start, Position end);

    public PieceType getType() {
        return type;
    }
}
