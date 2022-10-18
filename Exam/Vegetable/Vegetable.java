
/**
 * Lav en beskrivelse af klassen Vegetable her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Vegetable implements Comparable<Vegetable>
{
    private String name;
    private boolean organic;
    private int price;

    /**
     * Konstruktør for objekter af klassen Vegetable
     */
    public Vegetable(String name, boolean organic, int price)
    {
        this.name = name;
        this.organic = organic;
        this.price = price;
    }
    
    public String toString() {
        if(organic) return "Organic " + name + ", " + price + " cents";
        return "Non-organic " + name + ", " + price + " cents";
    }
    
    public int getPrice() {
        return price;
    }
    
    public boolean getOrganic() {
        return organic;
    }
    
    public String getName(){
        return name;
    }
    
    public int compareTo(Vegetable other) {
        if(name.equals(other.name)) {
            return other.price - price;
        }
        return name.compareTo(other.name);
    }
}
