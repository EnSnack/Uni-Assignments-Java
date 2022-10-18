
/**
 * Lav en beskrivelse af klassen Dog her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Dog implements Comparable<Dog>
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private String breed;
    private boolean purebred;
    private int age;

    /**
     * Konstruktør for objekter af klassen Dog
     */
    public Dog(String name, String breed, boolean purebred, int age)
    {
        this.name = name;
        this.breed = breed;
        this.purebred = purebred;
        this.age = age;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public String toString()
    {
        if(purebred) {
            return age + " year old purebred " + breed + " named " + name;
        } else {
            return age + " year old " + breed + " named " + name;
        }
    }
    
    public boolean getPurebred() {
        return purebred;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public int compareTo(Dog other) {
        if(breed.equals(other.breed)) {
            return age - other.age;
        }
        return breed.compareTo(other.breed);
    }
}
