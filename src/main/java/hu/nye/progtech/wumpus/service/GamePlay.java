package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.controller.HeroController;
import hu.nye.progtech.wumpus.model.Scoreboard;

import java.util.Map;
import java.util.Scanner;


public class GamePlay {
    private static final User user = createUser();
    private static final DatabaseManager databaseManager= new DatabaseManager();
    private static final String DATABASE_URL = DatabaseConfig.DATABASE_URL;
    private static String username; // Az osztályszintű változó

    public static void startGame(){
        // A felhasználónevet bekérő metódus hívása.
        username = user.askForUsername();


        // A bekért felhasználónév kiíratása.
        System.out.println("Bekért felhasználónév: " + username);
            startMenu();

    }


    public static void startMenu() {

        //menü példányositása
        Menu menu = new Menu();

        // DisplayMainMenu hívása
        menu.displayMainMenu();
    }
    public static void startGamePlay() {
        HeroController heroController = new HeroController(user); //ez ha nem jó ki kell szedni !!!
        BoardManager boardManager = new BoardManager();
        String filePath = "C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt";
        boardManager.loadBoard(filePath);

        heroController.setInitialPosition(boardManager.getHeroInitialPosition(),boardManager.getHeroInitialDirection());
        heroController.setBoard(boardManager.getGameBoard());
        // Tábla kiíratása
        boardManager.printBoard();

        Scanner scanner = new Scanner(System.in);

        // Game Loop
        gameLoop(user.getUsername(), heroController, boardManager, scanner);




        // Scanner bezárása
        scanner.close();
    }
    public static void startGamePlayDatabase(String username) {
        HeroController heroController = new HeroController(user);
        BoardManager boardManager = new BoardManager();

        boardManager.loadBoardDatabase(username);


        heroController.setInitialPosition(boardManager.getHeroInitialPosition(),boardManager.getHeroInitialDirection());
        heroController.setBoard(boardManager.getGameBoard());


        boardManager.printBoard();

        Scanner scanner = new Scanner(System.in);

        gameLoop(username, heroController, boardManager, scanner);

            scanner.close();

    }


    public static void gameLoop(String username, HeroController heroController, BoardManager boardManager, Scanner scanner) {
        while (true) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Irányítsd a hősöd és nyerj");
            System.out.println("Kilépés 'Q'");
            System.out.println("Mentés és Kilépés 'M'");
            System.out.println("A hős irányának megváltozatása (W/A/S/D):");
            System.out.println("A hős léptetése előre/hátra/jobbra/balra (U/H/J/K):");
            System.out.println("Nyíl kilövése (G):");
            String input = scanner.next().toUpperCase();


            if (input.equals("Q")) {
                // Adatbázisba mentés
                showMainMenu();
                break;
            } else if (input.equals("M")) {
                databaseManager.saveGameState(username, boardManager.getGameState());
                showMainMenu();
                break;
            }

            heroController.handleInput(input);
            boardManager.updateBoardHeroDirection(heroController.getHeroDirection());
            boardManager.updateBoardHeroPosition(heroController.getHeroPosition());

            // Új metódus hívása a játékobjektumok elhelyezésére
            boardManager.printBoard();


        }
    }



    public static void showMainMenu() { //pálya megjelenítése
        Menu menu = new Menu();
        menu.displayMainMenu();
    }

    private static User createUser() {
        InputScanner inputScanner = new InputScanner() {
            @Override
            public String nextLine() {
                return new Scanner(System.in).nextLine();
            }
        };

        return new User(inputScanner);
    }

    public static void displayJsonScores(String filePath, Scanner scanners) {
        Scoreboard scoreboard = new Scoreboard(user);

        while (true) {
            Map<String, Integer> pontok = scoreboard.loadScoresFromFile(filePath);

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("*-*                                     *-*");
            System.out.println("*-*         |JÁTÉKOSOK PONTJAI|         *-*");
            System.out.println("*-*                                     *-*");

            // Kiírjuk a JSON tartalmát a konzolra
            pontok.forEach((felhasznalonev, pont) -> {
                String formattedLine = String.format("*-*  %14s : pont %-12d *-*", felhasznalonev, pont);
                System.out.println(formattedLine);
            });

            System.out.println("*-*                                     *-*");
            System.out.println("*-*            Kilépés 'Q'              *-*");
            System.out.println("*-*                                     *-*");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

            String input = scanners.next().toUpperCase();

            if (input.equals("Q")) {
                showMainMenu();
                break;
            }
        }
    }

    public void displayJsonScoresStart() {
        String filePath = "C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.json";
        Scanner scanners = new Scanner(System.in);
        displayJsonScores(filePath,scanners);
    }
        public static String Username() {
        return username;
    }
}