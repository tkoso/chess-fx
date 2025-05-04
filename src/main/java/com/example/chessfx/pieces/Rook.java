package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Rook extends AbstractPiece {
    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        // assert that end is a correct pos
        int rankDiff = Math.abs(start.getRank() - end.getRank());
        int fileDiff = Math.abs(start.getFile() - end.getFile());
        if ((end.getFile() != start.getFile() && end.getRank() != start.getRank()) || (end.equals(start))) return false;

        int rankStep = (end.getRank() >= start.getRank() ? (end.getRank() == start.getRank() ? 0 : 1) : -1);
        int fileStep = (end.getFile() >= start.getFile() ? (end.getFile() == start.getFile() ? 0 : 1) : -1);

        for (int i = 1; i < Math.max(rankDiff, fileDiff); ++i) {
            Position pos = new Position(
                    (char) (start.getFile() + i * fileStep), (char) (start.getRank() + i * rankStep)
            );
            if (board.getPiece(pos).isPresent()) return false;
        }

        return board.getPiece(end).map(p -> p.getColor() != getColor()).orElse(true);
    }

}
