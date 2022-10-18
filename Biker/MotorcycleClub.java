import java.util.*;
import java.util.stream.Collectors;
/**
 * Lav en beskrivelse af klassen MotorcycleClub her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class MotorcycleClub
{
    private String name;
    private ArrayList<Biker> club;
    
    public MotorcycleClub(String name) {
        club = new ArrayList<Biker>();
        this.name = name;
    }
    
    void add(Biker b) {
        club.add(b);
    }
    
    Biker leastRespectedBiker() {
        Biker result = null;
        for(Biker b : club) {
            if(result == null || result.getBulletWounds() > b.getBulletWounds()) {
                result = b;
            }
        }
        return result;
    }
    
    public List<Biker> readyBikers(int maxAmount) {
        return club.stream()
                   .filter(b -> !b.getHospitalized())
                   .limit(maxAmount)
                   .collect(Collectors.toList());
    }
    
    void printMotorcycleClub() {
        System.out.println(name);
        Collections.sort(club, Comparator.comparing((Biker b) -> b.getBulletWounds())
                                         .thenComparing((Biker b) -> b.getName()));
        club.forEach(b -> System.out.println(b));
    }
}
