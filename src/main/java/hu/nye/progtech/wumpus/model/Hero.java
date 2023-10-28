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
    public Hero(int row, char column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;

    }

    public Hero() {

    }

    public int getHeroRow() {
        return row;
    }

    public void setHeroRow(int row) {
        this.row = row;
    }

    public int getHeroColumn() {
        return column;
    }

    public void setHeroColumn(char column) {
        this.column = column;
    }


    public int getHeroArrows() {
        return arrows;
    }

    public void setHeroArrows(int arrows) {
        this.arrows = arrows;
    }

    public Direction getHeroDirection() {
        return direction;
    }

    public void setHeroDirection(Direction direction) {
        this.direction = direction;
    }

}
