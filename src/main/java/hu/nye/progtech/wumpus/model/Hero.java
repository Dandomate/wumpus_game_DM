package hu.nye.progtech.wumpus.model;


public class Hero {
    private Position position;
    private Direction direction; // Nézési irány
    private int arrows;     // Nyílak száma

    private boolean gold;

    public Hero(int row, char column, Direction direction, int arrows) {
        this.position = new Position(row, column);
        this.direction = direction;
        this.arrows = arrows;
        gold=false;
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

    public Position getHeroPosition() {
        return position;
    }

    public void setHeroPosition(Position position) {
        this.position = position;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold() {
        this.gold = true;
    }
    public boolean hasArrows() {
        return arrows > 0;
    }
}
