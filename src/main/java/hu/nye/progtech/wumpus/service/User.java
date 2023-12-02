package hu.nye.progtech.wumpus.service;

public class User {
    private final InputScanner2 inputScanner2;
    private int score;
    private String username;

    public User(InputScanner2 inputScanner2) {
        this.inputScanner2 = inputScanner2;
        this.score = 0; // A pontszám inicializálása 0-ra
        this.username = ""; // Felhasználónév inicializálása üres stringre
    }

    public String askForUsername() {
        String userInput;
        do {
            userInput = getUsernameFromUser();
            if (!isValidUsername(userInput)) {
                System.out.println("A felhasználónév nem felel meg a kritériumnak");
            }
        } while (!isValidUsername(userInput));

        username = userInput; // itt állítjuk be az attribútum értékét
        return username;
    }

    public InputScanner2 getInputScanner2() {
        return inputScanner2;
    }

    public String getUsername() {
        return username;
    }

    private String getUsernameFromUser() {
        System.out.print("Kérem írjon be egy felhasználónevet (legfeljebb 20 karakter): ");
        return inputScanner2.nextLine();
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 2 && username.length() <= 20;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score = score + 1;
    }

    public String getUserWithScore() {
        return ("Gratulálunk " + getUsername() + ": " + getScore() + " pontod van jelenleg");
    }

}

