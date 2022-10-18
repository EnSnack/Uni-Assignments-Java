/**
 * Represents a Road connected by two cities.
 * A Road object is one-directional, meaning you can have a Road between from A to B
 * without having a Road from B to A.
 *
 * @author Steffen W. Christensen
 * @version 8/11-2018 22:00, version 1.0
 */
public class Road implements Comparable<Road>
{
    private City from, to;
    private int length;

    /**
     * Constructor for the Road object.
     */
    public Road(City from, City to, int length)
    {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public int getLength() {
        return length;
    }

    public int compareTo(Road other) {
        return from.equals(other.from) ? to.compareTo(other.to) : from.compareTo(other.from);
    }
}
