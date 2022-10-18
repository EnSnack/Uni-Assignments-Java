import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class BorderCityTest.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class BorderCityTest
{
    private Game game;
    private Country country1, country2;
    private City cityA, cityB, cityC, cityD, cityE, cityF, cityG;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        game = new Game(0);
        game.getRandom().setSeed(0);
        Map<City, List<Road>> network1 = new HashMap<>();
        Map<City, List<Road>> network2 = new HashMap<>();

        // Create countries
        country1 = new Country("Country 1", network1);
        country2 = new Country("Country 2", network2);
        country1.setGame(game);
        country2.setGame(game);

        // Create Cities
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new BorderCity("City C", 40, country1);
        cityD = new BorderCity("City D", 100, country1);
        cityE = new BorderCity("City E", 50, country2);
        cityF = new BorderCity("City F", 90, country2);
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
     * Testing the instance variables in the constructor.
     * We test:
     * String name.
     * int value, int initialValue.
     * Country country.
     */
    @Test
    public void constructor() {
        assertEquals(cityC.getName(), "City C");
        assertEquals(cityC.getValue(), 40);
        assertEquals(cityC.getCountry(), country1);
    }
    
    /**
     * Testing the arrive() method.
     * We test:
     * That calling arrive() will correctly require a toll if coming from outside the country.
     * That the toll is correctly added to the city's value.
     */
    @Test
    public void arriveToll() {
        // Positive Tests
        /** Normal (€250) */
        for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityE, cityC, 0), 250);
            int initialValue = cityC.getValue();
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityC.getValue());
            int toll = (int)Math.floor(250*(game.getSettings().getTollToBePaid()/100.0f));
            game.getRandom().setSeed(i);
            int arrive = cityC.arrive(player);
            assertEquals(arrive, bonus-toll);
            assertEquals(cityC.getValue(), (initialValue+toll)-bonus);
            cityC.reset();
        }
        
        /** Normal (€0) */
        for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityE, cityC, 0), 0);
            int initialValue = cityC.getValue();
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityC.getValue());
            int toll = (int)Math.floor(0*(game.getSettings().getTollToBePaid()/100.0f));
            game.getRandom().setSeed(i);
            int arrive = cityC.arrive(player);
            assertEquals(arrive, bonus-toll);
            assertEquals(cityC.getValue(), (initialValue+toll)-bonus);
            cityC.reset();
        }
    }
    
    /**
     * Testing the arrive() method.
     * We test:
     * That calling arrive() will not require a toll if coming from inside the country.
     * That calling arrive() in this situation will correctly do nothing different.
     */
    @Test
    public void arriveNoToll() {
        // Positive Tests
        /** Normal (€250) */
        for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityC, cityD, 0), 250);
            int initialValue = cityD.getValue();
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityD.getValue());
            game.getRandom().setSeed(i);
            int arrive = cityD.arrive(player);
            assertEquals(arrive, bonus);
            assertEquals(cityD.getValue(), initialValue-bonus);
            cityD.reset();
        }
        
        /** Normal (€0) */
        for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityC, cityD, 0), 0);
            int initialValue = cityD.getValue();
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityD.getValue());
            game.getRandom().setSeed(i);
            int arrive = cityD.arrive(player);
            assertEquals(arrive, bonus);
            assertEquals(cityD.getValue(), initialValue-bonus);
            cityD.reset();
        }
    }
}
