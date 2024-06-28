package org.example.kata6;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;

public class Board {

    private final String[] state;

    public Board(String state) {
        this.state = state.split("\n");
    }

    public String state() {
        return String.join("\n", this.state);
    }

    public Board next() {
        return new Board(calculate());
    }

    private String calculate() {
        return range(0, state.length)
                .mapToObj(i -> calculate(i) + "\n")
                .collect(Collectors.joining());
    }

    private String calculate(int i) {
        return range(0, state[0].length())
                .mapToObj(j -> valueOf(calculate(i, j)))
                .collect(Collectors.joining());
    }

    private char calculate(int i, int j) {
        return shouldBeAlive(i, j) ? 'X' : '.';
    }

    private boolean shouldBeAlive(int i, int j) {
        return isAlive(i, j) ?
                countAliveNeighbours(i,j) == 2 || countAliveNeighbours(i, j) == 3 :
                countAliveNeighbours(i, j) == 3;
    }

    private int countAliveNeighbours(int i, int j) {
        return (int) neighboursOf(i,j).stream()
                .filter(CheckAlive::check)
                .count();
    }

    private List<CheckAlive> neighboursOf(int i, int j) {
        return List.of(
                () -> isAlive(i-1, j+1),
                () -> isAlive(i-1, j-1),
                () -> isAlive(i-1, j),
                () -> isAlive(i, j+1),
                () -> isAlive(i, j-1),
                () -> isAlive(i+1, j+1),
                () -> isAlive(i+1, j-1),
                () -> isAlive(i+1, j)
        );
    }

    private boolean isAlive(int i, int j) {
        return isInBounds(i, j) && state[i].charAt(j) == 'X';
    }

    private boolean isInBounds(int i, int j) {
        return i >= 0 && i < state.length && j >= 0 && j < state[0].length();
    }
}
