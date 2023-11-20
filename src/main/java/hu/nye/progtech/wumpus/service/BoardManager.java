package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.*;
import hu.nye.progtech.wumpus.service.LoadBoardFromFile;

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