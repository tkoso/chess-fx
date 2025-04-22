package com.example.chessfx.utils;

import com.example.chessfx.pieces.AbstractPiece;
import com.example.chessfx.pieces.Pawn;

public class Board {
    public static char turn; // either B or W
    public static Move lastMove; // we need this to determine if en passant is legal
    private static Board instance;
    AbstractPiece[][] board;

    private Board() {
        board = new AbstractPiece[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (i == 1) {
                    board[i][j] = new Pawn('B');
                } else if (i == 6) {
                    board[i][j] = new Pawn('W');
                }
            }
        }
    }

    public Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
}
