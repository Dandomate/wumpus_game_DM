package hu.nye.progtech.wumpus.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import hu.nye.progtech.wumpus.controller.HeroController;
import hu.nye.progtech.wumpus.model.Scoreboard;

public class GamePlay {
    private User user;
    private DatabaseManager databaseManager;
    private Menu menu;
    private String username; // Osztályszintű változó
    private HeroController heroController;
    private BoardManager boardManager;

    public GamePlay(User user, DatabaseManager databaseManager, Menu menu) {
        this.user = user;
        this.databaseManager = databaseManager;
        this.menu = menu;
        this.heroController = new HeroController(user, menu);
        this.boardManager = new BoardManager();
    }

    public void startGame() {
        // A felhasználónevet bekérő metódus hívása.
        username = user.askForUsername();
        // A bekért felhasználónév kiíratása.
        System.out.println("Bekért felhasználónév: " + username);
            startMenu();
    }

    public void startMenu() {
        menu.displayMainMenu();
    }

    public void startGamePlay() {
        HeroController heroController = new HeroController(user, menu); //ez ha nem jó ki kell szedni !!!
        BoardManager boardManager = new BoardManager();
        String filePath = "C:\\Users\\User\\Desktop\\wumpus_game_DM\\src\\main\\resources\\asd.txt";
        boardManager.loadBoard(filePath);

        heroController.setInitialPosition(boardManager.getHeroInitialPosition(), boardManager.getHeroInitialDirection());
        heroController.setBoard(boardManager.getGameBoard());

        // Tábla kiíratása
        boardManager.printBoard();

        Scanner scanner = new Scanner(System.in);

        // Game
        gameLoop(user.getUsername(), heroController, boardManager, scanner);

        // Scanner bezárása
        scanner.close();
    }

    public void startGamePlayDatabase(String username) {
        HeroController heroController = new HeroController(user, menu);
        BoardManager boardManager = new BoardManager();
        boardManager.loadBoardDatabase(username);
        heroController.setInitialPosition(boardManager.getHeroInitialPosition(), boardManager.getHeroInitialDirection());
        heroController.setBoard(boardManager.getGameBoard());
        boardManager.printBoard();
        Scanner scanner = new Scanner(System.in);
        gameLoop(username, heroController, boardManager, scanner);
        scanner.close();
    }

    public void gameLoop(String username, HeroController heroController, BoardManager boardManager, Scanner scanner) {
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

    public  void showMainMenu() { //pálya megjelenítése
        menu.displayMainMenu();
    }

    public void displayJsonScores(String filePath, Scanner scanners) {
        Scoreboard scoreboard = new Scoreboard(user);

        while (true) {
            final Map<String, Integer> pontok = scoreboard.loadScoresFromFile(filePath);

            // Rendezzük a pontokat csökkenő sorrendbe
            final List<Map.Entry<String, Integer>> sortedScores = pontok.entrySet().stream()
                    .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                    .collect(Collectors.toList());

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("*-*                                     *-*");
            System.out.println("*-*         |JÁTÉKOSOK PONTJAI|         *-*");
            System.out.println("*-*                                     *-*");

            // Kiírjuk a rendezett pontokat a konzolra
            sortedScores.forEach(entry -> {
                String formattedLine = String.format("*-*  %14s : pont %-12d *-*", entry.getKey(), entry.getValue());
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
        displayJsonScores(filePath, scanners);
    }

    public  String getUsername() {
        return username;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}