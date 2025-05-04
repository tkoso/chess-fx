package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Bishop extends AbstractPiece {
    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        int rankDiff = Math.abs(start.getRank() - end.getRank());
        int fileDiff = Math.abs(start.getFile() - end.getFile());
        // make sure that the end position is within the board
        if (rankDiff != fileDiff) {
            return false;
        }

        int rankStep = (end.getRank() > start.getRank() ? 1 : -1);
        int fileStep = (end.getFile() > start.getFile() ? 1 : -1);
        for (int i = 1; i < fileDiff; ++i) {
            Position pos = new Position((char)(start.getFile() + i * fileStep), (char)(start.getRank() + i * rankStep));
            if (board.getPiece(pos).isPresent()) {
                return false;
            }
        }
        // from the docs: Optional.map():
        // If a value is present, apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result.
        return board.getPiece(end).map(p -> p.getColor() != getColor()).orElse(true);
    }
}
