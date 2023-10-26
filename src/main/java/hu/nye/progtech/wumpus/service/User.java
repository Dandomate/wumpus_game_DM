package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class User {
    private final Scanner scanner; //Implementál
    public User(){
        scanner= new Scanner(System.in); //példányositás
    }
    public String askForUsername(){
        System.out.print("Kérem írjon be egy felhasználónevet: ");
        return scanner.nextLine();
    }
    public void closeScanner(){
        scanner.close();
    }
}
