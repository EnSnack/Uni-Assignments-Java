
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void test() {
        BusStation busStation = new BusStation("Aarhus");
        Bus b1 = new Bus("Aarhus", "Odense", 120);
        Bus b2 = new Bus("Aarhus", "Fredericia", 75);
        Bus b3 = new Bus("Vejle", "Middelfart", 100);
        Bus b4 = new Bus("Kolding", "Aarhus", 120);
        Bus b5 = new Bus("Skanderborg", "Aarhus", 50);
        
        System.out.println("*** OPGAVE 1-3 ***");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println(b4.toString());
        System.out.println(b5.toString());
        
        System.out.println("*** OPGAVE 4-8 ***");
        busStation.addBus(b1);
        busStation.addBus(b2);
        busStation.addBus(b3);
        busStation.addBus(b4);
        busStation.addBus(b5);
        
        System.out.println("Antal busser der maks koster 110 DKK: ");
        System.out.println(busStation.cheapBusses(110));
        
        System.out.println("*** OPGAVE 9 ***");
        System.out.println("Billigste bus der starter i Skanderborg og slutter i Aarhus: ");
        System.out.println(busStation.cheapBus("Skanderborg"));
        
        System.out.println("*** OPGAVE 10 ***");
        busStation.printBusStation();
        
        System.out.println("*** OPGAVE 11 ***");
        System.out.println(busStation.totalPrice("Fredericia"));
        
        System.out.println("*** OPGAVE 12 ***");
        System.out.println("Første bus af buspris mellem 40 og 60 kroner: ");
        System.out.println(busStation.findBus(40, 60));
    }
}
