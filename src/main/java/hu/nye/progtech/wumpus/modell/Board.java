package hu.nye.progtech.wumpus.modell;

public class Board {
    private int size; //méret
    private char[][]board; //mátrix
    private int playerColumn; //Játékos hely
    private int playerRow; //Játékos hely
    private char playerDirection; //iranya

    public Board(int size, char[][] board, int playerColumn, int playerRow, char playerDirection) {
        this.size = size;
        this.board = board;
        this.playerColumn = playerColumn;
        this.playerRow = playerRow;
        this.playerDirection = playerDirection;
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

    public int getPlayerColumn() {
        return playerColumn;
    }

    public void setPlayerColumn(int playerColumn) {
        this.playerColumn = playerColumn;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    public char getPlayerDirection() {
        return playerDirection;
    }

    public void setPlayerDirection(char playerDirection) {
        this.playerDirection = playerDirection;
    }
}
