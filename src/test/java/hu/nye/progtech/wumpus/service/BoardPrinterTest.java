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
        void testPrintLoadBoard() {
            // Arrange
            int size = 6;
            char[][] boardArray = new char[][]{
                    {'W', 'W', 'W', 'W', 'W', 'W'},
                    {'W', '_', '_', '_', '_', 'W'},
                    {'W', 'U', '_', 'P', '_', 'W'},
                    {'W', '_', 'G', '_', '_', 'W'},
                    {'W', '_', '_', '_', '_', 'W'},
                    {'W', 'W', 'W', 'W', 'W', 'W'},
            };
            Hero hero = new Hero(1, 'B', Direction.NORTH, 3);

            Board board = new Board(size, boardArray, hero);

            // Elkapjuk a konzolra írt kimenetet
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Act
            BoardPrinter boardPrinter = new BoardPrinter();
            boardPrinter.printLoadBoard(board);

            // Assert
            String expectedOutput =
                    "  A B C D E F \n" +
                            "1 W W W W W W \n" +
                            "2 W H _ _ _ W \n" +
                            "3 W U _ P _ W \n" +
                            "4 W _ G _ _ W \n" +
                            "5 W _ _ _ _ W \n" +
                            "6 W W W W W W \n" +
                            "\n" +
                            "A hős nyilainak száma: 3\n" +
                            "A hős iránya: NORTH\n" +
                            "A hős pozíciója: (2, B)\n" +
                            "Nincs nálad arany\n" +
                            "\n";

            String actualOutput = outputStream.toString();

            String expectedOutputWithoutSpaces = expectedOutput.replaceAll("\\s", "");
            String actualOutputWithoutSpaces = actualOutput.replaceAll("\\s", "");

            assertEquals(expectedOutputWithoutSpaces, actualOutputWithoutSpaces);

            // Visszaállítjuk a konzolt az eredeti állapotába
            System.setOut(originalOut);
        }}

