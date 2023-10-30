package hu.nye.progtech.wumpus.model;


public class Hero {
    private  int row;        // Sor pozíció
    private char column;     // Oszlop pozíció //Át kell irni majd char ra csak proba miatt int
    private Direction direction; // Nézési irány
    private int arrows;     // Nyílak száma

    public Hero(int row, char column, Direction direction,int arrows) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.arrows=arrows;

    }

    public int getHeroArrows() {
        return arrows;
    }
    public Direction getHeroDirection() {
        return direction;
    }

    public void setHeroDirection(Direction direction) {
        this.direction = direction;
    }

}
