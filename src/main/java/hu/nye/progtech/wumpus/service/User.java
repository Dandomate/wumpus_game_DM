package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class User {
    private final Scanner scanner;
    public User(){
        scanner= new Scanner(System.in);
    }
    public String askForUsername(){
        System.out.print("Kérem adja meg a felhasználónevét: ");
        return scanner.nextLine();
    }
    public void closeScanner(){
        scanner.close();
    }
}
