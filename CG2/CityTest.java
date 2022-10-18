import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class CityTest.
 *
 * @author  Steffen W. Christensen
 * @version 17/11-2018 17:00, version 1.1
 */
public class CityTest
{
    private Country country1;
    private City cityA, cityB, cityC;
    private Game game;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        // Create Game
        game = new Game(0);
        game.getRandom().setSeed(0);
                
        // Create countries
        country1 = new Country("Country 1", null);
        
        // Set game
        country1.setGame(game);

        // Create Cities
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new City("City C", 1, country1);
    }
    
        /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Testing the instance variables in the constructor.
     * We test:
     * String name.
     * int value, int initialValue.
     * Country country.
     */
    @Test
    public void constructor() {
        assertEquals(cityA.getName(), "City A");
        assertEquals(cityA.getValue(), 80);
        assertEquals(cityA.getCountry(), country1);
        assertEquals(cityB.getName(), "City B");
        assertEquals(cityB.getValue(), 60);
        assertEquals(cityB.getCountry(), country1);
    }
    
    /**
     * Testing the changeValue() method.
     * We test:
     * That calling changeValue() with a positive value adds the value onto the original value.
     * That calling changeValue() with a negative value reduces the value.
     * That calling changeValue() with a value of zero does nothing.
     */
    @Test
    public void changeValue() {
        // Positive tests
        assertEquals(cityA.getValue(), 80);
        cityA.changeValue(20);
        assertEquals(cityA.getValue(), 100);
        cityA.changeValue(1000000);
        assertEquals(cityA.getValue(), 1000100);
        cityA.changeValue(-1000100);
        assertEquals(cityA.getValue(), 0);
        cityA.changeValue(-1);
        cityA.changeValue(0);
        assertEquals(cityA.getValue(), -1);
        
        // Negative tests
        cityA.reset();
        cityA.changeValue(-80);
        assertEquals(cityA.getValue(), 0);
        cityA.changeValue(Integer.MAX_VALUE);
        assertEquals(cityA.getValue(), Integer.MAX_VALUE);
        cityA.changeValue(-Integer.MAX_VALUE);
        assertEquals(cityA.getValue(), 0);
    }
    
    /**
     * Testing the reset() method.
     * We test:
     * That calling reset() will set the value of the City to InitialValue no matter what the value is.
     */
    @Test
    public void reset() {
        // Positive tests
        assertEquals(cityA.getValue(), 80);
        cityA.changeValue(-80);
        cityA.reset();
        assertEquals(cityA.getValue(), 80);
        cityA.changeValue(-80);
        cityA.changeValue(-Integer.MAX_VALUE);
        cityA.reset();
        assertEquals(cityA.getValue(), 80);
    }
    
    /**
     * Testing the compareTo() method.
     * We test:
     * Whether we are correctly comparing the cities that should be lower in the comparison.
     * If comparing a city to itself it should successfully return zero.
     * That calling compareTo() with a newly created City successfully returns its correct "position".
     */
    @Test
    public void compareTo() {
        // Positive tests
        assertTrue(cityA.compareTo(cityB) < 0);
        assertTrue(cityB.compareTo(cityA) > 0);
        City cityD = new City("City D", 0, country1);
        assertTrue(cityA.compareTo(cityC) < 0);
        assertTrue(cityB.compareTo(cityC) < 0);
        assertEquals(cityA.compareTo(cityA), 0);
    }
    
    /**
     * Testing the arrive() method.
     * We test:
     * That calling arrive() with a valid value returns a bonus that is reduced from the current value.
     * That calling arrive() with a City with no value returns 0.
     * That calling arrive() with a City with negative value returns 0.
     */
    @Test
    public void arrive() {
        // Positive tests
        /** Bonus = 80 */
        for(int i=0; i<1000; i++) {
            int initialValue = 80;
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(initialValue);
            game.getRandom().setSeed(i);
            int arrive = cityA.arrive();
            assertEquals(arrive, bonus);
            assertEquals(cityA.getValue(), initialValue-bonus);
            cityA.reset();
        }
        
        /** Bonus = 1 */
        for(int i=0; i<1000; i++) {
            int initialValue = 80;
            cityA.changeValue(-79);
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(1);
            game.getRandom().setSeed(i);
            int arrive = cityA.arrive();
            assertEquals(arrive, bonus);
            assertEquals(cityA.getValue(), (initialValue-79)-bonus);
            cityA.reset();
        }
        
        // Negative tests
        /** Bonus = 0 */
        for(int i=0; i<1000; i++) {
            cityA.changeValue(-80);
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityA.getValue());
            game.getRandom().setSeed(i);
            int arrive = cityA.arrive();
            assertEquals(arrive, bonus);
            assertEquals(cityA.getValue(), 0);
            cityA.reset();
        }
        
        /** Bonus = -20 */
        for(int i=0; i<1000; i++) {
            int initialValue = 80;
            cityA.changeValue(-100);
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityA.getValue());
            game.getRandom().setSeed(i);
            int arrive = cityA.arrive();
            assertEquals(arrive, bonus);
            assertEquals(cityA.getValue(), initialValue-100);
            cityA.reset();
        }
    }
}
