package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import javafx.scene.image.ImageView;

public class Pawn extends AbstractPiece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        if (start.getFile() != end.getFile()) return false; // obviously it can do attacks diagonally but for now just check mvp
        if (getColor() == Color.WHITE) return start.getRank() + 1 == end.getRank();
        else if (getColor() == Color.BLACK) return start.getRank() - 1 == end.getRank();

        return false;
    }
}
