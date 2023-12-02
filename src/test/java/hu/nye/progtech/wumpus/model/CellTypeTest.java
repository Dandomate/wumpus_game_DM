package hu.nye.progtech.wumpus.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellTypeTest {

    @Test
    void testGetSymbol() {
        assertEquals('W', CellType.WALL.getSymbol());
        assertEquals('P', CellType.PITFALL.getSymbol());
        assertEquals('U', CellType.WUMPUS.getSymbol());
        assertEquals('H', CellType.HERO.getSymbol());
        assertEquals('G', CellType.GOLD.getSymbol());
        assertEquals('X', CellType.START.getSymbol());
        assertEquals('_', CellType.EMPTY.getSymbol());
    }

    @Test
    void testFromSymbol() {
        assertEquals(CellType.WALL, CellType.fromSymbol('W'));
        assertEquals(CellType.PITFALL, CellType.fromSymbol('P'));
        assertEquals(CellType.WUMPUS, CellType.fromSymbol('U'));
        assertEquals(CellType.HERO, CellType.fromSymbol('H'));
        assertEquals(CellType.GOLD, CellType.fromSymbol('G'));
        assertEquals(CellType.START, CellType.fromSymbol('X'));
        assertEquals(CellType.EMPTY, CellType.fromSymbol('_'));
    }

    @Test
    void testFromSymbolWithUnknownSymbol() {
        assertThrows(IllegalArgumentException.class, () -> {
            CellType.fromSymbol('Z'); // Ez egy ismeretlen szimbólum, hiba kell, hogy legyen
        });
    }
}

