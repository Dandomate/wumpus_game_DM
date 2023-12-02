package hu.nye.progtech.wumpus.service;


import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class UserTest {

    @Test
    void testAskForUsername_ValidInput() {
        // Arrange
        InputScanner2 mockScanner = mock(InputScanner2.class);
        when(mockScanner.nextLine()).thenReturn("ValidUsername");

        User user = new User(mockScanner);

        // Act
        String result = user.askForUsername();

        // Assert
        assertEquals("ValidUsername", result);
    }

    @Test
    void testIncrementScore() {
        // Arrange
        InputScanner2 mockScanner = mock(InputScanner2.class);
        User user = new User(mockScanner);

        // Act
        user.incrementScore();

        // Assert
        assertEquals(1, user.getScore());
    }

    @Test
    void testGetUserWithScore() {
        // Arrange
        InputScanner2 mockScanner = mock(InputScanner2.class);
        when(mockScanner.nextLine()).thenReturn("TesztUser"); // A mock értéket ad vissza a nextLine hívásra

        User user = new User(mockScanner);
        user.askForUsername(); // Felhasználónév bekérdezése a mock-ot használva
        user.incrementScore(); // Pontszám növelése a teszteléshez

        // Act
        String result = user.getUserWithScore();

        // Assert
        assertEquals("Gratulálunk TesztUser: 1 pontod van jelenleg", result);
    }
}