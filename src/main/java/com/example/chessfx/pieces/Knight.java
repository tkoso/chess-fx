package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Knight extends AbstractPiece {
    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        // assert that end is correct
        int rankDiff = Math.abs(start.getRank() - end.getRank());
        int fileDiff = Math.abs(start.getFile() - end.getFile());
        Set<Pair<Integer, Integer>> possibleMoves = Set.of(
                new Pair<>(1, 2),
                new Pair<>(1, -2),
                new Pair<>(-1, 2),
                new Pair<>(-1, -2),
                new Pair<>(2, 1),
                new Pair<>(2, -1),
                new Pair<>(-2, 1),
                new Pair<>(-2, -1)
        );

        if (!possibleMoves.contains(new Pair<>(rankDiff, fileDiff))) return false;

        return board.getPiece(end).map(p -> p.getColor() != getColor()).orElse(true);
    }

}
