
/**
 * Lav en beskrivelse af klassen Biker her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Biker
{
    String name;
    int bulletWounds;
    boolean hospitalized;
    
    public Biker(String name, int bulletWounds, boolean hospitalized) {
        this.name = name;
        this.bulletWounds = bulletWounds;
        this.hospitalized = hospitalized;
    }
    
    public String toString() {
        return "Name: " + name + ", Wounds: " + bulletWounds + ", Hospitalized: " + hospitalized;
    }
    
    public int getBulletWounds() {
        return bulletWounds;
    }
    
    public boolean getHospitalized() {
        return hospitalized;
    }
    
    public String getName() {
        return name;
    }
}
