package org.example.kata6;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;

public class Board {

    private final String[] state;
    private final char aliveCell = 'X';
    private final char deadCell = '.';
    private final String lineBreak = "\n";

    public Board(String state) {
        this.state = state.split(lineBreak);
    }

    public String state() {
        return String.join(lineBreak, this.state);
    }

    public Board next() {
        return new Board(calculate());
    }

    private String calculate() {
        return range(0, state.length)
                .mapToObj(i -> calculate(i) + lineBreak)
                .collect(Collectors.joining());
    }

    private String calculate(int i) {
        return range(0, state[0].length())
                .mapToObj(j -> valueOf(calculate(i, j)))
                .collect(Collectors.joining());
    }

    private char calculate(int i, int j) {
        return shouldBeAlive(i, j) ? aliveCell : deadCell;
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
        return isInBounds(i, j) && cellAt(i, j) == aliveCell;
    }

    private char cellAt(int i, int j) {
        return state[i].charAt(j);
    }

    private boolean isInBounds(int i, int j) {
        return i >= 0 && i < state.length && j >= 0 && j < state[0].length();
    }
}
