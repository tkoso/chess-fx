package com.example.chessfx.model;

public class Position {
    private final char file;
    private final char rank;

    public Position(char file, char rank) {
        // assert that file is from A to H and rank is from 1 to 8
        this.file = file;
        this.rank = rank;
    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Position xd)) return false;
        return this.file == xd.file && this.rank == xd.rank;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return "" + file + rank;
    }

}
