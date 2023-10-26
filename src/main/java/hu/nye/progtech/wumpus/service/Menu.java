package hu.nye.progtech.wumpus.service;

import java.io.IOException;
import java.util.Scanner;


import hu.nye.progtech.wumpus.modell.Game;


public class Menu {
    private final Scanner scanner = new Scanner(System.in);


    public void displayMainMenu() {
        System.out.println("*-*-*-*-*-*Főmenü*-*-*-*-*-*");
        System.out.println("1. Játék");
        System.out.println("2. Pályaszerkesztés");
        System.out.println("3. Kilépés");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayPlayMenu();
                break;
            case 2:
                displayEditorMenu();
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
        System.out.println("*-*-*-*-*-*Játék*-*-*-*-*-*");
        System.out.println("1. Pálya betöltése fájlból");
        System.out.println("2. Pálya betöltése adatbázisból");
        System.out.println("3. Vissza a főmenübe");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Game.playGame("C:\\Users\\User\\git\\wumpus\\wumpus_game_DM\\src\\main\\resources\\asd.txt");
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
        System.out.println("*-*-*-*-*-*Pályaszerkesztő*-*-*-*-*-*");
        System.out.println("1. Pálya létrehozása");
        System.out.println("2. Pálya szerkesztése");
        System.out.println("3. Pálya betöltése");
        System.out.println("4. Pálya mentése");
        System.out.println("5. Vissza a főmenübe");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                System.out.println("Érvénytelen választás.");
                displayEditorMenu();
        }
    }



}