package hu.nye.progtech.wumpus.service;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    void testNextIntWithValidInput() {
        // Arrange
        String input = "42\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        Input inputScanner = new Input(scanner);

        // Act
        int result = inputScanner.nextInt();

        // Assert
        assertEquals(42, result);
    }

}