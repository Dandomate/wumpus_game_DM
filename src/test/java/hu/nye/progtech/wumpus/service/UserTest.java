package hu.nye.progtech.wumpus.service;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testAskForUsername() {
        // Előkészítünk egy hamis bemeneti adatfolyamot
        String testInput = "ValidUsername\n";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Teszteljük az askForUsername metódust
        User user = new User(scanner);
        String result = user.askForUsername();

        // Ellenőrizzük az eredményt
        assertEquals("ValidUsername", result);
    }
}