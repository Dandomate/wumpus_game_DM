package hu.nye.progtech.wumpus.model;



public class Board {
    private int size;
    private char[][] board;
    private char[][] originalBoard; // Új mező az eredeti állapot tárolására
    private Hero hero;

    public Board(int size, char[][] board, Hero hero) {
        this.size = size;
        this.board = board;
        this.hero = hero;
        this.originalBoard = new char[size][size]; // Inicializáld az eredeti mezőt
        copyBoard(board, originalBoard); // Másold át az eredeti állapotot
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

    private void copyBoard(char[][] source, char[][] destination) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }
    public void updateBoard(Position newPosition) {
        // Visszaállítjuk az eredeti mező értékét a kiindulóponti pozíciónál
        Position oldPosition = hero.getHeroPosition();
        int oldRow = oldPosition.getRow();
        int oldCol = oldPosition.getColumn() - 'A';

        // Az előző pozíció üres lesz

        if (getCellType(oldPosition) != CellType.START) {
            board[oldRow][oldCol] = CellType.EMPTY.getSymbol();
        }


        // Frissítjük a hős új pozícióját
        int newRow = newPosition.getRow();
        int newCol = newPosition.getColumn() - 'A';

        // Az új pozícióban lévő elem típusától függően frissítjük a táblát
        CellType newCellType = getCellType(newPosition);
        if (newCellType == CellType.GOLD) {
            board[newRow][newCol] = CellType.EMPTY.getSymbol();
        } else {
            board[newRow][newCol] = newCellType.getSymbol();
        }

        // Frissítjük a hős pozícióját
        hero.setHeroPosition(newPosition);
    }


    public CellType getCellType(Position position) {
        int row = position.getRow();
        char col = position.getColumn();

        // Ellenőrizzük, hogy a pozíció a pálya területén belül van-e
        if (row >= 0 && row < size && col >= 'A' && col < 'A' + size) {
            return CellType.fromSymbol(board[row][col - 'A']);
        } else {
            // Ha a pozíció nem a pálya területén belül van, akkor visszaadjuk a FAL értéket
            return CellType.WALL;
        }
    }


}