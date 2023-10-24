package hu.nye.progtech.wumpus.modell;


public class Hero {
    private int row;        // Sor pozíció
    private int column;     // Oszlop pozíció
    private char direction; // Nézési irány (pl. 'E' - észak, 'S' - dél, 'W' - nyugat, 'N' - kelet)
    private int arrows;     // Nyílak száma

    public Hero(int row, int column, char direction, int arrows) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.arrows = arrows;
    }


    public void move() {
        // Hős mozgatása a jelenlegi nézési irányba
    }

    public void turnRight() {
        // Nézési irány jobbra fordítása
    }

    public void turnLeft() {
        // Nézési irány balra fordítása
    }

    public void shootArrow() {
        // Nyíl kilövése
    }

    public void pickUpGold() {
        // Arany felvétele
    }


}
