package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.CellType;
import hu.nye.progtech.wumpus.model.Position;

public class BoardUpdater {

    public static void copyBoard(int size, char[][] source, char[][] destination) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }

    public static void updateBoard(Board board, Position newPosition) {
        char[][] boardArray = board.getBoard();

        Position oldPosition = board.getHero().getHeroPosition();
        int oldRow = oldPosition.getRow();
        int oldCol = oldPosition.getColumn() - 'A';

        if (getCellType(board, oldPosition) != CellType.START) {
            boardArray[oldRow][oldCol] = CellType.EMPTY.getSymbol();
        }

        int newRow = newPosition.getRow();
        int newCol = newPosition.getColumn() - 'A';

        CellType newCellType = getCellType(board, newPosition);
        if (newCellType == CellType.GOLD) {
            boardArray[newRow][newCol] = CellType.EMPTY.getSymbol();
        } else {
            boardArray[newRow][newCol] = newCellType.getSymbol();
        }

        board.getHero().setHeroPosition(newPosition);
    }

    public static CellType getCellType(Board board, Position position) {
        int row = position.getRow();
        char col = position.getColumn();

        if (row >= 0 && row < board.getSize() && col >= 'A' && col < 'A' + board.getSize()) {
            return CellType.fromSymbol(board.getBoard()[row][col - 'A']);
        } else {
            return CellType.WALL;
        }
    }
}