import java.util.*;
/**
 * Write a description of class MafiaCountry here.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class MafiaCountry extends Country
{
    /** The hashmap containing each of the cities and roads in the country. */
    private Map<City, List<Road>> network = new HashMap<>();
    
    /** The name of the country. */
    private String name;

    /**
     * Constructor for objects of class MafiaCountry
     */
    public MafiaCountry(String name, Map<City, List<Road>> network)
    {
        super(name, network);
        this.name = name;
        this.network = network;
    }

    /**
     * Calculates whether the player should receive or lose money, then
     * returns either the value the player should receive or lose.
     * @param value    The upper limit of the random number.
     * @return         A random number between [0,value], or 0. Or a randomized amount of lost money.
     */
    public int bonus(int value) {
        int risk = getGame().getSettings().getRisk();
        int rand = getGame().getRandom().nextInt(100)+1;
        return risk >= rand ? -getGame().getLoss() : super.bonus(value);
    }
}
