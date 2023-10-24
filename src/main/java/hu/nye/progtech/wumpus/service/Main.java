package hu.nye.progtech.wumpus.service;


import hu.nye.progtech.wumpus.modell.Game;
import hu.nye.progtech.wumpus.modell.LoadBoardFromFile;
import hu.nye.progtech.wumpus.service.Menu;
public class Main {
    public static void main(String[] args) {
        User usernameInput = new User();
        String username = usernameInput.askForUsername();

        Menu menu = new Menu(); // Inicializálás (egy Menu példányt)
        menu.displayMainMenu(); // főmenü meghivasa

        usernameInput.closeScanner();
    }
}

