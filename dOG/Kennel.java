import java.util.*;
/**
 * Lav en beskrivelse af klassen Kennel her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Kennel
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private ArrayList<Dog> kennel = new ArrayList<>();
    private String owner;

    /**
     * Konstruktør for objekter af klassen Kennel
     */
    public Kennel(String owner)
    {
        // initialiser instansvariable
        this.owner = owner;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public void add(Dog d)
    {
        if(!kennel.contains(d)) {
            kennel.add(d);
        } else {
            System.out.println("Dog already a part of the kennel!");
        }
    }
    
    public void remove(Dog d)
    {
        if(kennel.contains(d)) {
            kennel.remove(d);
        } else {
            System.out.println("Dog is not a part of this kennel!");
        }
    }
    
    public int totalAgeOfPurebred()
    {
        int tAge = 0;
        for(Dog dog : kennel) {
            if(dog.getPurebred()) {
                tAge += dog.getAge();
            }
        }
        return tAge;
    }
    
    public Dog youngestOfBreed(String breed)
    {
        Dog result = null;
        for(Dog dog : kennel) {
            if(dog.getBreed() == breed) {
                if(result == null || dog.getAge() < result.getAge()) {
                    result = dog;
                }
            }
        }
        return result;
    }
    
    public void printKennel() {
        System.out.println(owner);
        Collections.sort(kennel);
        for(Dog d : kennel) {
            System.out.println(d);
        }
    }
}
