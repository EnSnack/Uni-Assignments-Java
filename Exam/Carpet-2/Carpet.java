
/**
 * Lav en beskrivelse af klassen Carpet her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Carpet implements Comparable<Carpet>
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String color;
    private String material;
    private int price;

    public Carpet(String color, String material, int price)
    {
        this.color = color;
        this.material = material;
        this.price = price;
    }
    
    public String toString() {
        return color + " " + material + ": " + price + " kr.";
    }
    
    public String getMaterial() {
        return material;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getColor() {
        return color;
    }
    
    public int compareTo(Carpet other) {
        if(material.equals(other.material)) {
            return price - other.price;
        }
        return material.compareTo(other.material);
    }
}
