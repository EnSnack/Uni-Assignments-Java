import java.util.*;
import java.util.stream.*;
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
    
    public int totalPrice(String material) {
        int result = 0;
        for(Carpet c : shop) {
            if(c.getMaterial().equals(material)) {
                result += c.getPrice();
            }
        }
        return result;
    }
    
    public ArrayList<Carpet> selection(String col, String mat) {
        ArrayList<Carpet> result = new ArrayList<Carpet>();
        for(Carpet c : shop) {
            if(c.getColor().equals(col) && c.getMaterial().equals(mat)) {
                result.add(c);
            }
        }
        return result;
    }
    
    public List<Carpet> selectionF(String col, String mat) {
        return shop.stream()
                   .filter(c -> c.getColor().equals(col))
                   .filter(c -> c.getMaterial().equals(mat))
                   .collect(Collectors.toList());
    }
    
    public void printShop() {
        System.out.println(name);
        Collections.sort(shop);
        for(Carpet c : shop) {
            System.out.println(c);
        }
    }
    
    public void printFShop() {
        System.out.println(name);
        Collections.sort(shop, Comparator.comparing((Carpet c) -> c.getMaterial())
                                         .thenComparing((Carpet c) -> c.getPrice()));
        shop.forEach(c -> System.out.println(c));
    }
}
