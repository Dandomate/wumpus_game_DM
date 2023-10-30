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



}
