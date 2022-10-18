/**
 * Represents a city in a country.
 * The City can have a value which indicates how much the city is worth.
 *
 * @author Steffen W. Christensen
 * @version 17/11-2018 17:00, version 1.1
 */
public class City implements Comparable<City>
{
    /** The name of the current City. */
    private String name;
    
    /** The current value and the initial value of the current City. */
    private int value, initialValue;
    
    /** The country in which the current City resides in. */
    private Country country;

    /**
     * Constructor for the City object.
     * @param name       The City's name.
     * @param value      The City's current and total value.
     * @param country    The Country the City is currently residing in.
     */
    public City(String name, int value, Country country)
    {
        this.name = name;
        this.value = value;
        this.initialValue = value;
        this.country = country;
    }
    
    // GET METHODS BELOW
    
    /**
     * Returns the current City's country,
     * for example, "country1".
     * @return   The City's country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Returns the current City's current value,
     * for example, "25".
     * @return   The City's current value.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns the current City's name,
     * for example, "City A".
     * @return   The City's name.
     */
    public String getName() {
        return name;
    }
    
    // GET METHODS END
    
    /**
     * Adds the amount onto the current City's value.
     * @param amount    Amount to be added onto value.
     */
    public void changeValue(int amount) {
        value += amount;
    }
    
    /**
     * Resets the current City's value to its initial value.
     */
    public void reset() {
        value = initialValue;
    }
    
    /**
     * Compares the name of two cities.
     * @return   Comparison of name.
     */
    public int compareTo(City other) {
        return name.compareTo(other.name);
    }
    
    /**
     * Returns the bonus for arriving in current City, then reduces
     * the current City's value by this bonus.
     * @return   The bonus for arriving in current City.
     */
    public int arrive() {
        int n = country.bonus(value);
        changeValue(-n);
        return n;
    }
}
