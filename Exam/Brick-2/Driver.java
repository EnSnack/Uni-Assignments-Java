
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam()
    {
        LegoBox box = new LegoBox("Joachim Olsen");
        Brick b1 = new Brick("blue", 25, 4);
        Brick b2 = new Brick("green", 20, 5);
        Brick b3 = new Brick("yellow", 23, 4);
        Brick b4 = new Brick("blue", 18, 3);
        Brick b5 = new Brick("orange", 25, 6);
        System.out.println("Stringify: ");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println(b4.toString());
        System.out.println(b5.toString());
        
        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(b4);
        box.add(b5);
        
        System.out.println("Weight of Blue: ");
        System.out.println(box.weight("blue"));
        
        System.out.println("Heaviest in box: ");
        System.out.println(box.heaviest());
        
        box.printLegoBox();
    }
}
