package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.Hero;
import hu.nye.progtech.wumpus.model.Position;

public class BoardPrinter {

    public void printLoadBoard(Board board) {
        int size = board.getSize();
        char[][] boardArray = board.getBoard();
        Hero hero = board.getHero();

        printColumnKeys(size);

        for (int row = 0; row < size; row++) {
            printRowNumber(row + 1); // Sorindexet 1-től indítjuk
            for (int column = 0; column < size; column++) {
                char symbol;
                if (hero.getHeroPosition().getRow() == row && hero.getHeroPosition().getColumn() == 'A' + column) {
                    // Ha a mező a hőst reprezentálja, akkor "H"-t írunk ki
                    symbol = 'H';
                } else {
                    // Egyébként a szokásos módon írjuk ki a mezőket
                    symbol = boardArray[row][column];
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        printHeroInfo(hero);
    }

    private  void printRowNumber(int row) {
        System.out.printf("%-2d", row);
    }

    private  void printHeroInfo(Hero hero) { //a hős adatai
        System.out.print("\n");
        System.out.println("A hős nyilainak száma: " + hero.getHeroArrows());
        System.out.println("A hős iránya: " + hero.getHeroDirection());
        System.out.println("A hős pozíciója: " + formatHeroPosition(hero.getHeroPosition()));
        if (hero.isGold()) {
            System.out.println("Nálad van az arany");
        } else {
            System.out.println("Nincs nálad arany");
        }
        System.out.print("\n");
    }

    private  String formatHeroPosition(Position position) {
        // Ahol 1-től kezdődik a számozás és A-tól kezdődnek az oszlopok
        int formattedRow = position.getRow() + 1;
        char formattedColumn = position.getColumn();
        return "(" + formattedRow + ", " + formattedColumn + ")";
    }

    private  void printColumnKeys(int size) { // Oszlopindex hozzáadása a b c d
        System.out.print("  ");
        for (char column = 'A'; column < 'A' + size; column++) {
            System.out.print(column + " ");
        }
        System.out.println();
    }
}