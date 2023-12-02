package hu.nye.progtech.wumpus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class PositionTest {

    @Test
    void testMoveUp() {
        Position position = new Position(2, 'C');
        position.moveUp();
        assertEquals(1, position.getRow());
        assertEquals('C', position.getColumn());
    }

    @Test
    void testMoveDown() {
        Position position = new Position(2, 'C');
        position.moveDown();
        assertEquals(3, position.getRow());
        assertEquals('C', position.getColumn());
    }

    @Test
    void testMoveLeft() {
        Position position = new Position(2, 'C');
        position.moveLeft();
        assertEquals(2, position.getRow());
        assertEquals('B', position.getColumn());
    }

    @Test
    void testMoveRight() {
        Position position = new Position(2, 'C');
        position.moveRight();
        assertEquals(2, position.getRow());
        assertEquals('D', position.getColumn());
    }

    @Test
    void testToString() {
        Position position = new Position(2, 'C');
        assertEquals("(2, C)", position.toString());
    }

    @Test
    void testSetRow() {
        Position position = new Position();
        position.setRow(5);
        assertEquals(5, position.getRow());
    }

    @Test
    void testSetColumn() {
        Position position = new Position();
        position.setColumn('Z');
        assertEquals('Z', position.getColumn());
    }

    @Test
    void testCopy() {
        Position original = new Position(3, 'D');
        Position copy = original.copy();
        assertEquals(original.getRow(), copy.getRow());
        assertEquals(original.getColumn(), copy.getColumn());
    }

    @Test
    void testMoveInDirection() {
        Position position = new Position(2, 'C');
        position.moveInDirection(Direction.NORTH);
        assertEquals(1, position.getRow());
        assertEquals('C', position.getColumn());

        position.moveInDirection(Direction.WEST);
        assertEquals(1, position.getRow());
        assertEquals('B', position.getColumn());

        position.moveInDirection(Direction.SOUTH);
        assertEquals(2, position.getRow());
        assertEquals('B', position.getColumn());

        position.moveInDirection(Direction.EAST);
        assertEquals(2, position.getRow());
        assertEquals('C', position.getColumn());
    }
}