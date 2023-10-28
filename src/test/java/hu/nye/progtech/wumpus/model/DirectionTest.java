package hu.nye.progtech.wumpus.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void testGetSymbol() {
        // Az összes irányhoz tartozó helyes szimbólum visszaadása
        assertEquals('N', Direction.NORTH.getSymbol());
        assertEquals('E', Direction.EAST.getSymbol());
        assertEquals('S', Direction.SOUTH.getSymbol());
        assertEquals('W', Direction.WEST.getSymbol());
    }

    @Test
    public void testFromSymbol() {
        // Az összes szimbólumhoz tartozó helyes irány visszaadása
        assertEquals(Direction.NORTH, Direction.fromSymbol('N'));
        assertEquals(Direction.EAST, Direction.fromSymbol('E'));
        assertEquals(Direction.SOUTH, Direction.fromSymbol('S'));
        assertEquals(Direction.WEST, Direction.fromSymbol('W'));
    }
}