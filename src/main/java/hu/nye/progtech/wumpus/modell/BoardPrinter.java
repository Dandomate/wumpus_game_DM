package hu.nye.progtech.wumpus.modell;

public class BoardPrinter {
    public static void printBoard(Board board) {
        int size = board.getSize();
        char[][] boardArray = board.getBoard();
        Hero hero = board.getHero();

        // Oszlopkulcsok hozzáadása az első sorhoz
        System.out.print("  ");
        for (char column = 'A'; column < 'A' + size; column++) {
            System.out.print(column + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            // Sorindex hozzáadása a bal oldalon
            System.out.print((row + 1) + " ");

            for (int column = 0; column < size; column++) {
                if (hero.getHeroRow() == row && hero.getHeroColumn() == column) {
                    // Ha ez a pozíció a hősé, akkor a hőst írjuk ki
                    System.out.print("H ");
                } else {
                    System.out.print(boardArray[row][column] + " ");
                }
            }
            System.out.println();
        }
    }

}