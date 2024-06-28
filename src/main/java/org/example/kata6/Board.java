package org.example.kata6;


public class Board {

    private final String[] state;

    public Board(String state) {
        this.state = state.split("\n");
    }

    public String state() {
        return String.join("\n", this.state);
    }

    public Board next() {
        return new Board(".");
    }
}
