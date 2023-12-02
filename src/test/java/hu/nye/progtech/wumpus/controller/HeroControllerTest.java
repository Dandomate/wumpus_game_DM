
package hu.nye.progtech.wumpus.controller;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.CellType;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Position;
import hu.nye.progtech.wumpus.service.Menu;
import hu.nye.progtech.wumpus.service.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HeroControllerTest {

    private User mockUser;
    private Menu mockMenu;
    private Board mockBoard;
    private HeroController heroController;

    @Before
    public void setup() {
        mockUser = mock(User.class);
        mockMenu = mock(Menu.class);
        mockBoard = mock(Board.class);

        heroController = new HeroController(mockUser, mockMenu);
        heroController.setBoard(mockBoard);
    }

    @Test
    public void testHandleInputEmptyCell() {
        Position initialPosition = new Position(0, 'A');
        Direction initialDirection = Direction.NORTH;
        heroController.setInitialPosition(initialPosition, initialDirection);

        when(mockBoard.getCellType(any(Position.class))).thenReturn(CellType.EMPTY);

        heroController.handleInput("W");

        verify(mockBoard, times(1)).updateBoard(any(Position.class));
    }

    @Test
    public void testSetInitialPosition() {
        Position initialPosition = new Position(0, 'A');
        Direction initialDirection = Direction.NORTH;

        heroController.setInitialPosition(initialPosition, initialDirection);

        // Ellenőrzés, hogy a heroPosition és heroDirection megfelelően be lett állítva
        assertEquals(initialPosition, heroController.getHeroPosition());
        assertEquals(initialDirection, heroController.getHeroDirection());
    }

    @Test
    public void testSetBoard() {
        heroController.setBoard(mockBoard);

        // Ellenőrzés, hogy a board megfelelően be lett állítva
        assertEquals(mockBoard, heroController.getBoard());
    }

    @Test
    public void testRemoveWumpus() {
        // Előkészítés
        Position arrowPosition = mock(Position.class);
        when(arrowPosition.getRow()).thenReturn(1);
        when(arrowPosition.getColumn()).thenReturn('A');

        Board mockBoard = mock(Board.class);
        when(mockBoard.getSize()).thenReturn(3);  // példa méret

        when(mockBoard.getCellType(arrowPosition)).thenReturn(CellType.WUMPUS);

        heroController.setBoard(mockBoard);

        // Tesztelés
        heroController.removeWumpus(arrowPosition);

        // Ellenőrzés, hogy a board.updateBoard metódust egyszer hívták meg
        verify(mockBoard, times(1)).updateBoard(arrowPosition);
    }

    
}