
/**
 * Lav en beskrivelse af klassen Tool her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Tool implements Comparable<Tool>
{
    private String name;
    private int price;
    private int weight;

    public Tool(String name, int price, int weight)
    {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    
    public String toString() {
        return name + ": " + price + " kr., " + weight + " gram";
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public int compareTo(Tool other) {
        if(weight == other.weight) {
            return price - other.price;
        }
        return weight - other.weight;
    }
}
