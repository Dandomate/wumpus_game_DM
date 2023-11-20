package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.controller.HeroController;
import hu.nye.progtech.wumpus.model.CellType;
import hu.nye.progtech.wumpus.model.Hero;
import hu.nye.progtech.wumpus.model.Position;

import java.util.Scanner;

public class GamePlay {
    public static void startGame() {
        HeroController heroController = new HeroController();
        BoardManager boardManager = new BoardManager();
        String filePath = "C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt";
        boardManager.loadBoard(filePath);

        heroController.setInitialPosition(boardManager.getHeroInitialPosition(),boardManager.getHeroInitialDirection());
        heroController.setBoard(boardManager.getGameBoard());  // Hozzáadtuk ezt a sort
        // Tábla kiíratása
        boardManager.printBoard();

        Scanner scanner = new Scanner(System.in);

        gameLoop(heroController, boardManager, scanner);

        // Scanner bezárása
        scanner.close();
    }

    public static void gameLoop(HeroController heroController, BoardManager boardManager, Scanner scanner) {
        while (true) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Változtassa meg a Hős Irányát");
            System.out.println("Kilépés 'Q'");
            System.out.println("Adja meg az irányt (W/A/S/D):");
            String input = scanner.next().toUpperCase();

            if (input.equals("Q")) {
                showMainMenu();
                break; // Kilépés a ciklusból
            }

            heroController.handleInput(input);//Bemenet
            boardManager.updateBoardHeroDirection(heroController.getHeroDirection());//Frissités
            boardManager.updateBoardHeroPosition(heroController.getHeroPosition());//Frissités



            // Új metódus hívása a játékobjektumok elhelyezésére
            boardManager.printBoard(); // Kiíratás
        }
    }


    public static void showMainMenu() { //pálya megjelenítése
        Menu menu = new Menu();
        menu.displayMainMenu();
    }
}