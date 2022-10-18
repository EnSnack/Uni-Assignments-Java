/**
 * Represents a city in a country.
 * The City can have a value which indicates how much the city is worth.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
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
     * the current City's value by this bonus if above 0.
     * @return   The bonus for arriving in the current City.
     */
    public int arrive() {
        int n = country.bonus(value);
        if(n >= 0) changeValue(-n);
        return n;
    }
    
    /**
     * Automatically calls arrive() above, used only in the subclasses.
     * @return   The result from the arrive() method above.
     */
    public int arrive(Player p) {
        return arrive();
    }
    
    /**
     * Checks if this city's name and this city's country
     * is equal to the given city's name and the given city's country.
     * If the same object is given, automatically return true.
     * @param other    City to compare with.
     * @return        Boolean that determines if it is the same city or not.
     */
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }
    
    /**
     * Calculates the hashCode of this city object using a random number 
     * plussed with the country and name hashCode.
     * @return        The unique hashCode of this city object.
     */
    public int hashCode() {
        int result = 17;
        result = 37 * result + country.hashCode();
        result = 37 * result + name.hashCode();
        return result;
    }
}
