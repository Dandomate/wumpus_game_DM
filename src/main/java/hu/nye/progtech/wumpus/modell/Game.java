package hu.nye.progtech.wumpus.modell;

import hu.nye.progtech.wumpus.modell.BoardPrinter;
import hu.nye.progtech.wumpus.modell.LoadBoardFromFile;
public class Game {
    public static void playGame(String filePath) {
        char[][] loadedBoard = LoadBoardFromFile.loadMap(filePath);

        if (loadedBoard != null) {
            System.out.println("Pálya sikeresen betöltve:");
            BoardPrinter.printBoard(loadedBoard);
        } else {
            System.out.println("Hiba történt a pálya betöltésekor.");
        }
    }
}
