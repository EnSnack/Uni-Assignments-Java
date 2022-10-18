import java.util.*;
/**
 * Represents a whole country including all the cities and roads in it.
 * The cities and roads are represented by a HashMap.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class Country
{
    /** The hashmap containing each of the cities and roads in the country. */
    private Map<City, List<Road>> network = new HashMap<>();

    /** The name of the country. */
    private String name;

    /** The current game object. */
    private Game game;

    /**
     * Constructor for the Country object.
     * @param name       The country's name.
     * @param network    The network of Cities and Roads in this Country.
     */
    public Country(String name, Map<City, List<Road>> network)
    {
        this.name = name;
        this.network = network;
    }

    // GET METHODS BELOW

    /**
     * Returns the current Country's name,
     * for example, "Country 1".
     * @return   The Country's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current Country's network,
     * this includes all Cities and Roads in the Country.
     * @return   The Country's network.
     */
    public Map<City, List<Road>> getNetwork() {
        return network;
    }

    /**
     * Returns the current Country's roads based on the parameter,
     * this means if the City can be found, all Roads starting from City c is returned.
     * If the City cannot be found, an empty list is returned.
     * @param c    The City to lookup roads from.
     * @return     The Roads starting from City c, or empty list.
     */
    public List<Road> getRoads(City c) {
        return network.containsKey(c) ? network.get(c) : new ArrayList<>();
    }

    /**
     * Returns a sorted list of all cities in the Country.
     * If no cities are to be found, an empty list is returned instead.
     * @return    All cities in the country, or empty list.
     */
    public List<City> getCities() {
        if(network != null && network.keySet().size() > 0) {
            //network.keySet() returns a list of all keys in the network.
            List<City> list = new ArrayList<City>(network.keySet());
            Collections.sort(list);
            return list;
        }
        return new ArrayList<>();
    }

    /**
     * Finds a city among the list of cities by looking for its name.
     * If no such city can be found, null is returned instead.
     * @param name    The name of the city to be found.
     * @return        The city that was found, or null.
     */
    public City getCity(String name) {
        City result = null;
        for(City city : getCities()) {
            if(city.getName().equals(name)) { 
                result = city;
            }
        }
        return result;
    }

    // GET METHODS END

    /**
     * Resets all cities' values in the Country to their initial values.
     */
    public void reset() {
        for(City city : getCities()) {
            city.reset();
        }
    }

    /**
     * Returns the bonus value a player should receive when arriving to the city,
     * as long as the given value is above 0.
     * @param value    The upper limit of the random number.
     * @return         A random number between [0,value], or 0.
     */
    public int bonus(int value) {
        if(value > 0) {
            Random r = game.getRandom();
            return r.nextInt(value+1);
        }
        return 0;
    }

    /**
     * Adds a road, or multiple roads, from City a to City b of length.
     * If a and b are in same country, create a Road object from and to a and b.
     * If only a or b is in the country, create a one-direction Road object starting from which one is in the country.
     * @param a         The first City object.
     * @param b         The second City object.
     * @param length    Length between the two cities.
     */
    public void addRoads(City a, City b, int length) {
        if(network.containsKey(a)) network.get(a).add(new Road(a,b,length));
        if(network.containsKey(b)) network.get(b).add(new Road(b,a,length));
    }

    /**
     * Returns a new Position object of a specific city.
     * @param city    City to make a position of.
     * @return        Position object of city.
     */
    public Position position(City city) {
        return new Position(city, city, 0);
    }

    /**
     * Checks if the player is currently ready to travel between from and to.
     * It does this through two if statements:
     * Is the City in the country and is there a road between the two?
     * @param from    City to travel from.
     * @param to      City to travel to.
     * @return        New Position object between from and to.
     */
    public Position readyToTravel(City from, City to) {
        if(from != null && to != null && from.getCountry().getName().equals(name)) {
            List<Road> list = getRoads(from);
            for(Road road : list) {
                if(road.getTo().equals(to)) {
                    //No need to check if our road is also connected to To
                    //as these are only From's roads.
                    return new Position(from, to, road.getLength());
                }
            }
        }
        return position(from);
    }

    /**
     * Checks if this country's name is equal to the given country's name.
     * If the same object is given, automatically return true.
     * @param other    Country to compare with.
     * @return        Boolean that determines if it is the same country or not.
     */
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Country)) return false;
        Country other = (Country) obj;
        return this.name.equals(other.name);
    }

    /**
     * Calculates the hashCode of this country object using the name of the object.
     * @return        The unique hashCode of this country object.
     */
    public int hashCode() {
        int result = 17;
        result = 37 * result + name.hashCode();
        return result;
    }

    // GAME SPECIFIC METHODS

    /**
     * Returns the current game object,
     * @return   The current Game object.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the current game object.
     * @param   Game object to set.
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
