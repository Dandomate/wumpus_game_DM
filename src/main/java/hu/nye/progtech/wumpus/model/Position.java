package hu.nye.progtech.wumpus.model;

public class Position {
    private int row;
    private char column;

    public Position(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public Position() {
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void moveUp() {
        row--;
    }

    public void moveDown() {
        row++;
    }

    public void moveLeft() {
        column--;
    }

    public void moveRight() {
        column++;
    }

    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public Position copy() {
        return new Position(row, column);
    }

    public void moveInDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                row--;
                break;
            case WEST:
                column--;
                break;
            case SOUTH:
                row++;
                break;
            case EAST:
                column++;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
