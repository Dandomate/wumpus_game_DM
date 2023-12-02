package hu.nye.progtech.wumpus.service;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input2Test {
    @Test
    void testNextLine() {
        // Arrange
        String input = "alma";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner mockScanner = new Scanner(in);
        Input2 input2 = new Input2(mockScanner);

        // Act
        String result = input2.nextLine();

        // Assert
        assertEquals("alma", result);
    }
}