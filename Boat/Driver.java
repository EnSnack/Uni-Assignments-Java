
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public static void exam()
    {
        Marina marina = new Marina("Østerstrand");
        Boat b1 = new Boat("Marie", 400000, false);
        Boat b2 = new Boat("Speedy", 20000, true);
        Boat b3 = new Boat("Traveler", 50000, true);
        Boat b4 = new Boat("Swifty", 50000, false);
        Boat b5 = new Boat("Jona", 100000, false);
        marina.add(b1);
        marina.add(b2);
        marina.add(b3);
        marina.add(b4);
        marina.add(b5);
        /*System.out.println(marina.cheaperThanAndForSale(30000));
        System.out.println(marina.mostValuable());*/
        marina.printBoats();
        
    }
}
