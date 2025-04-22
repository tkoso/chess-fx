package com.example.chessfx.pieces;

import com.example.chessfx.utils.Board;
import com.example.chessfx.utils.Position;

public class Pawn extends AbstractPiece {
    private char color; // either W or B
    private boolean didFirstMove; // to determine if double move is possible


    public Pawn(char color) {
        this.color = color;
        this.didFirstMove = false;
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }
}
