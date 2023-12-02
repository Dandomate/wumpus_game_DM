package hu.nye.progtech.wumpus.service;


import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class UserTest {

    @Test
    void testAskForUsernameValidInput() {
        // Arrange
        String testInput = "ValidUsername";
        InputScanner2 testScanner = new TestInputScanner2(testInput);
        User user = new User(testScanner);

        // Act
        String result = user.askForUsername();

        // Assert
        assertEquals(testInput.trim(), result.trim());
    }


    @Test
    void testIncrementScore() {
        // Arrange
        User user = new User(new TestInputScanner2("TestInput"));

        // Act
        user.incrementScore();
        user.incrementScore();
        user.incrementScore();

        // Assert
        assertEquals(3, user.getScore());
    }

    @Test
    void testUserWithScore() {
        // Arrange
        User user = new User(new TestInputScanner2("Test"));

        // Act
        user.incrementScore();
        user.incrementScore();
        String result = user.getUserWithScore();

        // Assert
        assertEquals("Gratulálunk "+user.getUsername()+": 2 pontod van jelenleg", result);
    }

    private static class TestInputScanner2 implements InputScanner2 {
        private final String[] inputs;
        private int index;

        public TestInputScanner2(String... inputs) {
            this.inputs = inputs;
            this.index = 0;
        }

        @Override
        public String nextLine() {
            if (index < inputs.length) {
                return inputs[index++];
            }
            return "";
        }
    }

}