package com.example.chessfx.model;

import com.example.chessfx.pieces.*;
import com.example.chessfx.view.PieceView;

import java.util.*;

public class Board {
    private static Board instance;
    private static Color turn;
    private static Move lastMove; // we need this to determine if en passant is legal
    private static Map<Position, AbstractPiece> board; // file and rank to piece
    private static Map<Position, TileListener> subscribers;
    private static Position currentlySelectedPosition;

    private Board() {
        board = new HashMap<>();
        subscribers = new HashMap<>();
        turn = Color.WHITE;
        lastMove = null;
        for (char file = 'A'; file <= 'H'; ++file) {
            for (char rank = '1'; rank <= '8'; ++rank) {
                Position position = new Position(file, rank);
                board.put(position, null);
            }
        }

        // pawns
        for (char file = 'A'; file <= 'H'; ++file) {
            board.put(new Position(file, '2'), new Pawn(Color.WHITE));
            board.put(new Position(file, '7'), new Pawn(Color.BLACK));
        }

        // knights
        board.put(new Position('B', '1'), new Knight(Color.WHITE));
        board.put(new Position('G', '1'), new Knight(Color.WHITE));
        board.put(new Position('B', '8'), new Knight(Color.BLACK));
        board.put(new Position('G', '8'), new Knight(Color.BLACK));

        // bishops
        board.put(new Position('C', '1'), new Bishop(Color.WHITE));
        board.put(new Position('F', '1'), new Bishop(Color.WHITE));
        board.put(new Position('C', '8'), new Bishop(Color.BLACK));
        board.put(new Position('F', '8'), new Bishop(Color.BLACK));

        // rooks
        board.put(new Position('A', '1'), new Rook(Color.WHITE));
        board.put(new Position('H', '1'), new Rook(Color.WHITE));
        board.put(new Position('A', '8'), new Rook(Color.BLACK));
        board.put(new Position('H', '8'), new Rook(Color.BLACK));

        // kings
        board.put(new Position('E', '1'), new King(Color.WHITE));
        board.put(new Position('E', '8'), new King(Color.BLACK));

        // queens
        board.put(new Position('D', '1'), new Queen(Color.WHITE));
        board.put(new Position('D', '8'), new Queen(Color.BLACK));
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Optional<AbstractPiece> getPiece(Position p) {
        return Optional.ofNullable(board.get(p));
    }

    public List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>(board.keySet());
        positions.sort(Comparator.comparing(Position::getFile).thenComparing(Position::getRank));
        return positions;
    }

    public void setSubscriber(Position position, TileListener pieceView) {
        subscribers.put(position, pieceView);
    }

    private boolean helperMovingFunction(Position position, AbstractPiece piece) {
        boolean isMoveOK = piece.isValid(this, currentlySelectedPosition, position);
        if (isMoveOK) {
            TileListener pieceViewOfMovedPiece = subscribers.get(currentlySelectedPosition);
            TileListener pieceViewOfDestroyedPiece = subscribers.get(position);
            if (pieceViewOfDestroyedPiece != null) {
                pieceViewOfDestroyedPiece.update(position, null); // delete the captured piece
            }

            pieceViewOfMovedPiece.update(currentlySelectedPosition, position); // update the image rendering


            setSubscriber(position, pieceViewOfMovedPiece);
            setSubscriber(currentlySelectedPosition, null);
            return true;
        } else {
            System.out.println("INVALID MOVE");
            return false;
        }
    }

    public void handleClick(Position position) {
        if (currentlySelectedPosition == null) {
            AbstractPiece piece = board.get(position);
            if (piece != null && piece.getColor() == turn) {
                currentlySelectedPosition = position;
            }
            return;
        }
        // here we assert that currentlySelectedPosition is not null
        // it's important to note that it implies that movingPiece will be not null as well
        AbstractPiece movingPiece = board.get(currentlySelectedPosition);
        AbstractPiece piece = board.get(position); // it can be null
        if (piece == null) {
            boolean b = helperMovingFunction(position, movingPiece);
            if (b) { // we moved so we clear the selected pos
                board.put(currentlySelectedPosition, null);
                board.put(position, movingPiece);
                currentlySelectedPosition = null;
                turn = (turn == Color.WHITE ? Color.BLACK : Color.WHITE);
            }
        }
        else if (piece.getColor() != turn) {
            boolean b = helperMovingFunction(position, movingPiece);
            if (b) {
                board.put(currentlySelectedPosition, null);
                board.put(position, movingPiece);
                currentlySelectedPosition = null;
                turn = (turn == Color.WHITE ? Color.BLACK : Color.WHITE);
            }
        } else if (piece.getColor() == turn) {
            currentlySelectedPosition = position;
        }
    }
}
