package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.CellType;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoadBoardFromDatabase {




    public static Board loadBoardDatabase(String username) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wumpus_game?user=root&password=")) {
            String selectQuery = "SELECT * FROM game_states WHERE username = ? ORDER BY username DESC LIMIT 1";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Elérjük a táblát reprezentáló szöveges adatot az adatbázisból
                        String boardText = resultSet.getString("game_state");

                        // Szóközök mentén feldaraboljuk az adatokat
                        String[] boardData = boardText.split(" ");

                        validateLineLength(boardData, 6);
                        // Az adatokat megfelelő változókba helyezzük
                        int size = Integer.parseInt(boardData[0]);
                        int heroRow = Integer.parseInt(boardData[2]) - 1;
                        char heroColumn = boardData[1].charAt(0);
                        Direction heroDirection = Direction.fromSymbol(boardData[3].charAt(0));
                        int heroArrows = Integer.parseInt(boardData[4]);
                        String fifthElement = boardData.length > 5 ? boardData[5].trim() : "0";
                        char firstChar = '0';

                        if (!fifthElement.isEmpty()) {
                            firstChar = fifthElement.charAt(0);
                        }

                        boolean hasGold;
                        if (firstChar=='1'){
                            hasGold =true;
                        }else {
                            hasGold=false;
                        }


                        // Elérjük a tábla mátrixot reprezentáló részt az adatbázisból
                        char[][] board = loadBoardDataFromString(boardText.substring(boardText.indexOf("\n") + 1), size);


                        // További ellenőrzések és validációk...

                        // Hős létrehozása és visszaadása a táblával együtt
                        Hero hero = new Hero(heroRow, heroColumn, heroDirection, heroArrows,hasGold);
                        Board gameBoard = new Board(size, board, hero);

                        return gameBoard;
                    } else {
                        System.out.println("Nem található elmentett játékállapot a felhasználó számára.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hiba történt az adatbázishoz való kapcsolódás során.");
        }

        return null;
    }
    private static char[][] loadBoardDataFromString(String boardData, int size) {
        char[][] board = new char[size][size];

        // Szóközök és vesszők eltávolítása a boardData-ból
        boardData = boardData.replaceAll(" ", "").replaceAll(",", "").replaceAll("\n", "");

        // Az egyes sorokat az első 10 karakterből állítjuk elő, a második sortól kezdve
        for (int i = 0; i < size; i++) {
            String row = boardData.substring(i * size, (i + 1) * size);
            board[i] = row.toCharArray();
        }

        return board;
    }

    private static void validateLineLength(String[] lineArray, int expectedLength) {
        if (lineArray.length != expectedLength) {
            throw new IllegalArgumentException("Hibás méretinformáció a fájlban.");
        }
    }
}

