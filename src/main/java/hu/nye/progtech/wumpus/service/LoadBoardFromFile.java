package hu.nye.progtech.wumpus.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.CellType;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;

public class LoadBoardFromFile {


    public static Board loadBoard(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] sizeAndHeroLine = reader.readLine().split(" ");

            validateLineLength(sizeAndHeroLine, 4);

            int size = Integer.parseInt(sizeAndHeroLine[0]);
            int heroRow = Integer.parseInt(sizeAndHeroLine[2]) - 1;
            char heroColumn = (char) (sizeAndHeroLine[1].charAt(0) - 'A'); // 'A' kivonása a megfelelő oszlopszámhoz
            char heroDirectionSymbol = sizeAndHeroLine[3].charAt(0);
            Direction heroDirection = Direction.fromSymbol(heroDirectionSymbol);

            validateSize(size);


            char[][] board = loadBoardData(reader, size);
            int heroArrows = countHeroArrows(board);
            placeHero(board, heroRow, heroColumn);


            Hero hero = new Hero(heroRow, heroColumn, heroDirection, heroArrows);
            Board gameBoard = new Board(size, board,hero);

            //gameBoard.setCell('E', 3, 'Y'); //proba
            //char cellValue = gameBoard.getCell('E', 3); //proba
            //System.out.println("A (D 6) cellában található érték: " + cellValue+"\n");

            return gameBoard;

        }
    }


    private static char[][] loadBoardData(BufferedReader reader, int size) throws IOException {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            if (row.length() != size) {
                throw new IllegalArgumentException("Nem megfelelő méretű a beolvasott fájlban a tábla.");
            }
            for (int j = 0; j < size; j++) {
                char cellChar = row.charAt(j);
                CellType cellType = CellType.fromSymbol(cellChar);
                if (cellType == null) {
                    throw new IllegalArgumentException("Ismeretlen karakter a táblán: " + cellChar);
                }
                board[i][j] = cellChar;
            }
        }
        return board;
    }



    private static int countHeroArrows(char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char cellChar : row) {
                CellType cellType = CellType.fromSymbol(cellChar);
                if (cellType == CellType.WUMPUS) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void placeHero(char[][] board, int heroRow, char heroColumn) {
        board[heroRow][heroColumn] = CellType.HERO.getSymbol();
    }

    private static void validateSize(int size) {
        if (size < 6 || size > 20) {
            throw new IllegalArgumentException("A tábla mérete nem felel meg a követelményeknek. Ellenőrizze a bemeneti fájlt.");
        }
    }

    private static void validateLineLength(String[] lineArray, int expectedLength) {
        if (lineArray.length != expectedLength) {
            throw new IllegalArgumentException("Hibás méretinformáció a fájlban.");
        }
    }


}
