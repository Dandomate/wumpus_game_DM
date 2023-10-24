package hu.nye.progtech.wumpus.modell;

public class BoardPrinter {
        public static void printBoard(char[][] map) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    char cell = map[i][j];
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
}