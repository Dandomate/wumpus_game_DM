package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class User {
    private final Scanner scanner; //Implementál
    public User(){
        scanner= new Scanner(System.in); //példányositás
    }
    public String askForUsername() {
        System.out.print("Kérem írjon be egy felhasználónevet (legfeljebb 20 karakter): ");
        String username = scanner.nextLine();

        while (!isValidUsername(username)) {
            System.out.println("A felhasználónév nem felel meg a kritériumnak");
            System.out.print("Kérem írjon be egy érvényes felhasználónevet: ");
            username = scanner.nextLine();
        }
        return username;
    }
    public void closeScanner(){
        scanner.close();
    }

    private boolean isValidUsername(String username) {
        return username.length() > 2 && username.length() < 20;
    }
}