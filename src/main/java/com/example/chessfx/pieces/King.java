package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class King extends AbstractPiece {
    public King(Color color) {
        super(PieceType.KING, color);
    }


    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }

    @Override
    public String toString() {
        return "king";
    }
}
