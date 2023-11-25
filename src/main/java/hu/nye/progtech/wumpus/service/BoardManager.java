package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.*;


import java.io.IOException;

public class BoardManager {
    private Board gameBoard;

    public void loadBoard(String filePath) { //betöltés fájlbol
        try {
            gameBoard = LoadBoardFromFile.loadBoard(filePath);
            System.out.println("Pálya betöltve.");
        } catch (IOException e) {
            System.out.println("Hiba történt a pálya betöltésekor: nem megfelelő elérés.");
        }
    }
    public void loadBoardDatabase(String username) { //betöltés fájlbol
        gameBoard = LoadBoardFromDatabase.loadBoardDatabase(username);
        System.out.println("Pálya betöltve.");
    }

    public void printBoard() {  //Kiiratás
        if (gameBoard != null) {
            printBoard(gameBoard);
        } else {
            System.out.println("A pálya nincs betöltve.");
        }
    }

    private void printBoard(Board board) {
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printLoadBoard(board);
    }

    public void updateBoardHeroDirection(Direction newDirection) {

        // Hős irányának beállítása az új irányra
        Hero hero = gameBoard.getHero();
        hero.setHeroDirection(newDirection);
    }

    public void updateBoardHeroPosition(Position newPosition) {
        // Hős irányának beállítása az új irányra
        Hero hero = gameBoard.getHero();
        hero.setHeroPosition(newPosition);

        // Frissítse a tábla celláját a hős új pozíciójával
        char[][] board = gameBoard.getBoard();
        int row = newPosition.getRow();
        char col = newPosition.getColumn();

        // Ellenőrizd, hogy az új pozíció a megfelelő tartományban van-e
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
            board[row][col] = CellType.HERO.getSymbol();
        }
    }
    public String getGameState() {
        if (gameBoard == null) {
            return "Game state not available.";
        }

        // Játékállapotba hozzáadja a pálya és a hős adatait
        StringBuilder gameState = new StringBuilder();

        // Pálya mérete
        gameState.append(gameBoard.getSize()).append(" ");

        // Hős adatai
        Hero hero = gameBoard.getHero();
        gameState.append(hero.getHeroPosition().getColumn()).append(" ");
        gameState.append(hero.getHeroPosition().getRow() + 1).append(" "); // Oszlop indexelése 1-től kezdődik
        gameState.append(hero.getHeroDirection().getSymbol()).append(" ");
        gameState.append(hero.getHeroArrows()).append(" ");
        gameState.append(hero.isGold() ? "1" : "0").append("\n");

        // Pálya adatai
        char[][] board = gameBoard.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char cell = board[i][j];
                gameState.append(cell);
            }
            gameState.append("\n");
        }

        return gameState.toString();
    }
    public Board getGameBoard() {
        return gameBoard;
    }

    public Position getHeroInitialPosition() {
        return gameBoard.getHero().getHeroPosition();
    }

    public Direction getHeroInitialDirection() {
        return gameBoard.getHero().getHeroDirection();
    }
}