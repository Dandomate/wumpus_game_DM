package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.Hero;

public class BoardPrinter {
    public static void printLoadBoard(Board board) {
        int size = board.getSize();
        char[][] boardArray = board.getBoard();
        Hero hero = board.getHero();



        printColumnKeys(size);

        for (int row = 0; row < size; row++) {
            printRowKeys(row);// Sorindex hozzáadása a bal oldalon 1,2,3,4....
            for (int column = 0; column < size; column++) {
                    System.out.print(boardArray[row][column] + " ");
            }
            System.out.println();
        }
        printHeroInfo(hero);
    }

    private static void printHeroInfo(Hero hero) { //a hős adatai
        System.out.print("\n");
        System.out.println("A hős nyilainak száma: " + hero.getHeroArrows());
        System.out.println("A hős pozíciója: " + hero.getHeroDirection());
        System.out.print("\n");
    }

    private static void printColumnKeys(int size) { // Oszlopindex hozzáadása a bal oldalon 1,2,3,4....
        System.out.print("  ");
        for (char column = 'A'; column < 'A' + size; column++) {
            System.out.print(column + " ");
        }
        System.out.println();
    }

    private static void printRowKeys(int row) {
        System.out.print((row + 1) + " ");
    }


}