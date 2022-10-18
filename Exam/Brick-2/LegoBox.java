import java.util.*;
/**
 * Lav en beskrivelse af klassen LegoBox her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class LegoBox
{
    private String owner;
    private ArrayList<Brick> box;

    public LegoBox(String owner)
    {
        this.owner = owner;
        box = new ArrayList<Brick>();
    }

    public void add(Brick b) {
        box.add(b);
    }
    
    public int weight(String color) {
        int result = 0;
        for(Brick b : box) {
            if(b.getColor().equals(color)) {
                result += b.getNumber() * b.getWeight();
            }
        }
        return result;
    }
    
    public Brick heaviest() {
        Brick result = null;
        for(Brick b : box) {
            if(result == null || b.getNumber() * b.getWeight() > result.getNumber() * result.getWeight()) {
                result = b;
            }
        }
        return result;
    }
    
    public void printLegoBox() {
        System.out.println(owner);
        Collections.sort(box);
        for(Brick b : box) {
            System.out.println(b);
        }
    }
}
