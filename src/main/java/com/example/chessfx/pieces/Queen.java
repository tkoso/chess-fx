package com.example.chessfx.pieces;

import com.example.chessfx.utils.Board;
import com.example.chessfx.utils.Position;

public class Queen extends AbstractPiece {
    @Override
    public boolean isValid(Board board, Position start, Position end) {
        return false;
    }
}
