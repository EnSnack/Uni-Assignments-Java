/**
 * Represents a city in a country.
 * The City can have a value which indicates how much the city is worth.
 *
 * @author Steffen W. Christensen
 * @version 8/11-2018 22:00, version 1.0
 */
public class City implements Comparable<City>
{
    private String name;
    private int value, initialValue;
    private Country country;

    /**
     * Constructor for the City object.
     */
    public City(String name, int value, Country country)
    {
        this.name = name;
        this.value = value;
        this.initialValue = value;
        this.country = country;
    }
    
    public void changeValue(int amount) {
        value += amount;
    }
    
    public Country getCountry() {
        return country;
    }

    public int getValue() {
        return value;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public String getName() {
        return name;
    }

    public void reset() {
        value = initialValue;
    }

    public int compareTo(City other) {
        return name.compareTo(other.name);
    }

    public int arrive() {
        int n = country.bonus(value);
        changeValue(-n);
        return n;
    }
}
