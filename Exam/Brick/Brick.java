
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
    private int length;
    private int width;
    
    public Brick(String color, int number, int length, int width)
    {
        this.color = color;
        this.number = number;
        this.length = length;
        this.width = width;
    }
    
    public String toString() {
        return number + " " +  color + " (" + length + " mm x " + width + " mm )";
    }
    
    public String getColor() {
        return color;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int compareTo(Brick other) {
        if(color.equals(other.color)) {
            return number - other.number;
        }
        return color.compareTo(other.color);
    }
}
