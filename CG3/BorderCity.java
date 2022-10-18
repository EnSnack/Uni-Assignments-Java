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
    /** The name of the current City. */
    private String name;
    
    /** The current value and the initial value of the current City. */
    private int value, initialValue;
    
    /** The country in which the current City resides in. */
    private Country country;
    
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
        this.name = name;
        this.value = value;
        this.initialValue = value;
        this.country = country;
    }
    
    /**
     * Gets the superclass' arrive method, then checks if the player is entering
     * from a different country than this city is located in.
     * If they are, calculate a toll based on the settings and remove that from the bonus.
     * Add the toll to the city's value.
     * @return   The bonus(-toll) for arriving in the current City.
     */
    public int arrive(Player p) {
        int n = super.arrive();
        if(!p.getCountryFrom().equals(country)) {
            double pc = getCountry().getGame().getSettings().getTollToBePaid()/100.0f;
            int v = (int)Math.floor(p.getMoney()*pc);
            changeValue(v);
            return n-v;
        }
        return n;
    }
}