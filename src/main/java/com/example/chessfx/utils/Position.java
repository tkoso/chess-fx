package com.example.chessfx.utils;

public class Position {
    private char x;
    private char y;

    public Position(char x, char y) {
        // assert that X is from A to H and Y is from 1 to 8
        this.x = x;
        this.y = y;
    }

    public char getX() {
        return x;
    }

    public char getY() {
        return y;
    }

    public void setX(char x) {
        this.x = x;
    }

    public void setY(char y) {
        this.y = y;
    }
}
