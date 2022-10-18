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
    private ArrayList<Vegetable> shop;

    public Shop(String name)
    {
        this.name = name;
        shop = new ArrayList<Vegetable>();
    }
    
    public void add(Vegetable v) {
        shop.add(v);
    }
    
    public int totalPrice(boolean organic) {
        int result = 0;
        for(Vegetable v : shop) {
            if(v.getOrganic() == organic) {
                result += v.getPrice();
            }
        }
        return result;
    }
    
    public boolean organic() {
        int organic = 0;
        for(Vegetable v : shop) {
            if(v.getOrganic()) {
                organic++;
            }
            else {
                organic--;
            }
        }
        if(organic > 0) return true;
        return false;
    }
    
    public void printShop() {
        System.out.println(name);
        Collections.sort(shop);
        for(Vegetable v : shop) {
            System.out.println(v);
        }
    }
    
    public int totalPriceFunc(boolean organic) {
        return shop.stream()
                   .filter(t -> t.getOrganic() == organic)
                   .mapToInt(t -> t.getPrice())
                   .sum();
    }
    
    public void printShopFunc() {
        System.out.println(name);
        Collections.sort(shop, Comparator.comparing((Vegetable v) -> v.getName())
                                         .thenComparing((Vegetable v) -> -v.getPrice()));
        shop.forEach(v -> System.out.println(v));
    }
}
