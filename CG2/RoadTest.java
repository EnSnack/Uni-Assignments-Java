import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class RoadTest.
 *
 * @author  Steffen W. Christensen
 * @version 17/11-2018 17:00, version 1.1
 */
public class RoadTest
{
    private City cityA, cityB, cityC;
    private Road roadA, roadB, roadC;
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
        cityC = new City("City C", 40, null);
        
        // Create roads
        roadA = new Road(cityA, cityB, 4);
        roadB = new Road(cityB, cityC, 3);
        roadC = new Road(cityA, cityC, -2);
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
     * City from, City to.
     * int length.
     */
    @Test
    public void constructor() {
        assertEquals(roadA.getFrom(), cityA);
        assertEquals(roadA.getTo(), cityB);
        assertEquals(roadA.getLength(), 4);
    }
    
    /**
     * Testing the compareTo() method.
     * We test:
     * Whether we are correctly comparing the roads that should be lower in the comparison.
     * If comparing a road to itself it should successfully return zero.
     * That calling compareTo() with a newly created Road successfully returns its correct "position".
     */
    @Test
    public void compareTo() {
        // Positive tests
        assertTrue(roadA.compareTo(roadB) < 0);
        assertTrue(roadB.compareTo(roadC) > 0);
        assertTrue(roadC.compareTo(roadA) > 0);
        Road roadD = new Road(cityC, cityA, 3);
        assertTrue(roadD.compareTo(roadA) > 0);
        assertEquals(roadA.compareTo(roadA), 0);
    }
}
