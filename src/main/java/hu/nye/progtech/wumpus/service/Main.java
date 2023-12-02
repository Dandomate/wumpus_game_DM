package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputScanner2 inputScanner2 = new Input2(scanner);
        InputScanner inputScanner = new Input(scanner);

        InitialGame initialGame = new InitialGame(inputScanner2, inputScanner);
        initialGame.start();
        }
}




