
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        MotorcycleClub club = new MotorcycleClub("Bikers Haven");
        Biker b1 = new Biker("Ozzy Osbourne", 2, false);
        Biker b2 = new Biker("Jimmy Holdem", 0, false);
        Biker b3 = new Biker("Carl Hendrix", 2, true);
        Biker b4 = new Biker("John Smith", 4, false);
        Biker b5 = new Biker("John Doe", 5, true);
        club.add(b1);
        club.add(b2);
        club.add(b3);
        club.add(b4);
        club.add(b5);
        //System.out.println(club.leastRespectedBiker());
        //System.out.println(club.readyBikers(2));
        club.printMotorcycleClub();
    }
}
