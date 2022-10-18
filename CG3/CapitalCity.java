import java.util.*;
/**
 * Represents the capital city of the given country.
 * Arriving at this city will require expenses paid, entering from a different
 * country will also require a toll.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class CapitalCity extends BorderCity
{
    /** The name of the current City. */
    private String name;
    
    /** The current value and the initial value of the current City. */
    private int value, initialValue;
    
    /** The country in which the current City resides in. */
    private Country country;

    /**
     * Constructor for objects of class CapitalCity
     */
    public CapitalCity(String name, int value, Country country)
    {
        super(name, value, country);
        this.name = name;
        this.value = value;
        this.initialValue = value;
        this.country = country;
    }

    /**
     * Gets the superclass' arrive method, then calculates a random number
     * between [0,money] where money is the player's current money.
     * Subtract this from the bonus and add it to the city's value.
     * @return   The bonus-expenses(-toll) for arriving in the current City.
     */
    public int arrive(Player p) {      
        int n = super.arrive(p);
        Random r = country.getGame().getRandom();
        int rand = r.nextInt((p.getMoney()+n)+1);
        changeValue(rand);
        return n-rand;
    }
}
