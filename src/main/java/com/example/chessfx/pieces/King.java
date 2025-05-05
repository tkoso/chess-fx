package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class King extends AbstractPiece {
    public King(Color color) {
        super(PieceType.KING, color);
    }


    @Override
    public boolean isValid(Board board, Position start, Position end) {
        // assert that end is within the board
        // TODO: add castling
        int rankDiff = Math.abs(start.getRank() - end.getRank());
        int fileDiff = Math.abs(start.getFile() - end.getFile());

        if (Math.max(rankDiff, fileDiff) > 1) return false;

        return board.getPiece(end).map(p -> p.getColor() != getColor()).orElse(true);
    }

}
