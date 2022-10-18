import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class MafiaCountryTest.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class MafiaCountryTest
{
    private Game game;
    private Country country1, country2;
    private Map<City, List<Road>> network1;
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
        Map<City, List<Road>> network1 = new HashMap<>();

        // Create countries
        country1 = new Country("Country 1", network1);
        country2 = new MafiaCountry("Country 2", null);
        country1.setGame(game);
        country2.setGame(game);
    }

    /**
     * Testing the instance variables in the constructor.
     * We test:
     * String name.
     * Map<City, List<Road>> network.
     */
    @Test
    public void constructor() {
        assertEquals(country2.getName(), "Country 2");
        assertEquals(country2.getNetwork(), null);
    }

    /**
     * Testing the bonus() method.
     * We test:
     * That calling bonus() with a value has a chance to subtract money rather than giving.
     * That calling bonus() with a value should have a money stealing risk of 20%.
     * That calling bonus() with a value should steal on average around €30.
     * That calling bonus() can have all values in the range of [10,50].
     */
    @Test
    public void bonus() {
        // Positive tests
        /** Bonus of 80 */
        int risk = game.getSettings().getRisk();
        for(int seed=0;seed<1000;seed++) {
            game.getRandom().setSeed(seed);
            int robs = 0;
            int loss = 0;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<50000;i++) {
                int bonus = country2.bonus(80);
                if(bonus < 0) {
                    robs++;
                    assertTrue(bonus <= -10 && bonus >= -50);
                    loss -= bonus;
                    values.add(-bonus);
                }
            }
            assertTrue((robs/49999.0f)*100 > risk-1 && (robs/49999.0f)*100 < risk+1);
            assertTrue((loss/robs) >= 29 && (loss/robs) <= 30);
            assertEquals(values.size(), (50-10)+1);
        }

        /** Bonus of 0 */
        for(int seed=0;seed<1000;seed++) {
            game.getRandom().setSeed(seed);
            int robs = 0;
            int loss = 0;
            Set<Integer> values = new HashSet<>();
            for(int i=0;i<50000;i++) {
                int bonus = country2.bonus(0);
                if(bonus < 0) {
                    robs++;
                    assertTrue(bonus <= -10 && bonus >= -50);
                    loss -= bonus;
                    values.add(-bonus);
                }
            }
            assertTrue((robs/49999.0f)*100 > risk-1 && (robs/49999.0f)*100 < risk+1);
            assertTrue((loss/robs) >= 29 && (loss/robs) <= 30);
            assertEquals(values.size(), (50-10)+1);
        }
    }

    /**
     * Testing the bonus() method.
     * We test:
     * That calling bonus() will only subtract money INSIDE a mafia country.
     */
    @Test
    public void bonusOnlyMafia() {
        // Positive tests
        for(int seed=0;seed<1000;seed++) {
            game.getRandom().setSeed(seed);
            int c1robs = 0;
            int c2robs = 0;
            for(int i=0;i<25000;i++) {
                int bonus = country1.bonus(80);
                if(bonus < 0) c1robs++;
            }
            for(int i=0;i<25000;i++) {
                int bonus = country2.bonus(80);
                if(bonus < 0) c2robs++;
            }
            assertEquals(c1robs, 0);
            assertTrue(c2robs > c1robs);
        }
    }
}
