package hu.nye.progtech.wumpus.model;

public class Board {
    private  int size; //méret
    private char[][]board; //mátrix

    private Hero hero;

    public Board(int size, char[][] board,Hero hero) {
        this.size = size;
        this.board = board;
        this.hero = hero;
    }

    public int getSize() {
        return size;
    }


    public char[][] getBoard() {
        return board;
    }


    public Hero getHero() {
        return hero;
    }

/*
    public char getCell(char columnKey, int rowIndex) {
        // Az oszlopkulcsot és sorindexet átalakítjuk mátrix indexekké
        int columnIndex = columnKey - 'A';
        int matrixRowIndex = rowIndex - 1;

        if (isValidCell(matrixRowIndex, columnIndex)) {
            return board[matrixRowIndex][columnIndex];
        } else {
            return ' '; // Alapértelmezett érték, ha a cella érvénytelen
        }
    }
    private boolean isValidCell(int rowIndex, int columnIndex) {
        // Ellenőrizzük, hogy a megadott sorindex és oszlopkulcs érvényes cellára mutat-e
        return rowIndex >= 0 && rowIndex < size && columnIndex >= 0 && columnIndex < size;
    }
    public void setCell(char column, int row, char value) {  //beállítom az értéket az oszlopoknak és a soroknak -'A' a 0 miatt kel és a -1 is
        int columnIndex = column - 'A';
        int rowIndex = row-1;

        if (isValidCell(columnIndex, rowIndex)) {
            board[rowIndex][columnIndex] = value;
        }
    }

 */

}
