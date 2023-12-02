
package hu.nye.progtech.wumpus.model;

import org.junit.jupiter.api.BeforeEach;
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

    private Board board;

    @BeforeEach
    public void setUp() {
        // Előkészítés minden teszt előtt
        int size = 3;
        char[][] initialBoard = {
                {'_', '_', '_'},
                {'_', 'H', '_'},
                {'_', '_', '_'}
        };
        Hero hero = new Hero(1, 'A', Direction.NORTH, 3, false);
        board = new Board(size, initialBoard, hero);
    }

    @Test
    public void testUpdateBoard() {
        // Teszt az updateBoard metódusra
        Position newPosition = new Position(1, 'A');
        board.updateBoard(newPosition);

        // Ellenőrzés, hogy a hős helyesen mozgott-e
        assertEquals(newPosition, board.getHero().getHeroPosition());
    }

    @Test
    public void testGetCellType() {
        // Teszt a getCellType metódusra
        Position position = new Position(1,'B' );
        CellType cellType = board.getCellType(position);

        // Ellenőrzés, hogy a megfelelő cellatípust adja-e vissza
        assertEquals(CellType.HERO, cellType);
    }
}

