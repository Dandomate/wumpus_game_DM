package hu.nye.progtech.wumpus.model;

import hu.nye.progtech.wumpus.service.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Scoreboard {
    private Map<String, Integer> scores;
    private User user;

    public Scoreboard(User user) {
        this.user = user;
        this.scores = new HashMap<>();
    }

    public void incrementScore() {
        scores.put(user.getUsername(), user.getScore());
    }
    public int getScore() {
        return user.getScore();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void displayUserScore() {
        System.out.println("Felhasználó: " + user.getUsername() + ", pontszám: " + user.getScore());
    }

    public void saveScoresToFile(String filePath) {
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
            e.printStackTrace();
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
    public Map<String, Integer> getScores() {
        return scores;
    }
}