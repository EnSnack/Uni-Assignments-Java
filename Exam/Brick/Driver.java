
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        LegoBox box = new LegoBox("Colourful");
        Brick b1 = new Brick("Green", 25, 30, 10);
        Brick b2 = new Brick("Red", 10, 20, 20);
        Brick b3 = new Brick("Yellow", 15, 10, 10);
        Brick b4 = new Brick("Green", 17, 40, 30);
        Brick b5 = new Brick("Orange", 25, 20, 30);
        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(b4);
        box.add(b5);
        System.out.println(box.area("Green"));
        box.printLegoBox();
    }
}
