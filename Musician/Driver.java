
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private int x;

    /**
     * Konstruktør for objekter af klassen Driver
     */
    public Driver()
    {
        // initialiser instansvariable
        x = 0;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public static void exam()
    {
        Band band = new Band("Roller Stones");
        Musician m1 = new Musician("Steve Geordan", "Drums", 96);
        Musician m2 = new Musician("Jimi Lendrix", "Guitar", 79);
        Musician m3 = new Musician("Mikael Johnson", "Vocals", 83);
        Musician m4 = new Musician("Cliff Bortun", "Bass", 89);
        Musician m5 = new Musician("Jon Lennen", "Vocals", 95);
        band.add(m1);
        band.add(m2);
        band.add(m3);
        band.add(m4);
        band.add(m5);
        band.printBand();
    }
}
