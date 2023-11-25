
/*package hu.nye.progtech.wumpus.controller;

import hu.nye.progtech.wumpus.controller.HeroController;
import hu.nye.progtech.wumpus.model.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

    public class HeroControllerTest {

        private HeroController heroController;

        @Before
        public void setUp() {
            heroController = new HeroController();
        }

        @Test
        public void testHandleInputWithValidInputW() {
            heroController.handleInput("W");
            assertEquals(Direction.NORTH, heroController.getHeroDirection());
        }

        @Test
        public void testHandleInputWithValidInputA() {
            heroController.handleInput("A");
            assertEquals(Direction.WEST, heroController.getHeroDirection());
        }

        @Test
        public void testHandleInputWithValidInputS() {
            heroController.handleInput("S");
            assertEquals(Direction.SOUTH, heroController.getHeroDirection());
        }

        @Test
        public void testHandleInputWithValidInputD() {
            heroController.handleInput("D");
            assertEquals(Direction.EAST, heroController.getHeroDirection());
        }

        @Test
        public void testHandleInputWithInvalidInput() {
            heroController.handleInput("X"); // Érvénytelen irány
            assertEquals(null, heroController.getHeroDirection());
        }
    }

 */