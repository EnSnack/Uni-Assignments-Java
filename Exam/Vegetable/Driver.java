
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        Shop shop = new Shop("Fresh Vegetables");
        Vegetable v1 = new Vegetable("carrots", true, 200);
        Vegetable v2 = new Vegetable("carrots", false, 160);
        Vegetable v3 = new Vegetable("cucumbers", true, 175);
        Vegetable v4 = new Vegetable("tomatoes", false, 150);
        Vegetable v5 = new Vegetable("potatoes", true, 175);
        
        System.out.println("*** Opgave 1-3 ***");
        System.out.println("Stringify : ");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
        System.out.println(v4.toString());
        System.out.println(v5.toString());
        
        System.out.println("*** Opgave 4-8 ***");
        shop.add(v1);
        shop.add(v2);
        shop.add(v3);
        shop.add(v4);
        shop.add(v5);
        
        System.out.println("Samlede pris af organiske vare: ");
        System.out.println(shop.totalPrice(true));
        
        System.out.println("*** Opgave 9 ***");
        System.out.println("Organisk butik: ");
        System.out.println(shop.organic());
        
        System.out.println("*** Opgave 10 ***");
        shop.printShop();
        
        System.out.println("*** Opgave 11 ***");
        System.out.println("Samlede pris af organiske vare: ");
        System.out.println(shop.totalPriceFunc(true));
        
        System.out.println("*** Opgave 12 ***");
        shop.printShopFunc();
    }
}
