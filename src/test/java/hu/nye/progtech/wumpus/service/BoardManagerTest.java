package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;
import hu.nye.progtech.wumpus.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BoardManagerTest {

    private BoardManager boardManager;

    @BeforeEach
    void setUp() {
        boardManager = new BoardManager();
    }

    @Test
    void testLoadBoardFromFile() {
        // Arrange
        String filePath = "C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt";

        // Act
        boardManager.loadBoard(filePath);
        Board loadedBoard = boardManager.getGameBoard();

        // Assert
        assertNotNull(loadedBoard);
    }


    @Test
    void testGetGameStateWhenGameBoardIsNull() {
        // Act
        String gameState = boardManager.getGameState();

        // Assert
        assertEquals("Game state not available.", gameState);
    }

    @Test
    void testGetHeroInitialPosition() {
        boardManager.loadBoard("C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt");

        // Act
        Position initialPosition = boardManager.getHeroInitialPosition();
        // Assert
        assertNotNull(initialPosition);
    }

    @Test
    void testGetHeroInitialDirection() {
        // Arrange
        boardManager.loadBoard("C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt");

        // Act
        Direction initialDirection = boardManager.getHeroInitialDirection();

        // Assert
        assertNotNull(initialDirection);
    }

    @Test
    void testUpdateBoardHeroDirection() {
        // Arrange
        Board mockBoard = mock(Board.class);
        Hero mockHero = mock(Hero.class);

        // Beállítjuk a mockBoardot a boardManageren keresztül
        boardManager.setGameBoard(mockBoard);

        // Amikor meghívjuk a getHero metódust a mockBoardon, a mockHero-t adjuk vissza
        when(mockBoard.getHero()).thenReturn(mockHero);

        // Act
        Direction newDirection = Direction.NORTH;
        boardManager.updateBoardHeroDirection(newDirection);

        // Assert
        // Ellenőrizzük, hogy a mockHero setHeroDirection metódusa egyszer meghívódott-e a megfelelő paraméterrel
        verify(mockHero, times(1)).setHeroDirection(newDirection);
    }


}