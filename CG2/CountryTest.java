import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
* The test class CountryTest.
*
 * @author  Steffen W. Christensen
 * @version 17/11-2018 17:00, version 1.1
*/
public class CountryTest
{
    private Game game;
    private Country country1, country2;
    private City cityA, cityB, cityC, cityD, cityE, cityF, cityG;
    private Map<City, List<Road>> network1, network2;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        game = new Game(0);
        game.getRandom().setSeed(0);
        network1 = new HashMap<>();
        network2 = new HashMap<>();

        // Create countries
        country1 = new Country("Country 1", network1);
        country2 = new Country("Country 2", network2);
        country1.setGame(game);
        country2.setGame(game);

        // Create Cities
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new City("City C", 40, country1);
        cityD = new City("City D", 100, country1);
        cityE = new City("City E", 50, country2);
        cityF = new City("City F", 90, country2);
        cityG = new City("City G", 70, country2);

        // Create road lists
        List<Road> roadsA = new ArrayList<Road>(),
        roadsB = new ArrayList<>(),
        roadsC = new ArrayList<>(),
        roadsD = new ArrayList<>(),
        roadsE = new ArrayList<>(),
        roadsF = new ArrayList<>(),
        roadsG = new ArrayList<>();

        network1.put(cityA, roadsA);
        network1.put(cityB, roadsB);
        network1.put(cityC, roadsC);
        network1.put(cityD, roadsD);
        network2.put(cityE, roadsE);
        network2.put(cityF, roadsF);
        network2.put(cityG, roadsG);

        // Create roads
        country1.addRoads(cityA, cityB, 4);
        country1.addRoads(cityA, cityC, 3);
        country1.addRoads(cityA, cityD, 5);
        country1.addRoads(cityB, cityD, 2);
        country1.addRoads(cityC, cityD, 2);
        country1.addRoads(cityC, cityE, 4);
        country1.addRoads(cityD, cityF, 3);
        country2.addRoads(cityE, cityC, 4);
        country2.addRoads(cityE, cityF, 2);
        country2.addRoads(cityE, cityG, 5);
        country2.addRoads(cityF, cityD, 3);
        country2.addRoads(cityF, cityG, 6);
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
     * Map<City, List<Road>> network.
     */
    @Test
    public void constructor() {
        assertEquals(country1.getName(), "Country 1");
        assertEquals(country1.getNetwork(), network1);
        assertEquals(country2.getName(), "Country 2");
        assertEquals(country2.getNetwork(), network2);
    }
    
    /**
     * Testing the getRoads() method.
     * We test:
     * That calling getRoads() with a city in the country gets the roads connected to that city.
     * That calling getRoads() with a city not in the same country, returns an empty list.
     * That calling getRoads() with a city with no roads, returns an empty list.
     */
    @Test
    public void getRoads() {
        // Positive tests
        ArrayList<Road> cityRoads = new ArrayList<>(country1.getRoads(cityA));
        assertTrue(cityRoads.size() > 0);
        for(int i=0;i<cityRoads.size();i++) {
            assertEquals(cityRoads.get(i).getFrom(), cityA);
        }
        cityRoads = new ArrayList<>(country2.getRoads(cityE));
        assertTrue(cityRoads.size() > 0);
        for(int i=0;i<cityRoads.size();i++) {
            assertEquals(cityRoads.get(i).getFrom(), cityE);
        }
        cityRoads = new ArrayList<>(country1.getRoads(cityE));
        assertEquals(cityRoads.size(), 0);
        
        // Negative tests
        cityRoads = new ArrayList<>(country1.getRoads(new City("City O", 70, country1)));
        assertEquals(cityRoads.size(), 0);
    }
    
    /**
     * Testing the getCities() method.
     * We test:
     * That calling getCities() returns all cities in the country correctly.
     * That calling getCities() on a country with no cities returns an empty list.
     */
    @Test
    public void getCities() {
        // Positive tests
        ArrayList<City> cities = new ArrayList<>(country1.getCities());
        assertEquals(cities.size(), 4);
        assertEquals(cities.get(0), cityA);
        cities = new ArrayList<>(country2.getCities());
        assertEquals(cities.size(), 3);
        assertEquals(cities.get(0), cityE);
        
        // Negative tests
        Country country3 = new Country("Country 3", null);
        cities = new ArrayList<>(country3.getCities());
        assertEquals(cities.size(), 0);
    }
    
    /**
     * Testing the getCity() method.
     * We test:
     * That calling getCity() with a city's name correctly returns the city object.
     * That calling getCity() without a correct city name returns null.
     * That calling getCity() with a city name from another country returns null.
     */
    @Test
    public void getCity() {
        // Positive tests
        assertEquals(country1.getCity("City A"), cityA);
        assertEquals(country2.getCity("City E"), cityE);
        assertEquals(country1.getCity("C"), null);
        assertEquals(country1.getCity("CityA"), null);
        assertEquals(country1.getCity(cityA.getName()), cityA);
        
        // Negative tests
        assertEquals(country2.getCity("City A"), null);
    }
    
    /**
     * Testing the reset() method.
     * We test:
     * That calling reset() correctly resets all cities' values in that country to their initial values.
     * That calling reset() does not change the values of any cities in a different country.
     */
    @Test
    public void reset() {
        // Positive tests
        cityA.arrive(); cityA.arrive(); cityA.arrive();
        cityE.arrive(); cityE.arrive(); cityE.arrive();
        int valueE = cityE.getValue();
        country1.reset();
        assertEquals(cityA.getValue(), 80);
        assertEquals(cityE.getValue(), valueE);
    }
    
    /**
     * Testing the bonus() method.
     * We test:
     * That calling bonus() with a valid value correctly calculates a random bonus value.
     * That calling bonus() with an invalid value correctly returns 0.
     */
    @Test
    public void bonus() {
        // Positive tests
        /** Value = 80 */
        for(int seed=0; seed<1000; seed++) {
            game.getRandom().setSeed(seed);
            int sum = 0;
            int value = 80;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<10000;i++) {
                int bonus = country1.bonus(value);
                assertTrue(0 <= bonus && bonus <= value);
                sum += bonus;
                values.add(bonus);
            }
            assertTrue(((value/2)-1)*10000 < sum && sum < ((value/2)+1)*10000);
            assertEquals(values.size(), value+1); // +1, because values starts at 0.
        }
        
        /** Value = 1 */
        for(int seed=0; seed<1000; seed++) {
            game.getRandom().setSeed(seed);
            int sum = 0;
            int value = 1;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<10000;i++) {
                int bonus = country1.bonus(value);
                assertTrue(0 <= bonus && bonus <= value);
                sum += bonus;
                values.add(bonus);
            }
            assertTrue(((value/2)+0.25)*10000 < sum && sum < ((value/2)+1)*10000);
            assertEquals(values.size(), value+1);
        }
        
        // Negative tests
        /** Value = 0 */
        for(int seed=0; seed<1000; seed++) {
            game.getRandom().setSeed(seed);
            int sum = 0;
            int value = 0;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<10000;i++) {
                int bonus = country1.bonus(value);
                assertTrue(0 <= bonus && bonus <= value);
                sum += bonus;
                values.add(bonus);
            }
            assertEquals(sum, 0);
            assertEquals(values.size(), value+1);
        }
        
        /** Value = -5 */
        for(int seed=0; seed<1000; seed++) {
            game.getRandom().setSeed(seed);
            int sum = 0;
            int value = -5;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<10000;i++) {
                int bonus = country1.bonus(value);
                assertEquals(bonus, 0);
                sum += bonus;
                values.add(bonus);
            }
            assertEquals(sum, 0);
            assertEquals(values.size(), 1);
        }
    }
    
    /**
     * Testing the addRoads() method.
     * We test:
     * That calling addRoads() correctly adds a road between a and b of length 
     * if both a and b are inside the country.
     * That calling addRoads() correctly adds a road from a to b/b to a of length
     * if either a or b is inside the country.
     * That calling addRoads() correctly does nothing if neither a nor b is inside the country.
     */
    @Test
    public void addRoads() {
        // Positive tests
        ArrayList<Road> cityBRoads = new ArrayList<>(country1.getRoads(cityB));
        ArrayList<Road> cityCRoads = new ArrayList<>(country1.getRoads(cityC));
        ArrayList<Road> cityERoads = new ArrayList<>(country2.getRoads(cityE));
        
        /** a and b */
        assertEquals(cityBRoads.size(), 2);
        assertEquals(cityCRoads.size(), 3);
        country1.addRoads(cityB, cityC, 3);
        cityBRoads = new ArrayList<>(country1.getRoads(cityB));
        cityCRoads = new ArrayList<>(country1.getRoads(cityC));
        assertEquals(cityBRoads.size(), 3);
        assertEquals(cityCRoads.size(), 4);
        Road newRoad = cityBRoads.get(cityBRoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityB));
        assertTrue(newRoad.getTo().equals(cityC));
        newRoad = cityCRoads.get(cityCRoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityC));
        assertTrue(newRoad.getTo().equals(cityB));
        
        /** only a */
        assertEquals(cityBRoads.size(), 3);
        assertEquals(cityERoads.size(), 3);
        country1.addRoads(cityB, cityE, 3);
        cityBRoads = new ArrayList<>(country1.getRoads(cityB));
        cityERoads = new ArrayList<>(country2.getRoads(cityE));
        assertEquals(cityBRoads.size(), 4);
        assertEquals(cityERoads.size(), 3);
        newRoad = cityBRoads.get(cityBRoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityB));
        assertTrue(newRoad.getTo().equals(cityE));
        newRoad = cityERoads.get(cityERoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityE));
        assertFalse(newRoad.getTo().equals(cityB));
        
        /** only b */
        assertEquals(cityBRoads.size(), 4);
        assertEquals(cityERoads.size(), 3);
        country2.addRoads(cityE, cityB, 6);
        cityBRoads = new ArrayList<>(country1.getRoads(cityB));
        cityERoads = new ArrayList<>(country2.getRoads(cityE));
        assertEquals(cityBRoads.size(), 4);
        assertEquals(cityERoads.size(), 4);
        newRoad = cityERoads.get(cityERoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityE));
        assertTrue(newRoad.getTo().equals(cityB));
        newRoad = cityBRoads.get(cityBRoads.size()-1);
        assertTrue(newRoad.getFrom().equals(cityB));
        assertTrue(newRoad.getTo().equals(cityE));
        
        // Negative tests
        ArrayList<Road> cityFRoads = new ArrayList<>(country2.getRoads(cityF));
        assertEquals(cityERoads.size(), 4);
        assertEquals(cityFRoads.size(), 3);
        country1.addRoads(cityE, cityF, 3);
        cityERoads = new ArrayList<>(country2.getRoads(cityE));
        cityFRoads = new ArrayList<>(country2.getRoads(cityF));
        assertEquals(cityERoads.size(), 4);
        assertEquals(cityFRoads.size(), 3);
    }
    
    /**
     * Testing the position() method.
     * We test:
     * That calling position() no matter the country, will return the position of the city.
     */
    @Test
    public void position() {
        // Positive tests
        Position pos = country1.position(cityA);
        assertEquals(pos.getFrom(), cityA);
        assertEquals(pos.getTo(), cityA);
        assertEquals(pos.getDistance(), 0);
        pos = country1.position(cityG);
        assertEquals(pos.getFrom(), cityG);
        assertEquals(pos.getTo(), cityG);
        assertEquals(pos.getDistance(), 0);
        
        // Negative tests
        City cityO = new City("City O", 80, null);
        pos = country1.position(cityO);
        assertEquals(pos.getFrom(), cityO);
        assertEquals(pos.getTo(), cityO);
        assertEquals(pos.getDistance(), 0);
    }
    
    /**
     * Testing the readyToTravel() method.
     * We test:
     * That calling readyToTravel() with two valid cities, with a valid road between them
     * returns a position with a distance above 0.
     * That calling readyToTravel() with a from city outside of the country
     * returns a position with a distance equal to 0.
     * That calling readyToTravel() with from == to returns a position
     * with a distance equal to 0.
     * That calling readyToTravel() with two cities that have no direct road between them
     * returns a position with a distance equal to 0.
     */
    @Test
    public void readyToTravel() {
        // Positive tests
        Position pos = country1.readyToTravel(cityA, cityB);
        assertTrue(pos.getDistance() > 0);
        
        /** From outside of country */
        pos = country1.readyToTravel(cityE, cityB);
        assertFalse(pos.getDistance() > 0);
        assertTrue(pos.getTo().equals(pos.getFrom()));
        
        /** From == To */
        pos = country1.readyToTravel(cityA, cityA);
        assertFalse(pos.getDistance() > 0);
        assertTrue(pos.getTo().equals(pos.getFrom()));
        
        /** No direct path */
        pos = country1.readyToTravel(cityB, cityC);
        assertFalse(pos.getDistance() > 0);
        assertTrue(pos.getTo().equals(pos.getFrom()));
        
        pos = country1.readyToTravel(cityB, cityD);
        assertTrue(pos.getDistance() > 0);
    }
}
