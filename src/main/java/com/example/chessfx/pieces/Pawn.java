package com.example.chessfx.pieces;

import com.example.chessfx.model.Board;
import com.example.chessfx.model.Position;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class Pawn extends AbstractPiece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean isValid(Board board, Position start, Position end) {
        Optional<AbstractPiece> optPiece = board.getPiece(start);
        if (optPiece.isEmpty() || optPiece.get().getType() != PieceType.PAWN) {
            return false;
        }
        Optional<AbstractPiece> optPieceEnd = board.getPiece(end);

        AbstractPiece piece = optPiece.get();
        Color color = piece.getColor();

        boolean singleMove = (start.getFile() == end.getFile())
                && ((start.getRank() - end.getRank() == 1 && color == Color.BLACK)
                || (start.getRank() - end.getRank() == -1 && color == Color.WHITE));
        boolean diagonalAttack = (start.getFile() == end.getFile() - 1 || start.getFile() == end.getFile() + 1)
                && ((start.getRank() - end.getRank() == 1 && color == Color.BLACK)
                || (start.getRank() - end.getRank() == -1 && color == Color.WHITE));
        boolean doubleMove = (start.getFile() == end.getFile())
                && ((start.getRank() == '7' && start.getRank() - end.getRank() == 2 && color == Color.BLACK)
                || (start.getRank() == '2' && start.getRank() - end.getRank() == -2 && color == Color.WHITE));
        if (singleMove) {
            return optPieceEnd.isEmpty();
        } else if (diagonalAttack) {
            if (optPieceEnd.isEmpty()) return false; // here we have to check if en passant happened!!!!
            else {
                AbstractPiece pieceEnd = optPieceEnd.get();
                return (color == Color.BLACK && pieceEnd.getColor() == Color.WHITE ||
                        color == Color.WHITE && pieceEnd.getColor() == Color.BLACK);

            }

        } else if (doubleMove) {
            Optional<AbstractPiece> middlePiece = board.getPiece(new Position(start.getFile(), (char)(start.getRank() + (color == Color.WHITE ? +1 : -1))));
            return middlePiece.isEmpty() && optPieceEnd.isEmpty();
        }


        return false;
    }

}
