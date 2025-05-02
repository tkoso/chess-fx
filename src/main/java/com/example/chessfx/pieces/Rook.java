package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Rook extends AbstractPiece {
    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }

}
