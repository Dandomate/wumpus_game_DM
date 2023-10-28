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

    public Board() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    //proba
/*
    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    // Az első és utolsó sorokban, valamint az első és utolsó oszlopokban 'W' karakter
                    boardString.append("W");
                } else if (hero.getHeroRow() == i && hero.getHeroColumn() == j) {
                    // Ha ez a pozíció a hősé, akkor a hőst írjuk ki
                    boardString.append("H");
                } else {
                    boardString.append(board[i][j]);
                }
                boardString.append(" ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }


 */
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
/*
    public void updateHeroDirection(Hero hero) {
        int heroRow = hero.getHeroRow();
        int heroColumn = hero.getHeroColumn() - 'A'; // Átalakítjuk a karaktert oszlopszámra
        char newDirectionSymbol = hero.getHeroDirection().getSymbol();
        setCell((char) ('A' + heroColumn), heroRow + 1, newDirectionSymbol); //
    }
*/


}
