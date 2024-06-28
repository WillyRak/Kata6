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

    @Test
    public void should_return_row_board_with_dead_cells_given_row_board_with_alive_cells(){
        Board board = new Board("XX.");
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), "...");
    }

    @Test
    public void should_return_board_2x2_with_all_dead_cells_given_2x2_board_with_all_dead_cells(){
        Board board = new Board("""
                ..
                ..
                """.trim());
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), """
                ..
                ..
                """.trim());
    }

    @Test
    public void should_return_board_2x2_with_all_alive_cells_given_2x2_board_with_all_alive_cells(){
        Board board = new Board("""
                XX
                XX
                """.trim());
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), """
                XX
                XX
                """.trim());
    }

    @Test
    public void should_return_board_2x2_with_all_alive_cells_given_2x2_board_with_triangle_structure(){
        Board board = new Board("""
                X.
                XX
                """.trim());
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), """
                XX
                XX
                """.trim());
    }

    @Test
    public void should_return_board_2x2_with_all_dead_cells_given_2x2_board_with_one_alive_cell(){
        Board board = new Board("""
                .X
                ..
                """.trim());
        Board nextBoard = board.next();
        assertEquals(nextBoard.state(), """
                ..
                ..
                """.trim());
    }


}
