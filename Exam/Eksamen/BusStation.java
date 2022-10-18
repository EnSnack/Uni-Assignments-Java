import java.util.*;
import java.util.stream.*;
/**
 * Write a description of class BusStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusStation
{
    // instance variables - replace the example below with your own
    private String city;
    private ArrayList<Bus> busStation;

    /**
     * Constructor for objects of class BusStation
     */
    public BusStation(String city)
    {
        this.city = city;
        busStation = new ArrayList<Bus>();
    }
    
    void addBus(Bus b) {
        busStation.add(b);
    }
    
    public int cheapBusses(int maxPrice) {
        int result = 0;
        for(Bus b : busStation) {
            if(b.getPrice() <= maxPrice) {
                result++;
            }
        }
        return result;
    }
    
    public Bus cheapBus(String departure) {
        Bus result = null;
        int price = Integer.MAX_VALUE;
        for(Bus b : busStation) {
            if(result == null || b.getDeparture().equals(departure) && b.getDestination().equals(city)) {
                if(b.getPrice() < price) {
                    price = b.getPrice();
                    result = b;
                }
            }
        }
        return result;
    }
    
    public void printBusStation() {
        System.out.println(city);
        Collections.sort(busStation);
        for(Bus b : busStation) {
            System.out.println(b);
        }
    }
    
    public int totalPrice(String destination) {
        return busStation.stream()
                         .filter(b -> b.getDeparture().equals(city))
                         .filter(b -> b.getDestination().equals(destination))
                         .mapToInt(b -> b.getPrice())
                         .sum();
    }
    
    public Optional<Bus> findBus(int min, int max) {
        return busStation.stream()
                         .filter(b -> b.getPrice() >= min && b.getPrice() <= max)
                         .findFirst();
    }
}
