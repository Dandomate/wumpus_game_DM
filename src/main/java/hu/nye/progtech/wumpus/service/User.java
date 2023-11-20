package hu.nye.progtech.wumpus.service;



public class User {
    private final InputScanner inputScanner;


    public User(InputScanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public String askForUsername() {
        String username;

        do {
            username = getUsernameFromUser();
            if (!isValidUsername(username)) {
                displayInvalidUsernameMessage();
            }
        } while (!isValidUsername(username));

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

}

