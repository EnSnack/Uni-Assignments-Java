
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        Shop shop = new Shop("Carpet Store");
        Carpet c1 = new Carpet("grey", 3, 250);
        Carpet c2 = new Carpet("yellow", 4, 300);
        Carpet c3 = new Carpet("red", 2, 250);
        Carpet c4 = new Carpet("grey", 5, 100);
        Carpet c5 = new Carpet("orange", 4, 500);
        
        System.out.println("Stringify: ");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c5.toString());
        
        shop.add(c1);
        shop.add(c2);
        shop.add(c3);
        shop.add(c4);
        shop.add(c5);
        
        System.out.println("Tæpper der højst koster 250: ");
        System.out.println(shop.selection(250));
        
        System.out.println("Billigste grå tæppe: ");
        System.out.println(shop.cheapest("grey"));
        
        shop.printShop();
    }
}
