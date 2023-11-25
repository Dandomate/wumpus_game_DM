package hu.nye.progtech.wumpus.controller;

import hu.nye.progtech.wumpus.model.*;
import hu.nye.progtech.wumpus.service.GamePlay;
import hu.nye.progtech.wumpus.service.Menu;
import hu.nye.progtech.wumpus.service.User;


public class HeroController {

    private Direction heroDirection;
    private Position heroPosition;
    private Board board;
    private  User user;
    Menu menu= new Menu();





    private int stepCount; // Lépésszámláló

    public HeroController(User user) {
        this.user = user;

    }
    public void setInitialPosition(Position initialPosition, Direction initialDirection) {
        this.heroPosition = initialPosition;
        this.heroDirection = initialDirection;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void handleInput(String input) {
        int oldRow = heroPosition.getRow();
        char oldColumn = heroPosition.getColumn();

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
            case "U":
                heroDirection = Direction.NORTH;
                heroPosition.moveUp();
                break;
            case "H":
                heroDirection = Direction.WEST;
                heroPosition.moveLeft();
                break;
            case "J":
                heroDirection = Direction.SOUTH;
                heroPosition.moveDown();
                break;
            case "K":
                heroDirection = Direction.EAST;
                heroPosition.moveRight();
                break;
            case "G":
                handleArrowShot();
                //ez lesz a lövés.
                break;
            default:
                System.out.println("Érvénytelen irány.");
                return;
        }

        CellType cellType = board.getCellType(heroPosition);
        handleCellType(cellType);

        // Ellenőrizzük, hogy a mozgás után a célmező üres-e, és csak ebben az esetben frissítjük a táblát
        if (cellType == CellType.EMPTY) {
            stepCount++;
            board.updateBoard(heroPosition);

        }else if (cellType == CellType.GOLD){
            stepCount++;
            board.updateBoard(heroPosition);
           // board.setCellType(heroPosition,CellType.EMPTY);
            System.out.println(cellType.getSymbol());
        }
        else if (cellType == CellType.START && board.getHero().isGold()==true){
            stepCount++;
            board.updateBoard(heroPosition);
            user.incrementScore();
            System.out.println("Gratulálunk nyertél");
            System.out.println("Ennyi lépésből nyertél: "+getStepCount());//
            System.out.println(user.getUserWithScore());

            //JSON
            Scoreboard scoreboard = new Scoreboard(user);
            scoreboard.displayUserScore();
            scoreboard.incrementScore();
            scoreboard.saveScoresToFile("C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.json");

            // Példa a pontszámok betöltésére
            scoreboard.loadScoresFromFile("C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.json");

            // Kiíratás a konzolra


            menu.displayMainMenu();
        } else if (cellType == CellType.START) {
            stepCount++;
            board.updateBoard(heroPosition);
        } else {
            // Ha falba vagy árokba léptünk, visszaállítjuk a régi pozíciót
            heroPosition.setRow(oldRow);
            heroPosition.setColumn(oldColumn);
        }
    }

    private void handleCellType(CellType cellType) {
        switch (cellType) {
            case WALL:
                System.out.println("Fal van, nem tudsz arra lépni!");
                break;
            case PITFALL:
                System.out.println("Árokba léptél!");
                if (board.getHero().getHeroArrows() > 0) {
                    board.getHero().setArrows(board.getHero().getHeroArrows() - 1);
                    System.out.println("Nyilak száma: " + board.getHero().getHeroArrows());
                } else {
                    System.out.println("Nincsenek több nyilaid!");
                }
                break;
            case WUMPUS:
                System.out.println("GAME OVER - Megölt a Wumpus!");
                menu.displayMainMenu();
                break;
            case GOLD:
                board.getHero().setGold();
                System.out.println("Megtaláltad a kincset!");
                break;
            default:
                // Egyéb esetek (üres cella)
                break;
        }
    }


    public Direction getHeroDirection() {
        return heroDirection;
    }

    public Position getHeroPosition() {
        return heroPosition;
    }

    public int getStepCount() {
        return stepCount;
    }

    private void handleArrowShot() {
        if (board.getHero().hasArrows()) {
            board.getHero().setArrows(board.getHero().getHeroArrows() - 1);
            Position arrowPosition = heroPosition.copy();

            while (isValidPosition(arrowPosition.getRow(), arrowPosition.getColumn(), board.getSize())) {
                char cellValue = board.getCellType(arrowPosition).getSymbol();

                if (CellType.WUMPUS.getSymbol() == cellValue) {
                    removeWumpus(arrowPosition);
                    System.out.println("Talált!");
                    return;
                } else if (CellType.WALL.getSymbol() == cellValue) {
                    System.out.println("A nyíl a falnak ütközött.");
                    return;
                }

                arrowPosition.moveInDirection(heroDirection);
            }
        } else {
            System.out.println("Nincs több nyilad!");
        }
    }
    private boolean isValidPosition(int row, char column, int boardSize) {
        return row >= 0 && row < boardSize && column >= 'A' && column < 'A' + boardSize;
    }

    private void removeWumpus(Position arrowPosition) {
        int row = arrowPosition.getRow();
        char column = arrowPosition.getColumn();

        // Ellenőrizzük, hogy a pozíció a pálya területén belül van-e
        if (isValidPosition(row, column, board.getSize())) {
            // Ellenőrizzük, hogy a pozícióban tényleg Wumpus van-e
            if (board.getCellType(arrowPosition) == CellType.WUMPUS) {
                // Eltávolítjuk a Wumpust a pályáról
                board.updateBoard(arrowPosition);
            }
        }
    }


}


