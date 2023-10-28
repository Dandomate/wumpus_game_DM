package hu.nye.progtech.wumpus.service;

//import hu.nye.progtech.wumpus.controller.GameController;
import hu.nye.progtech.wumpus.model.Hero;

import java.util.Scanner;


public class Menu {
    private final Scanner scanner = new Scanner(System.in);


    public void displayMainMenu() {
        PrintMainPlayMenu();
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
                PrintNotValidMenuChoose();
                displayMainMenu();
        }
    }

    public void displayPlayMenu() {
        PrintDisplayPlayMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                //LoadBoard.loadBoard("C:\\Users\\User\\git\\wumpus\\wumpus_game_DM\\src\\main\\resources\\asd.txt");
                GamePlay gamePlay=new GamePlay();
                gamePlay.startGame();
                break;
            case 2:
                PrintDevelopment();
                displayMainMenu();
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                PrintNotValidMenuChoose();
                displayPlayMenu();
        }
    }

    public void displayEditorMenu() {
        PrintDisplayEditorMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                PrintDevelopment();
                displayEditorMenu();
                break;
            case 2:
                PrintDevelopment();
                displayEditorMenu();
                break;
            case 3:
                PrintDevelopment();
                displayEditorMenu();
                break;
            case 4:
                PrintDevelopment();
                displayEditorMenu();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                PrintNotValidMenuChoose();
                displayEditorMenu();
        }
    }

public void PrintDevelopment(){
    System.out.println("A Következő művelet még fejlesztés alatt\n");
}

public void PrintNotValidMenuChoose(){
    System.out.println("ÉRVÉNYTELEN VÁLASZTÁS !!");
    }
public void PrintDisplayEditorMenu(){
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("*-*                                     *-*");
    System.out.println("*-*     |Válasz a lehetőségek közül|    *-*");
    System.out.println("*-*                                     *-*");
    System.out.println("*-*          |PÁLYASZERKESZTŐ|          *-*");
    System.out.println("*-*                                     *-*");
    System.out.println("*-*        1. Pálya létrehozása         *-*");
    System.out.println("*-*        2. Pálya szerkesztése        *-*");
    System.out.println("*-*        3. Pálya betöltése           *-*");
    System.out.println("*-*        4. Pálya mentése             *-*");
    System.out.println("*-*        5. Vissza a főmenübe         *-*");
    System.out.println("*-*                                     *-*");
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
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
        System.out.println("*-*          2. Pályaszerkesztés        *-*");
        System.out.println("*-*          3. Kilépés                 *-*");
        System.out.println("*-*                                     *-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }


}