import java.util.*;
/**
 * Lav en beskrivelse af klassen LegoBox her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class LegoBox
{
    private String name;
    private ArrayList<Brick> box;
    
    public LegoBox(String name) {
        this.name = name;
        box = new ArrayList<Brick>();
    }
    
    public void add(Brick b) {
        box.add(b);
    }
    
    public int area(String color) {
        int result = 0;
        for(Brick b : box) {
            if(b.getColor().equals(color)) {
                result += b.getNumber() * (b.getLength() * b.getWidth());
            }
        }
        return result;
    }
    
    public Brick most() {
        Brick result = null;
        for(Brick b : box) {
            if(result == null || b.getNumber() > result.getNumber()) {
                result = b;
            }
        }
        return result;
    }
    
    public void printLegoBox() {
        System.out.println(name);
        Collections.sort(box);
        for(Brick b : box) {
            System.out.println(b);
        }
    }
}
