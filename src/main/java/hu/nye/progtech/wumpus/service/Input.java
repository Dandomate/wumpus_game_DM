package hu.nye.progtech.wumpus.service;

import java.util.Scanner;

public class Input implements InputScanner {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int nextInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Érvénytelen szám. Kérem, adjon meg egy érvényes egész számot!");
            scanner.next(); // eldob minden érvénytelen bevitelt
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // új sor beolvasása
        return result;
    }
}