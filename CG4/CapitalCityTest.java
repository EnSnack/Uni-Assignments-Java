import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class CapitalCityTest.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class CapitalCityTest
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
        cityD = new CapitalCity("City D", 100, country1);
        cityE = new CapitalCity("City E", 50, country2);
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
        assertEquals(cityD.getName(), "City D");
        assertEquals(cityD.getValue(), 100);
        assertEquals(cityD.getCountry(), country1);
    }

    /**
     * Testing the arrive() method.
     * We test:
     * That calling arrive() will correctly require a toll if coming from outside the country.
     * That calling arrive() will correctly require a random amount in expenses.
     * That the toll and expenses are both correctly added to the city's value.
     */
    @Test
    public void arriveToll() {
       // Positive Tests
       /** Normal (€250) */
       for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityC, cityE, 0), 250);
            int initialValue = cityE.getValue();
            game.getRandom().setSeed(i);
            int bonus = country2.bonus(cityE.getValue());
            int toll = (int)Math.floor(250*(game.getSettings().getTollToBePaid()/100.0f));
            int used = game.getRandom().nextInt((250 + (bonus-toll))+1);
            game.getRandom().setSeed(i);
            int arrive = cityE.arrive(player);
            assertEquals(arrive, bonus-toll-used);
            assertEquals(cityE.getValue(), initialValue+toll+used-bonus);
            cityE.reset();
       }
       
       /** Normal (€0) */
       for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityC, cityE, 0), 0);
            int initialValue = cityE.getValue();
            game.getRandom().setSeed(i);
            int bonus = country2.bonus(cityE.getValue());
            int toll = (int)Math.floor(0*(game.getSettings().getTollToBePaid()/100.0f));
            int used = game.getRandom().nextInt((0 + (bonus-toll))+1);
            game.getRandom().setSeed(i);
            int arrive = cityE.arrive(player);
            assertEquals(arrive, bonus-toll-used);
            assertEquals(cityE.getValue(), initialValue+toll+used-bonus);
            cityE.reset();
       }
    }
    
    /**
     * Testing the arrive() method.
     * We test:
     * That calling arrive() will not require a toll if coming from inside the country.
     * That calling arrive() will still require expenses paid for arriving in the capital.
     * That calling arrive() in this situation will correctly add the expenses to the city's value
     * and return a bonus with the expenses subtracted from it.
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
            int used = game.getRandom().nextInt((250 + bonus)+1);
            game.getRandom().setSeed(i);
            int arrive = cityD.arrive(player);
            assertEquals(arrive, bonus-used);
            assertEquals(cityD.getValue(), initialValue+used-bonus);
            cityD.reset();
       }
       
       /** Normal (€0) */
       for(int i=0;i<1000;i++) {
            Player player = new Player(new Position(cityC, cityD, 0), 0);
            int initialValue = cityD.getValue();
            game.getRandom().setSeed(i);
            int bonus = country1.bonus(cityD.getValue());
            int used = game.getRandom().nextInt((0 + bonus)+1);
            game.getRandom().setSeed(i);
            int arrive = cityD.arrive(player);
            assertEquals(arrive, bonus-used);
            assertEquals(cityD.getValue(), initialValue+used-bonus);
            cityD.reset();
       }
    }
}
