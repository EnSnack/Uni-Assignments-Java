
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        Shop shop = new Shop("Funny Carpets");
        Carpet c1 = new Carpet("black", "wool", 1250);
        Carpet c2 = new Carpet("white", "wool", 1000);
        Carpet c3 = new Carpet("red", "cotton", 1500);
        Carpet c4 = new Carpet("black", "plastic", 900);
        Carpet c5 = new Carpet("yellow", "silicon", 1000);
        
        System.out.println("Stringify : ");
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
        
        System.out.println("Pris for uld tæpper: ");
        System.out.println(shop.totalPrice("wool"));
        
        System.out.println("Liste over sorte uld tæpper: ");
        System.out.println(shop.selection("black", "wool"));
        
        shop.printShop();
        
        System.out.println("Liste over sorte uld tæpper: ");
        System.out.println(shop.selectionF("black", "wool"));
        
        shop.printFShop();
    }
}
