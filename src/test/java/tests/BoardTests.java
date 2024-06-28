package tests;

import org.example.kata6.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTests {

    @Test
    public void should_return_empty_board_given_empty_board(){
        Board board = new Board("");
        assertEquals(board.state(), "");
    }

    @Test
    public void should_return_1x1_board_with_dead_cell_given_1x1_board_with_dead_cell(){
        Board board = new Board(".");
        assertEquals(board.state(), ".");
    }

    @Test
    public void should_return_1x1_board_with_dead_cell_given_1x1_board_with_alive_cell(){
        Board board = new Board("X");
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), ".");
    }


}
