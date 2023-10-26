package hu.nye.progtech.wumpus.service;


import hu.nye.progtech.wumpus.modell.Board;

import hu.nye.progtech.wumpus.modell.BoardPrinter;
import hu.nye.progtech.wumpus.modell.Hero;
import hu.nye.progtech.wumpus.modell.LoadBoardFromFile;
import hu.nye.progtech.wumpus.service.Menu;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        User usernameInput = new User();
        String username = usernameInput.askForUsername();

        Menu menu = new Menu(); // Inicializálás (egy Menu példányt)
        menu.displayMainMenu(); // főmenü meghivasa

        usernameInput.closeScanner();

        System.out.println();


/*

        //proba
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adja meg a pálya méretét (6-20): ");
        int size = scanner.nextInt();

        Hero hero = new Hero(3, 3, 'N');

        char[][] boardData = new char[size][size];
        Board board = new Board(size, boardData, hero);
        System.out.println(board);
 */


    }



}



