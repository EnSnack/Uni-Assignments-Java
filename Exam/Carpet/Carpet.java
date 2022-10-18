
/**
 * Lav en beskrivelse af klassen Carpet her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Carpet implements Comparable<Carpet>
{
    private String color;
    private int length;
    private int price;

    /**
     * Konstruktør for objekter af klassen Carpet
     */
    public Carpet(String color, int length, int price)
    {
        this.color = color;
        this.length = length;
        this.price = price;
    }
    
    public String toString() {
       return color + " carpet, " + length + " meter of " + price + " kr.";
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getLength() {
        return length;
    }
    
    public String getColor() {
        return color;
    }
    
    public int compareTo(Carpet other) {
        if(price/length == other.price/other.length) {
            return other.length - length;
        }
        return (price/length) - (other.price/other.length);
    }
}
