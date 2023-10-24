package hu.nye.progtech.wumpus.modell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LoadBoardFromFile {
    public static char[][] loadMap(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rows = 0;
            int cols = 0;

            // Első sor beolvasása a méret információkért
            if ((line = reader.readLine()) != null) {
                String[] sizeInfo = line.split(" ");
                rows = Integer.parseInt(sizeInfo[0]);
                cols = Integer.parseInt(sizeInfo[0]);
            }

            char[][] map = new char[rows][cols];

            // A pálya beolvasása
            for (int i = 0; i < rows; i++) {
                if ((line = reader.readLine()) != null) {
                    char[] rowChars = line.toCharArray();
                    if (rowChars.length == cols) {
                        map[i] = rowChars;
                    } else {
                        throw new IOException("Hibás pálya méret.");
                    }
                } else {
                    throw new IOException("Hiba.");
                }
            }

            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
