package hu.nye.progtech.wumpus.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellTypeTest {

    @Test
    public void testGetSymbol() {
        // Ellenőrizzük, hogy a CellType szimbóluma helyes
        assertEquals('W', CellType.WALL.getSymbol());
        assertEquals('P', CellType.PITFALL.getSymbol());
        assertEquals('U', CellType.WUMPUS.getSymbol());
        assertEquals('H', CellType.HERO.getSymbol());
        assertEquals('G', CellType.GOLD.getSymbol());
        assertEquals('_', CellType.EMPTY.getSymbol());
    }

    @Test
    public void testFromSymbol() {
        // Ellenőrizzük, hogy a helyes CellType-et kapjuk-e vissza a szimbólum alapján
        assertEquals(CellType.WALL, CellType.fromSymbol('W'));
        assertEquals(CellType.PITFALL, CellType.fromSymbol('P'));
        assertEquals(CellType.WUMPUS, CellType.fromSymbol('U'));
        assertEquals(CellType.HERO, CellType.fromSymbol('H'));
        assertEquals(CellType.GOLD, CellType.fromSymbol('G'));
        assertEquals(CellType.EMPTY, CellType.fromSymbol('_'));

        // Ellenőrizzük, hogy nem ismert szimbólum esetén kivételt dob
        assertThrows(IllegalArgumentException.class, () -> CellType.fromSymbol('X'));
    }
}