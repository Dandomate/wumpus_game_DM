package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;
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

    public Board getGameBoard() {
        return gameBoard;
    }
}