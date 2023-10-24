package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

import hu.nye.progtech.wumpus.modell.Game;
import hu.nye.progtech.wumpus.modell.LoadBoardFromFile;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    /*
    private String playerName;
    public void askForPlayerName(User user) {
        playerName = user.askForUsername();
    }
*/

    public void displayMainMenu() {
        System.out.println("Főmenü:");
        System.out.println("1. Pályaszerkesztés");
        System.out.println("2. Játék");
        System.out.println("3. Kilépés");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayEditorMenu();
                break;
            case 2:
                displayPlayMenu();
                break;
            case 3:
                System.out.println("Kilépés a játékból");
                break;
            default:
                System.out.println("Érvénytelen választás.");
                displayMainMenu();
        }
    }

    public void displayPlayMenu() {
        System.out.println("Játék");
        System.out.println("1. Pálya betöltése");
        System.out.println("2. Pálya betöltése adatbázisból");
        System.out.println("3. Vissza a főmenübe");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // A pályafájl elérési útja
                String filePath = "C:\\Users\\User\\git\\wumpus\\wumpus_game_DM\\src\\main\\resources\\asd.txt";
                // Játék kezdése a beolvasott fájbol
                Game.playGame(filePath);
                break;
            case 2:
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("Érvénytelen választás.");
                displayPlayMenu();
        }
    }

    public void displayEditorMenu() {
        System.out.println("Pályaszerkesztés menü:");
        System.out.println("1. Pálya létrehozása");
        System.out.println("2. Pálya betöltése");
        System.out.println("3. Pálya mentése");
        System.out.println("4. Vissza a főmenübe");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Érvénytelen választás.");
                displayEditorMenu();
        }
    }
    /*public String getPlayerName(){
        return playerName;
    }
*/


}