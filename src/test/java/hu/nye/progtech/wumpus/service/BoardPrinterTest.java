package hu.nye.progtech.wumpus.service;

import hu.nye.progtech.wumpus.model.Board;
import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardPrinterTest {
    @Test
    public void testPrintLoadBoard() {
        // Előkészítjük a tesztadatokat
        int size = 6;
        char[][] boardArray = new char[][]{
                {'W', 'W', 'W', 'W','W','W'},
                {'W', 'H', '_', '_','_','W'},
                {'W', 'U', '_', 'P','_','W'},
                {'W', '_', 'G', '_','_','W'},
                {'W', '_', '_', '_','_','W'},
                {'W', 'W', 'W', 'W','W','W'},
        };
        Hero hero = new Hero(2, 'B', Direction.NORTH, 1);
        Board board = new Board(size, boardArray, hero);

        // Elvárt kimenet
        String expectedOutput = "  A B C D E F \n" +
                "1 W W W W W W \n" +
                "2 W H _ _ _ W \n" +
                "3 W U _ P _ W \n" +
                "4 W _ G _ _ W \n" +
                "5 W _ _ _ _ W \n" +
                "6 W W W W W W \n" +
                "\n" +
                "A hős nyilainak száma: 1\n" +
                "A hős pozíciója: NORTH\n\n";

        // Átirányítjuk a kimenetet
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Tesztelt kód meghívása
        BoardPrinter.printLoadBoard(board);

        // Tényleges kimenet
        String actualOutput = outputStream.toString();

        // Ellenőrizzük, hogy az elvárt kimenet egyezik-e a tényleges kimenettel
        // Egyezés szóközök nélkül
        String expectedOutputWithoutSpaces = expectedOutput.replaceAll("\\s", "");
        String actualOutputWithoutSpaces = actualOutput.replaceAll("\\s", "");

        assertEquals(expectedOutputWithoutSpaces, actualOutputWithoutSpaces);
    }
}