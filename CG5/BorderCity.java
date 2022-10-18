import java.util.*;
/**
 * Represents a city that borders another country.
 * Arriving at this city from another country will require a toll.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class BorderCity extends City
{  
    /**
     * Constructor for the BorderCity object. Uses the parameters to send to the
     * superclass.
     * @param name       The City's name.
     * @param value      The City's current and total value.
     * @param country    The Country the City is currently residing in.
     */
    public BorderCity(String name, int value, Country country)
    {
        super(name, value, country);
    }
    
    /**
     * If the player enters from a different country, it reduces their bonus by a toll set in the options.
     * @return   The bonus(-toll) for arriving in the current City.
     */
    public int arrive(Player p) {
        int n = super.arrive();
        if(!p.getCountryFrom().equals(getCountry())) {
            double pc = getCountry().getGame().getSettings().getTollToBePaid()/100.0f;
            int v = (int)Math.floor(p.getMoney()*pc);
            changeValue(v);
            return n-v;
        }
        return n;
    }
}