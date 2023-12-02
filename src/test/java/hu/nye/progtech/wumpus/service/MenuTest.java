package hu.nye.progtech.wumpus.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {

    @Test
    public void testDisplayMainMenu1() {
        // Arrange
        InputScanner mockScanner = mock(InputScanner.class);
        when(mockScanner.nextInt()).thenReturn(1); // Teszteset a válasz lehetőségére

        GamePlay mockGamePlay = mock(GamePlay.class);

        Menu menu = new Menu(mockScanner, mockGamePlay);

        menu.displayMainMenu();
    }




    @Test
    public void testDisplayPlayMenu() {
        // Arrange
        InputScanner mockScanner = mock(InputScanner.class);
        when(mockScanner.nextInt()).thenReturn(1); // Teszteset a válasz lehetőségére

        GamePlay mockGamePlay = mock(GamePlay.class);

        Menu menu = new Menu(mockScanner, mockGamePlay);

        menu.displayPlayMenu();
    }

}