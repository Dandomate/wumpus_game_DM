package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class Input2 implements InputScanner2 {
    private final Scanner scanner;

    // Konstruktor, amely megkap egy Scanner objektumot
    public Input2(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}