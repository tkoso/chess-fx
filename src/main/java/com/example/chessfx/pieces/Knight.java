package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Knight extends AbstractPiece {
    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }

    @Override
    public String toString() {
        return "knight";
    }
}
