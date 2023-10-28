package hu.nye.progtech.wumpus.controller;

import hu.nye.progtech.wumpus.model.Direction;

public class HeroController {
    private Direction heroDirection;

    public void handleInput(String input) {
        switch (input.toUpperCase()) {
            case "W":
                heroDirection = Direction.NORTH;
                break;
            case "A":
                heroDirection = Direction.WEST;
                break;
            case "S":
                heroDirection = Direction.SOUTH;
                break;
            case "D":
                heroDirection = Direction.EAST;
                break;
            default:
                System.out.println("Érvénytelen irány.");
                break;
        }
    }

    public Direction getHeroDirection() {
        return heroDirection;
    }
}