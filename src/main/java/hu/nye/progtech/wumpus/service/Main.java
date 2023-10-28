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

        // A User osztály példányosítása és az InputScanner interfésszel való inicializálása.

        InputScanner inputScanner = new InputScanner() {
            @Override
            public String nextLine() {
                return scanner.nextLine();
            }
        };
        User user = new User(inputScanner);
        // A felhasználónevet bekérő metódus hívása.
        String username = user.askForUsername();
        // A bekért felhasználónév kiíratása.
        System.out.println("Bekért felhasználónév: " + username);

        Menu menu=new Menu(); //menü példányositása
        menu.displayMainMenu(); }

}










