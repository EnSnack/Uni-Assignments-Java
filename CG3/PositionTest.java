import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class PositionTest.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class PositionTest
{
    private City cityA, cityB;
    private Position pos, pos2, neg, same, same2, pNull;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        // Create Cities
        cityA = new City("City A", 80, null);
        cityB = new City("City B", 60, null);
        
        // Create position
        pos = new Position(cityA, cityB, 3);
        pos2 = new Position(cityB, cityA, 1);
        neg = new Position(cityA, cityB, -1);
        same = new Position(cityA, cityA, 0);
        same2 = new Position(cityA, cityA, Integer.MAX_VALUE);
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
     * Including possible special variables.
     * We test:
     * City from, City to.
     * int distance, int total.
     */
    @Test
    public void constructor() {
        assertEquals(pos.getFrom(), cityA);
        assertEquals(pos.getTo(), cityB);
        assertEquals(pos.getDistance(), 3);
        assertEquals(pos.getTotal(), 3);
        assertEquals(neg.getDistance(), -1);
        assertEquals(same.getFrom(), cityA);
        assertEquals(same.getTo(), cityA);
    }
    
    /**
     * Testing the move() method.
     * We test:
     * That calling move() decrements distance by 1 if above 0.
     * That calling move() successfully returns true if moved.
     * That calling move() with a distance of 0 returns false.
     * That calling move() on a position with negative distance also returns false.
     */
    @Test
    public void move() {
        // Positive tests
        int curDistance = pos.getDistance();
        assertTrue(pos.move());
        assertEquals(pos.getDistance(), curDistance-1);
        curDistance = pos.getDistance();
        assertTrue(pos.move());
        assertEquals(pos.getDistance(), curDistance-1);
        assertTrue(pos.move());
        assertEquals(pos.getDistance(), 0);
        assertTrue(pos.getTotal() > 0);
        assertFalse(pos.move());
        
        // Negative tests
        assertFalse(neg.move());
        assertTrue(neg.getDistance() < 0);
        assertFalse(same.move());
        assertTrue(same2.move());
        assertTrue(same2.getDistance() > 0);
        curDistance = same2.getDistance();
        assertTrue(same2.move());
        assertEquals(same2.getDistance(), curDistance-1);
    }
    
    /**
     * Testing the hasArrived() method.
     * We test:
     * That calling hasArrived() above 0 distance returns false.
     * That calling hasArrived() on 0 distance returns true.
     * That calling hasArrived() on negative distance returns false.
     */
    @Test
    public void hasArrived() {
        // Positive tests
        assertFalse(pos.hasArrived());
        assertTrue(pos.getDistance() > 0);
        pos.move();
        pos.move();
        pos.move();
        assertTrue(pos.hasArrived());
        assertEquals(pos.getDistance(), 0);
        assertTrue(pos.getTotal() > 0);
        
        // Negative tests
        assertTrue(neg.getDistance() < 0);
        assertFalse(neg.hasArrived());
        assertTrue(same.hasArrived());
        assertFalse(same2.hasArrived());
    }
    
    /**
     * Testing the turnAround() method.
     * We test:
     * That calling turnAround() successfully swaps the from and to cities.
     * That calling turnAround() successfully calculates the correct distance to the new city.
     * That calling turnAround() while currently in the city will turn you towards where you came from.
     * That calling turnAround() with a negative distance and total will essentially 
     * reset it, by putting the player at distance 0.
     * That calling turnAround() with to and from as the same will change nothing.
     */
    @Test
    public void turnAround() {
        // Positive tests
        /** Successful city swap */
        assertEquals(pos.getTo(), cityB);
        assertEquals(pos.getFrom(), cityA);
        assertEquals(pos.getDistance(), 3);
        pos.turnAround();
        assertEquals(pos.getTo(), cityA);
        assertEquals(pos.getFrom(), cityB);
        assertEquals(pos.getDistance(), 0);
        pos.turnAround();
        
        /** Successful distance calculation */
        int totalDistance = pos.getTotal();
        assertEquals(pos.getTo(), cityB);
        assertEquals(pos.getFrom(), cityA);
        assertEquals(pos.getDistance(), 3);
        pos.move();
        int distance = pos.getDistance();
        pos.turnAround();
        assertEquals(pos.getTo(), cityA);
        assertEquals(pos.getFrom(), cityB);
        assertEquals(pos.getDistance(), totalDistance-distance);
        
        // Negative tests
        /** Distance below 0 */
        assertEquals(neg.getTo(), cityB);
        assertEquals(neg.getFrom(), cityA);
        assertEquals(neg.getDistance(), -1);
        neg.turnAround();
        assertEquals(neg.getTo(), cityA);
        assertEquals(neg.getFrom(), cityB);
        assertEquals(neg.getDistance(), 0);
        
        /** Same two cities */
        assertTrue(same.getTo()==same.getFrom());
        assertEquals(same.getDistance(), 0);
        same.turnAround();
        assertTrue(same.getTo()==same.getFrom());
        assertEquals(same.getDistance(), 0);
        
        assertTrue(same2.getTo()==same.getFrom());
        assertTrue(same2.getDistance() > 0);
        same2.turnAround();
        assertTrue(same2.getTo()==same.getFrom());
        assertTrue(same2.getDistance() == 0);
    }
}
