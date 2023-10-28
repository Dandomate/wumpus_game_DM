package hu.nye.progtech.wumpus.model;

import static org.junit.jupiter.api.Assertions.*;

import hu.nye.progtech.wumpus.model.Direction;
import hu.nye.progtech.wumpus.model.Hero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {


    @Test
    public void testSetHeroDirection() {
        Hero hero = new Hero(3, 'B', Direction.NORTH, 1);
        hero.setHeroDirection(Direction.SOUTH);
        assertEquals(Direction.SOUTH, hero.getHeroDirection());
    }

    @Test
    public void testHeroArrows() {
        Hero hero = new Hero(3, 'B', Direction.NORTH, 1);
        assertEquals(3, hero.getHeroArrows());
    }
    @Test
    public void testGetHeroDirection() {
        Hero hero = new Hero(3, 'B', Direction.NORTH, 1);
        assertEquals(Direction.NORTH, hero.getHeroDirection());
    }

}