package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class User {
    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
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
        return scanner.nextLine();
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 2 && username.length() <= 20;
    }

    private void displayInvalidUsernameMessage() {
        System.out.println("A felhasználónév nem felel meg a kritériumnak");
    }
}

