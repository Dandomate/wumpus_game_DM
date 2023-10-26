package hu.nye.progtech.wumpus.modell;


public class Hero {
    private int row;        // Sor pozíció
    private char column;     // Oszlop pozíció //Át kell irni majd char ra csak proba miatt int
    private char direction; // Nézési irány (pl. 'E' - észak, 'S' - dél, 'W' - nyugat, 'N' - kelet)
    private int arrows;     // Nyílak száma

    public Hero(int row, char column, char direction,int arrows) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.arrows=arrows;

    }
    public Hero(int row, char column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;

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

    public char getHeroDirection() {
        return direction;
    }

    public void setHeroDirection(char direction) {
        this.direction = direction;
    }

    public int getHeroArrows() {
        return arrows;
    }

    public void setHeroArrows(int arrows) {
        this.arrows = arrows;
    }


    //proba
    @Override
    public String toString() {
        return "Hero [Row: " + row + ", Column: " + column + ", Direction: " + direction + "]";
    }
}
