package hu.nye.progtech.wumpus.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {


    public static String databaseUrl = "jdbc:mysql://localhost:3306/wumpus_game?user=root&password=";
    Connection connection = DriverManager.getConnection(databaseUrl);

    public DatabaseConfig() throws SQLException {
    }

}