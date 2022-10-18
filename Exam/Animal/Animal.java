
/**
 * Lav en beskrivelse af klassen Animal her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Animal implements Comparable<Animal>
{
    private String name;
    private int females;
    private int males;
    
    public Animal(String name, int females, int males) {
        this.name = name;
        this.females = females;
        this.males = males;
    }
    
    public String toString() {
        return name + ": " + females + " female and " + males + " male.";
    }
    
    public int getFemales() {
        return females;
    }
    
    public int getMales() {
        return males;
    }
    
    public int compareTo(Animal other) {
        if(females == other.females) {
            return other.males - males;
        }
        return other.females - females;
    }
}
