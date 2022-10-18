
/**
 * Lav en beskrivelse af klassen Brick her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Brick implements Comparable<Brick>
{
    private String color;
    private int number;
    private int weight;

    public Brick(String color, int number, int weight)
    {
        this.color = color;
        this.number = number;
        this.weight = weight;
    }
    
    public String toString() {
        return number + " " + color + " (" + weight + " gram each)";
    }
    
    public String getColor() {
        return color;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int compareTo(Brick other) {
        if(number == other.number) {
            return color.compareTo(other.color);
        }
        return other.number - number;
    }
}
