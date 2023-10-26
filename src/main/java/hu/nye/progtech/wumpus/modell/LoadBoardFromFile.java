package hu.nye.progtech.wumpus.modell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import hu.nye.progtech.wumpus.modell.Board;
public class LoadBoardFromFile {

    public static Board loadBoard(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Beolvaspm a méretet és a hős pozícióját
        String[] sizeAndHeroLine = reader.readLine().split(" ");

        int size = Integer.parseInt(sizeAndHeroLine[0]);
        int heroRow = Integer.parseInt(sizeAndHeroLine[2]) - 1;
        char heroColumn = (char) (sizeAndHeroLine[1].charAt(0) - 'A'); // 'A' kivonása a megfelelő oszlopszámhoz
        char heroDirection = sizeAndHeroLine[3].charAt(0);


        // Olvasd be a táblát
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // A Hero  és a boardpéldányositása , majd vissza addom a Board-ot
        Hero hero = new Hero(heroRow, heroColumn, heroDirection);
        Board gameBoard = new Board(size, board, hero);

        gameBoard.setCell('E', 3, 'Y'); //proba
        char cellValue = gameBoard.getCell('D', 6); //proba
        System.out.println("A (D 6) cellában található érték: " + cellValue+"\n");
        return gameBoard;
    }

}
