/**
 * Represents the current position of any valid player.
 * A Position's distance can be zero, in this case, the Position is in the from town.
 *
 * @author Steffen W. Christensen
 * @version 25/11-2018 19:00, version 1.2
 */
public class Position
{
    /** The towns the Position is currently inbetween.
        If from == to, the Position is in from.*/
    private City from, to;
    
    /** The current distance between from and to, including the total distance
        between from and to*/
    private int distance, total;

    /**
     * Constructor for the Position object.
     * @param from       City where the player started/opposite direction of which the player is walking.
     * @param to         City where the player is headed.
     * @param distance   Distance between these two cities.
     */
    public Position(City from, City to, int distance)
    {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.total = distance;
    }

    // GET METHODS BELOW
    
    /**
     * Returns the current Position's start city,
     * for example, "cityA".
     * @return   The Position's start.
     */
    public City getFrom() {
        return from;
    }
    
    /**
     * Returns the current Position's end city,
     * for example, "cityB".
     * @return   The Position's destination.
     */
    public City getTo() {
        return to;
    }
    
    /**
     * Returns the distance between Position and end city,
     * for example, "2".
     * @return   The Position's current distance.
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Returns the total distance of Road/between start and end city,
     * for example, "4".
     * @return   The Position's total distance.
     */
    public int getTotal() {
        return total;
    }
    
    // GET METHODS END
    
    /**
     * Returns boolean stating if the Position's distance is zero,
     * meaning the Position has arrived at his destination if true.
     * @return   Boolean stating if the Position has arrived.
     */
    public boolean hasArrived() {
        return distance == 0;
    }
    
    /**
     * Reduces distance by one and returns true if the Position can be moved,
     * meaning the Position will be moved one step closer to their target.
     * @return   Boolean stating if the Position has moved.
     */
    public boolean move() {
        if(distance > 0) {
            distance--;
            return true;            
        }
        return false;
    }
    
    /**
     * Swaps the start and destination cities, so that the player can
     * return to where they began. Also calculates new distance.
     */
    public void turnAround() {
        City temp = to; //Temporary City object for location swapping.
        to = from;
        from = temp;
        distance = total-distance;
    }
}
