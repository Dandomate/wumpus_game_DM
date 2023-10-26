package hu.nye.progtech.wumpus.modell;

public class BoardPrinter {
    public static void printBoard(Board board) {
        int size = board.getSize();
        char[][] boardArray = board.getBoard();
        Hero hero = board.getHero();

        System.out.println("A hős nyilainak száma: "+hero.getHeroArrows());
        System.out.println("A hős pozíciója: "+hero.getHeroDirection());
        System.out.print("\n");

        System.out.print("  ");
        for (char column = 'A'; column < 'A' + size; column++) {// Oszlopkulcsok hozzáadása az első sorhoz a,b,c,d
            System.out.print(column + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print((row + 1) + " ");// Sorindex hozzáadása a bal oldalon 1,2,3,4....
            for (int column = 0; column < size; column++) {
                    System.out.print(boardArray[row][column] + " ");
            }
            System.out.println();
        }
    }

}