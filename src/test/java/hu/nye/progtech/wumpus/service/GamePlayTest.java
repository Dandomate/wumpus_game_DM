package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Scoreboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GamePlayTest {
    @Mock
    private User mockedUser;

    @Mock
    private Menu mockedMenu;

    @Mock
    private Scoreboard mockedScoreboard;

    @InjectMocks
    private GamePlay gamePlay;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartGame() {
        // Arrange
        String expectedUsername = "testUsername";
        when(mockedUser.askForUsername()).thenReturn(expectedUsername);

        // Act
        gamePlay.startGame();

        // Assert
        assertEquals(expectedUsername, gamePlay.getUsername());
    }

     @Test
    void testShowMainMenu() {
        Menu mockedMenu = Mockito.mock(Menu.class);
        gamePlay.setMenu(mockedMenu); // Feltételezem, hogy van setter a menu beállításához

        gamePlay.showMainMenu();

        verify(mockedMenu, Mockito.times(1)).displayMainMenu();
    }


}