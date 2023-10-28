package hu.nye.progtech.wumpus.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testGetSize() {
        Board board = new Board(5, new char[5][5], new Hero(2,'B',Direction.WEST,1));
        int size = board.getSize();
        assertEquals(5, size);
    }

    @Test
    public void testGetBoard() {
        char[][] testBoard = new char[5][5]; // Az aktuális pálya mátrixa
        Board board = new Board(5, testBoard, new Hero(2,'B',Direction.WEST,1));
        char[][] boardArray = board.getBoard();
        assertEquals(testBoard, boardArray);
    }

    @Test
    public void testGetHero() {
        Hero testHero = new Hero(1, 'A', Direction.NORTH, 3); // Teszthős
        Board board = new Board(5, new char[5][5], testHero);
        Hero hero = board.getHero();
        assertEquals(testHero, hero);
    }
}