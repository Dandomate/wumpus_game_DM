package hu.nye.progtech.wumpus.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {


    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/wumpus_game?user=root&password=";
    Connection connection = DriverManager.getConnection(DATABASE_URL);

    public DatabaseConfig() throws SQLException {
    }

}