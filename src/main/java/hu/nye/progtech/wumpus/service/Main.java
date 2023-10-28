package hu.nye.progtech.wumpus.service;

public class Main {
    public static void main(String[] args) {

        User user = new User(); // User osztály példányosítása

        // Felhasználónév bekérése
        String username = user.askForUsername();
        System.out.println("A megadott felhasználónév: " + username);

        Menu menu=new Menu();
        menu.displayMainMenu(); }
}










