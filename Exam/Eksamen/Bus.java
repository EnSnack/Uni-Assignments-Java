
/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus implements Comparable<Bus>
{
    private String departure;
    private String destination;
    private int price;

    /**
     * Constructor for objects of class Bus
     */
    public Bus(String departure, String destination, int price)
    {
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }
    
    public String toString() {
        return departure + " --> " + destination + ", Price: " + price + " DKK";
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int compareTo(Bus other) {
        if(price == other.price) {
            return destination.compareTo(other.destination);
        }
        return other.price - price;
    }
}
