package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.controller.HeroController;

import java.util.Scanner;

public class GamePlay {
    public static void startGame() {
        HeroController heroController = new HeroController();
        BoardManager boardManager = new BoardManager();
        String filePath = "C:\\Users\\User\\git\\wumpus\\wumpus_game_DM\\src\\main\\resources\\asd.txt";
        boardManager.loadBoard(filePath);

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
            boardManager.printBoard(); // Kiíratás
        }
    }

    public static void showMainMenu() {
        Menu menu = new Menu();
        menu.displayMainMenu();
    }
}