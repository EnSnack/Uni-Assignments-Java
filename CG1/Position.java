/**
 * Represents the current position of any valid player.
 * A Position's distance can be zero, in this case, the Position is in the from town.
 *
 * @author Steffen W. Christensen
 * @version 8/11-2018 22:00, version 1.0
 */
public class Position
{
    private City from, to;
    private int distance, total;

    /**
     * Constructor for the Position object.
     */
    public Position(City from, City to, int distance)
    {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.total = distance;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int getTotal() {
        return total;
    }

    public boolean hasArrived() {
        return distance == 0;
    }

    public boolean move() {
        if(distance > 0) {
            distance--;
            return true;            
        }
        return false;
    }

    public void turnAround() {
        City temp = to;
        to = from;
        from = temp;
        distance = total-distance;
    }
}
