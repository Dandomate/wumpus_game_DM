package hu.nye.progtech.wumpus.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
class MenuTest {
    @BeforeEach
    public void setUp() {
        // Itt állítjuk be a bemeneti adatokat, például "1\n2\n3\n"
        String input = "1\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testDisplayMainMenu() {
        Menu menu = new Menu();
        // Most meghívjuk a tesztelendő metódust
        menu.displayMainMenu();
    }
}