package hu.nye.progtech.wumpus.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class ScoreManagerTest {

    private InputScanner2 createMockInputScanner2(String username) {
        return new InputScanner2() {
            @Override
            public String nextLine() {
                return username;
            }
        };
    }

    private User createUserWithMockInputScanner2(String username) {
        return new User(createMockInputScanner2(username));
    }

    @Test
    void testIncrementScore() {
        ScoreManager scoreManager = new ScoreManager();
        User user = createUserWithMockInputScanner2("testUser");
        Map<String, Integer> scores = new HashMap<>();

        scoreManager.incrementScore(user, scores);
        user.incrementScore();

        assertEquals(1, user.getScore());
    }

    @Test
    void testSaveAndLoadScoresToFile() throws IOException {
        ScoreManager scoreManager = new ScoreManager();
        User user = createUserWithMockInputScanner2("testUser");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("testUser", 42);

        String filePath = "testScores.json";

        // Save scores to file
        scoreManager.saveScoresToFile(filePath, scores);

        // Load scores from file
        Map<String, Integer> loadedScores = scoreManager.loadScoresFromFile(filePath);

        assertEquals(scores, loadedScores);
    }

    @Test
    void testSaveAndLoadScoresToFileWithEmptyFile() throws IOException {
        ScoreManager scoreManager = new ScoreManager();
        User user = createUserWithMockInputScanner2("testUser");
        Map<String, Integer> scores = new HashMap<>();

        String filePath = "emptyFile.json";

        // Save scores to empty file
        scoreManager.saveScoresToFile(filePath, scores);

        // Load scores from empty file
        Map<String, Integer> loadedScores = scoreManager.loadScoresFromFile(filePath);

        assertEquals(scores, loadedScores);
    }


    @Test
    void testSaveAndLoadScoresToFileWithNonexistentFile() throws IOException {
        ScoreManager scoreManager = new ScoreManager();
        User user = createUserWithMockInputScanner2("testUser");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("testUser", 42);

        String filePath = "nonexistentFile.json";

        // Save scores to nonexistent file
        scoreManager.saveScoresToFile(filePath, scores);

        // Load scores from nonexistent file
        Map<String, Integer> loadedScores = scoreManager.loadScoresFromFile(filePath);

        // Assert that the loaded scores contain the expected values
        assertEquals(scores, loadedScores);
    }

}