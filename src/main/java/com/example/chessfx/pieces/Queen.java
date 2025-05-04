package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;

public class Queen extends AbstractPiece {
    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        Bishop bishop = new Bishop(getColor());
        Rook rook = new Rook(getColor());

        return bishop.isValid(board, start, end) || rook.isValid(board, start, end);

    }

}
