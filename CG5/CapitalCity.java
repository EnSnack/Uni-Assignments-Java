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
    /**
     * Constructor for objects of class CapitalCity
     */
    public CapitalCity(String name, int value, Country country)
    {
        super(name, value, country);
    }

    /**
     * Picks a random number, if the number is right, expenses will be paid on top of the bonus.
     * @return   The bonus-expenses(-toll) for arriving in the current City.
     */
    public int arrive(Player p) {      
        int n = super.arrive(p);
        Random r = getCountry().getGame().getRandom();
        int rand = r.nextInt((p.getMoney()+n)+1);
        changeValue(rand);
        return n-rand;
    }
}
