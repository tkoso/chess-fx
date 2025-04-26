package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Bishop extends AbstractPiece {
    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }
}
