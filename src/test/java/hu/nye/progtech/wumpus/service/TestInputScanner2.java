package hu.nye.progtech.wumpus.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInputScanner2 {



    @Test
    void testNextLineHappyPath() {
        // Arrange
        InputScanner2 inputScanner = new MyInputScanner("Hello, World!");

        // Act
        String result = inputScanner.nextLine();

        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test
    void testNextLineWithInvalidInput() {
        // Arrange
        InputScanner2 inputScanner = new MyInputScanner(null);

        // Act
        String result = inputScanner.nextLine();

        // Assert
        assertEquals(null, result);
    }

    // Egyéb tesztek...

    private static class MyInputScanner implements InputScanner2 {
        private final String input;

        public MyInputScanner(String input) {
            this.input = input;
        }

        @Override
        public String nextLine() {
            return input;
        }
    }
}

