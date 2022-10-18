
/**
 * Lav en beskrivelse af klassen Tool her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Tool implements Comparable<Tool>
{
    private String name;
    private boolean electric;
    private int price;

    public Tool(String name, boolean electric, int price)
    {
        this.name = name;
        this.electric = electric;
        this.price = price;
    }

    public String toString() {
        if(electric) {
            return "Electric " + name + ": " + price + " kr.";
        }
        return "Manual " + name + ": " + price + " kr.";
    }
    
    public boolean getElectric() {
        return electric;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public int compareTo(Tool other) {
        if(price == other.price) {
            return name.compareTo(other.name);
        }
        return price - other.price;
    }
}
