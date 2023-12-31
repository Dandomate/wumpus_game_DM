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

            int size = Integer.parseInt(sizeAndHeroLine[0]); //parsolunk int-e
            int heroRow = Integer.parseInt(sizeAndHeroLine[2]) - 1; // -1 kivonása a megfelelő oszlopszámhoz
            char heroColumn = sizeAndHeroLine[1].charAt(0);
            char heroDirectionSymbol = sizeAndHeroLine[3].charAt(0);

            final Direction heroDirection = Direction.fromSymbol(heroDirectionSymbol);

            validateSize(size);

            char[][] board = loadBoardData(reader, size);
            final int heroArrows = countHeroArrows(board);
            placeHero(board, heroRow, heroColumn);

            int wumpusCount = countWumpus(board);
            int goldCount = countGold(board);
            int heroCount = countHero(board);

            validateWumpusCount(size, wumpusCount); //validáljuk a wumpus számát
            validateGoldCount(goldCount); //validáljuk az arany számát
            validateHeroCount(heroCount); //validáljuk a hős számát

            Hero hero = new Hero(heroRow, heroColumn, heroDirection, heroArrows);
            Board gameBoard = new Board(size, board, hero);

      
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
        int count = 0; //számláló bevezetésével meghatározom a hős nyiainak számát
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

    private static int countWumpus(char[][] board) {
        int count = 0; //számláló bevezetésével meghatározom a wumpusok számát
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

    private static int countGold(char[][] board) {
        int count = 0; //számláló bevezetésével meghatározom azz aranyak számát
        for (char[] row : board) {
            for (char cellChar : row) {
                CellType cellType = CellType.fromSymbol(cellChar);
                if (cellType == CellType.GOLD) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countHero(char[][] board) {
        int count = 0; //számláló bevezetésével meghatározom a hősök számát
        for (char[] row : board) {
            for (char cellChar : row) {
                CellType cellType = CellType.fromSymbol(cellChar);
                if (cellType == CellType.HERO) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void placeHero(char[][] board, int heroRow, char heroColumn) {
        if (isValidPosition(heroRow, heroColumn, board)) {
            board[heroRow][heroColumn - 'A'] = CellType.START.getSymbol();
        }
    }

    private static boolean isValidPosition(int row, char column, char[][] board) {
        if (row < 0 || row >= board.length || !Character.isLetter(column)) {
            System.out.println("Hibás pozíció: (" + row + ", " + column + ")");
            return false;
        }

        column = Character.toUpperCase(column);
        if (column < 'A' || column >= 'A' + board[0].length) {
            System.out.println("Hős oszlopa a megfelelő tartományon kívül van.");
            return false;
        }

        return true;
    }

    private static void validateSize(int size) { //Bemenet validálása a mérethez megfelelően.
        if (size < 6 || size > 20) {
            throw new IllegalArgumentException("A tábla mérete nem felel meg a követelményeknek. Ellenőrizze a bemeneti fájlt.");
        }
    }

    private static void validateLineLength(String[] lineArray, int expectedLength) { //méret validálás sorok...
        if (lineArray.length != expectedLength) {
            throw new IllegalArgumentException("Hibás méretinformáció a fájlban.");
        }
    }

    private static void validateWumpusCount(int boardSize, int wumpusCount) {  //Wumpus számának validálása
        if (boardSize <= 8) {
            if (wumpusCount > 1) {
                throw new IllegalArgumentException("Maximum 1 Wumpus lehet a pályán, ha a mérete kisebb vagy egyenlő 8-al.");
            }
        } else if (boardSize <= 14) {
            if (wumpusCount > 2) {
                throw new IllegalArgumentException("Maximum 2 Wumpus lehet a pályán, ha a mérete 9 és 14 között van.");
            }
        } else {
            if (wumpusCount > 3) {
                throw new IllegalArgumentException("Maximum 3 Wumpus lehet a pályán, ha a mérete nagyobb, mint 14.");
            }
        }
    }

    private static void validateGoldCount(int goldCount) { //arany számának validálása a pályan.
        if (goldCount > 1) {
            throw new IllegalArgumentException("Több mint egy arany található a beolvasott fájlban.");
        }
    }

    private static void validateHeroCount(int heroCount) { //hős számának validálása a pályán
        if (heroCount > 1) {
            throw new IllegalArgumentException("A pálya több, mint 1 hőst tartalmaz a beolvasott fájlban.");
        }
    }

}
