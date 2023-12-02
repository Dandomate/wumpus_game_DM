package hu.nye.progtech.wumpus.model;

import java.util.HashMap;
import java.util.Map;

import hu.nye.progtech.wumpus.service.ScoreManager;
import hu.nye.progtech.wumpus.service.User;

public class Scoreboard {

    private Map<String, Integer> scores;
    private User user;
    private ScoreManager scoreManager;

    public Scoreboard(User user) {
        this.user = user;
        this.scores = new HashMap<>();
        this.scoreManager = new ScoreManager();
    }

    public void incrementScore() {
        scoreManager.incrementScore(user, scores);
    }

    public void displayUserScore() {
        scoreManager.displayUserScore(user);
    }

    public void saveScoresToFile(String filePath) {
        scoreManager.saveScoresToFile(filePath, scores);
    }

    public Map<String, Integer> loadScoresFromFile(String filePath) {
        return scoreManager.loadScoresFromFile(filePath);
    }

    public Map<String, Integer> getScores() {
        return scores;
    }
}