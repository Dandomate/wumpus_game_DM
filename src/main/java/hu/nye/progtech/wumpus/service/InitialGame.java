package hu.nye.progtech.wumpus.service;

public class InitialGame {

    private final GamePlay gamePlay;

    private  User createUser(InputScanner2 inputScanner2) {
        return new User(inputScanner2);
    }

    public InitialGame(InputScanner2 inputScanner2, InputScanner inputScanner) {
        User user = createUser(inputScanner2);
        DatabaseManager databaseManager = new DatabaseManager();

        gamePlay = new GamePlay(user, databaseManager, null);
        gamePlay.setMenu(new Menu(inputScanner, gamePlay));
    }

    public void start() {
        // Call the startGame method
        gamePlay.startGame();
    }

}
