import java.util.*;
/**
 * Lav en beskrivelse af klassen Shop her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Shop
{
    private String name;
    private ArrayList<Carpet> shop;

    public Shop(String name)
    {
        this.name = name;
        shop = new ArrayList<Carpet>();
    }

    public void add(Carpet c) {
        shop.add(c);
    }
    
    public ArrayList<Carpet> selection(int price) {
        ArrayList<Carpet> result = new ArrayList<Carpet>();
        for(Carpet c : shop) {
            if(c.getPrice() <= price) {
                result.add(c);
            }
        }
        return result;
    }
    
    public Carpet cheapest(String color) {
        Carpet result = null;
        for(Carpet c : shop) {
            if (c.getColor().equals(color)) {
                if(result == null || c.getPrice()/c.getLength() < result.getPrice()/result.getLength()) {
                    result = c;
                }
            }
        }
        return result;
    }
    
    public void printShop() {
        System.out.println(name);
        Collections.sort(shop);
        for(Carpet c : shop) {
            System.out.println(c);
        }
    }
}
