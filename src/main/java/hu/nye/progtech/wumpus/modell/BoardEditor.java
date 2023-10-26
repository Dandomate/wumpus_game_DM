/*
package hu.nye.progtech.wumpus.modell;

import java.util.Scanner;

public class BoardEditor {
    private Board board;

    public BoardEditor(Board board) {
        this.board = board;
    }

    public void setBoardSizeFromInput() {
        Scanner scanner = new Scanner(System.in);

        int size = 0;

        // Addig próbáljuk bekérni a méretet, amíg megfelelő értéket nem kapunk
        while (size < 6 || size > 20) {
            System.out.print("Kérem adja meg a pálya méretét (6-20): ");

            // Ellenőrizzük, hogy az input egy egész szám-e
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size <= 6 || size >= 20) {
                    System.out.println("A pálya mérete 6 és 20 között kell legyen.");
                }
            } else {
                System.out.println("Érvénytelen bemenet. Kérem adjon meg egy érvényes egész számot.");
                scanner.next(); // Fogyasszuk el az érvénytelen inputot
            }
        }

        // Most, amikor megvan a pálya mérete, inicializáld újra a pályát
        char[][] newBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard[i][j] = ' ';
            }
        }
        board.setSize(size);
        board.setBoard(newBoard);
    }

    private char[][] createEmptyBoard(int size) {
        char[][] newBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard[i][j] = ' ';
            }
        }
        return newBoard;
    }
    public void addWall(int row, int col) {
        // Fal hozzáadása a megadott pozícióhoz
        board.getBoard()[row][col] = 'W';
    }

    public void addPit(int row, int col) {
        // Árok hozzáadása a megadott pozícióhoz
        board.getBoard()[row][col] = 'P';
    }

    public void addWumpus(int row, int col) {
        // Wumpus hozzáadása a megadott pozícióhoz
        board.getBoard()[row][col] = 'U';
    }

    public void addHero(int row, int col, char direction) {
        // Hős hozzáadása a megadott pozícióhoz és irányhoz
        board.getBoard()[row][col] = 'H';
        board.setPlayerColumn(col);
        board.setPlayerRow(row);
        board.setPlayerDirection(direction);
    }

    public void addGold(int row, int col) {
        // Arany hozzáadása a megadott pozícióhoz
        board.getBoard()[row][col] = 'G';
    }

    public void removeElement(int row, int col) {
        // Elem eltávolítása a megadott pozícióról (pl. fal, árok, stb.)
        board.getBoard()[row][col] = ' ';
    }

    public Board getEditedBoard() {
        // Visszaadja a szerkesztett játéktáblát
        return board;
    }
}

 */