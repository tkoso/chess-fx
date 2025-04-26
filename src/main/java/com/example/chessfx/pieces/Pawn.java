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
        return false;
    }
}
