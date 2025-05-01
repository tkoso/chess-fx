package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Queen extends AbstractPiece {
    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }

    @Override
    public String toString() {
        return "queen";
    }
}
