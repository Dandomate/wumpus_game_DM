package hu.nye.progtech.wumpus.service;



public class User {
    private final InputScanner inputScanner;

    private int score;
    private String username;

    public User(InputScanner inputScanner) {
        this.inputScanner = inputScanner;
        this.score = 0; // A pontszám inicializálása 0-ra
        this.username = ""; // Felhasználónév inicializálása üres stringre
    }


    public String askForUsername() {
        String userInput;
        do {
            userInput = getUsernameFromUser();
            if (!isValidUsername(userInput)) {
                displayInvalidUsernameMessage();
            }
        } while (!isValidUsername(userInput));

        username = userInput; // itt állítjuk be az attribútum értékét
        return username;
    }


    public String getUsername() {
        return username;
    }
    private String getUsernameFromUser() {
        System.out.print("Kérem írjon be egy felhasználónevet (legfeljebb 20 karakter): ");
        return inputScanner.nextLine();
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 2 && username.length() <= 20;
    }

    private void displayInvalidUsernameMessage() {
        System.out.println("A felhasználónév nem felel meg a kritériumnak");
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score = score+1;
    }

    public String getUserWithScore() {
        return ("Gratulálunk: "+getUsername() + ": " + getScore() + " pontod van jelenleg");
    }


}

