
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
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public static void exam()
    {
        // indsæt din egen kode her
        Kennel k = new Kennel("Jill Johnson");
        Dog d1 = new Dog("Fido", "German Shepherd", true, 4);
        Dog d2 = new Dog("Fella", "Chihuahua", false, 3);
        Dog d3 = new Dog("Hockey", "Great Dane", true, 8);
        Dog d4 = new Dog("Tom", "Great Dane", false, 3);
        Dog d5 = new Dog("Dun", "Retriever", true, 6);
        /*System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
        System.out.println(d4.toString());
        System.out.println(d5.toString());*/
        k.add(d1);
        k.add(d2);
        k.add(d3);
        k.add(d4);
        k.add(d5);
        //System.out.println(k.totalAgeOfPurebred());
        //System.out.println(k.youngestOfBreed("Great Dane"));
        k.printKennel();
    }
}
