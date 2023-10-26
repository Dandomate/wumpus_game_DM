package hu.nye.progtech.wumpus.modell;

import java.io.IOException;

public class Game {

public static void playGame(String filePath) {
    try {
        Board board = LoadBoardFromFile.loadBoard(filePath);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoard(board);
        System.out.println("\nPálya sikeresen betöltve.");
    } catch (IOException e) {
        System.out.println("\nHiba történt a pálya betöltésekor.");
        e.printStackTrace();
    }
}}