package hu.nye.progtech.wumpus.service;


import java.util.Scanner;



public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    GamePlay gamePlay = new GamePlay();


    public void displayMainMenu() {
        PrintMainPlayMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayPlayMenu();
                break;
            case 3:
                System.out.println("Kilépés a játékból");
                System.exit(0);
                break;
            case 2:
                gamePlay.displayJsonScoresStart();
                System.out.println("\n");
                displayMainMenu();
                break;
            default:
                PrintNotValidMenuChoose();
                displayMainMenu();
        }
    }

    public void displayPlayMenu() {
        PrintDisplayPlayMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                gamePlay.startGamePlay();
                break;
            case 2:
                gamePlay.startGamePlayDatabase(gamePlay.Username());
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                PrintNotValidMenuChoose();
                displayPlayMenu();
        }
    }



public void PrintDevelopment(){
    System.out.println("A Következő művelet még fejlesztés alatt\n");
}

public void PrintNotValidMenuChoose(){
    System.out.println("ÉRVÉNYTELEN VÁLASZTÁS !!");
    }

    public void PrintDisplayPlayMenu(){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*     |Válasz a lehetőségek közül|    *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*              |JÁTÉK|                *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*    1. Pálya betöltése fájlból       *-*");
        System.out.println("*-*    2. Pálya betöltése adatbázisból  *-*");
        System.out.println("*-*    3. Vissza a főmenübe             *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    public void PrintMainPlayMenu(){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*   |ÜDVÖZÖLLEK A WUMPUS JÁTÉKBAN|    *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*              |FŐMENÜ|               *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*          1. Játék                   *-*");
        System.out.println("*-*          2. Elért Pontok            *-*");
        System.out.println("*-*          3. Kilépés                 *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }


}