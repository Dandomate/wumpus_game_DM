package hu.nye.progtech.wumpus.service;



import hu.nye.progtech.wumpus.model.*;
import hu.nye.progtech.wumpus.service.BoardUpdater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardUpdaterTest {

    private Board board;

    @BeforeEach
    public void setUp() {
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
    @Test
    public void testCopyBoard() {
        // Teszt a copyBoard metódusra
        char[][] source = {
                {'_', '_', '_'},
                {'H', '_', '_'},
                {'_', '_', '_'}
        };
        char[][] destination = new char[3][3];
        BoardUpdater.copyBoard(3, source, destination);

        // Ellenőrzés, hogy a másolat megegyezik-e a forrással
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(source[i][j], destination[i][j]);
            }
        }
    }
}