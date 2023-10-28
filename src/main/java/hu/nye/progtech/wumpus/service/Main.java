package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        User user = new User(); // User osztály példányosítása

        // Felhasználónév bekérése
        String username = user.askForUsername();
        System.out.println("A megadott felhasználónév: " + username);

 */

        Scanner scanner = new Scanner(System.in);
        User user = new User(scanner);

        String username = user.askForUsername();
        System.out.println("A beírt felhasználónév: " + username);
        Menu menu=new Menu(); //menü példányositása
        menu.displayMainMenu(); }

}










