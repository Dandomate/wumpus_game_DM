package hu.nye.progtech.wumpus.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseManager {
    private final String DATABASE_URL;

    public DatabaseManager() {
        this.DATABASE_URL = DatabaseConfig.DATABASE_URL;
    }


    public  void saveGameState(String username, String gameState) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            // Ellenőrizzük, hogy az adott felhasználónév már szerepel-e az adatbázisban
            boolean userExists = checkUserExists(connection, username);

            if (userExists) {
                // Ha már létezik, akkor frissítjük az állapotot
                updateGameState(connection, username, gameState);
            } else {
                // Ha még nem létezik, akkor létrehozzuk az új állapotot
                insertGameState(connection, username, gameState);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private  boolean checkUserExists(Connection connection, String username) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(*) FROM game_states WHERE username = ?"
        )) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        }
    }

    private  void updateGameState(Connection connection, String username, String gameState) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE game_states SET game_state = ? WHERE username = ?"
        )) {
            statement.setString(1, gameState);
            statement.setString(2, username);
            statement.executeUpdate();
        }
    }

    private  void insertGameState(Connection connection, String username, String gameState) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO game_states (username, game_state) VALUES (?, ?)"
        )) {
            statement.setString(1, username);
            statement.setString(2, gameState);
            statement.executeUpdate();
        }
    }

}