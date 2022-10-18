
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        Zoo zoo = new Zoo("Odense Zoo");
        Animal a1 = new Animal("Elephant", 17, 24);
        Animal a2 = new Animal("Jaguar", 3,0);
        Animal a3 = new Animal("Penguin", 25,24);
        Animal a4 = new Animal("Giraffe", 3,2);
        Animal a5 = new Animal("Lemur", 17,15);
        zoo.add(a1);
        zoo.add(a2);
        zoo.add(a3);
        zoo.add(a4);
        zoo.add(a5);
        System.out.println(zoo.animals());
        System.out.println(zoo.largestPopulation());
        zoo.printZoo();
    }
}
