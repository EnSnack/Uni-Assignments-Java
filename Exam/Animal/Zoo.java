import java.util.*;
/**
 * Lav en beskrivelse af klassen Zoo her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Zoo
{
    private String name;
    private ArrayList<Animal> zoo;
    
    public Zoo(String name) {
        zoo = new ArrayList<Animal>();
        this.name = name;
    }
    
    public void add(Animal a) {
        zoo.add(a);
    }
    
    public int animals() {
        int result = 0;
        for(Animal a : zoo) {
            if(a.getFemales() > 0 && a.getMales() > 0) {
                result += a.getFemales() + a.getMales();
            }
        }
        return result;
    }
    
    public Animal largestPopulation() {
        Animal result = null;
        for(Animal a : zoo) {
            if(result == null || a.getFemales() + a.getMales() > result.getFemales() + result.getMales()) {
                result = a;
            }
        }
        return result;
    }
    
    public void printZoo() {
        System.out.println(name);
        Collections.sort(zoo);
        for(Animal a : zoo) {
            System.out.println(a);
        }
    }
}
