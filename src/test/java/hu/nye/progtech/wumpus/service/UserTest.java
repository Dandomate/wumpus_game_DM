package hu.nye.progtech.wumpus.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserTest {

    private User user;
    private InputScanner inputScanner;

    @BeforeEach
    public void setUp() {
        inputScanner = Mockito.mock(InputScanner.class);
        user = new User(inputScanner);
    }

    @Test
    public void testValidUsername() {
        // Szimuláljuk, hogy a mock inputScanner a "JohnDoe" felhasználónevet adja vissza.
        when(inputScanner.nextLine()).thenReturn("JohnDoe");

        String result = user.askForUsername();
        assertEquals("JohnDoe", result);
    }

    @Test
    public void testInvalidUsername() {
        // Szimuláljuk, hogy a mock inputScanner először egy érvénytelen felhasználónevet ("A"), majd egy érvényest ("Valaki") ad vissza.
        when(inputScanner.nextLine()).thenReturn("A", "Valaki");

        // Teszteljük, hogy a felhasználó újra bekéri az érvénytelen felhasználónevet, majd helyes felhasználónevet ad vissza.
        String result = user.askForUsername();
        assertEquals("Valaki", result);
    }
}