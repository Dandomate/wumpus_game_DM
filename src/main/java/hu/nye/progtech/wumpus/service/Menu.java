package hu.nye.progtech.wumpus.service;

public class Menu {

    private final InputScanner scanner;
    private final GamePlay gamePlay;

    public Menu(InputScanner scanner, GamePlay gamePlay) {
        this.scanner = scanner;
        this.gamePlay = gamePlay;
    }

    public void displayMainMenu() {
        printMainPlayMenu();
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
                printNotValidMenuChoose();
                displayMainMenu();
        }
    }

    public void displayPlayMenu() {
        printDisplayPlayMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                gamePlay.startGamePlay();
                break;
            case 2:
                gamePlay.startGamePlayDatabase(gamePlay.getUsername());
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                printNotValidMenuChoose();
                displayPlayMenu();
        }
    }

    public void printNotValidMenuChoose() {
        System.out.println("ÉRVÉNYTELEN VÁLASZTÁS !!");
    }

    public void printDisplayPlayMenu() {
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

    public void printMainPlayMenu() {
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