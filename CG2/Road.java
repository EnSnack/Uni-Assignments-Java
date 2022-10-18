/**
 * Represents a Road connected by two cities.
 * A Road object is one-directional, meaning you can have a Road between from A to B
 * without having a Road from B to A.
 *
 * @author Steffen W. Christensen
 * @version 17/11-2018 17:00, version 1.1
 */
public class Road implements Comparable<Road>
{
    /** The cities this Road is connected to. */
    private City from, to;
    
    /** The length of this Road. */
    private int length;

    /**
     * Constructor for the Road object.
     * @param from     City where the road starts.
     * @param to       City where the road ends.
     * @param length   Length of this road.
     */
    public Road(City from, City to, int length)
    {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    // GET METHODS BELOW
    
    /**
     * Returns the current Road's start (city),
     * for example, "cityA".
     * @return   The Road's start.
     */
    public City getFrom() {
        return from;
    }
    
    /**
     * Returns the current Road's destination (city),
     * for example, "cityB"
     * @return   The Road's destination.
     */
    public City getTo() {
        return to;
    }
    
    /**
     * Returns the length of the current road,
     * for example, "4".
     * @return   The Road's length.
     */
    public int getLength() {
        return length;
    }
    
    // GET METHODS END
    
    /**
     * Compares the start city, if start is the same, compares destination cities instead.
     * @return   Comparison of start or if needed destination.
     */
    public int compareTo(Road other) {
        return from.equals(other.from) ? to.compareTo(other.to) : from.compareTo(other.from);
    }
}
