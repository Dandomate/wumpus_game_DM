package hu.nye.progtech.wumpus.model;


import hu.nye.progtech.wumpus.service.BoardUpdater;

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
        BoardUpdater.copyBoard(size, board, originalBoard); // Másold át az eredeti állapotot
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
    public void updateBoard(Position newPosition) {
        BoardUpdater.updateBoard(this, newPosition);
    }

    public CellType getCellType(Position position) {
        return BoardUpdater.getCellType(this, position);
    }


}