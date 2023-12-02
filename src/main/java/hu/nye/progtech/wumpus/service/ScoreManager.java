package hu.nye.progtech.wumpus.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScoreManager {

    private final Logger LOGGER = LoggerFactory.getLogger(ScoreManager.class);

    public void incrementScore(User user, Map<String, Integer> scores) {
        scores.put(user.getUsername(), user.getScore());
    }

    public void displayUserScore(User user) {
        System.out.println("Felhasználó: " + user.getUsername() + ", pontszám: " + user.getScore());
    }

    public void saveScoresToFile(String filePath, Map<String, Integer> scores) {
        LOGGER.info("save scores, filePath: {}", filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Betöltjük a korábbi eredményeket a JSON-ből
            Map<String, Integer> existingScores = loadScoresFromFile(filePath);

            // Az új eredményeket csak azokhoz adjuk hozzá, amelyek még nincsenek a térképben,
            // vagy ha a felhasználó új pontszáma nagyobb
            scores.forEach((username, score) -> {
                if (!existingScores.containsKey(username) || score > existingScores.get(username)) {
                    existingScores.put(username, score);
                }
            });

            // Elmentjük az eredményeket a JSON-be
            objectMapper.writeValue(new File(filePath), existingScores);
        } catch (IOException e) {
            LOGGER.error("Nem sikerült betölteni, kivétel: ", e); // kivétel dobás
        }
    }

    public Map<String, Integer> loadScoresFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ha a fájl nem létezik, akkor üres térképet adunk vissza
            if (!new File(filePath).exists()) {
                return new HashMap<>();
            }

            return objectMapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}