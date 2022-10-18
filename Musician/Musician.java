
/**
 * Lav en beskrivelse af klassen Musician her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Musician
{
    private String name;
    private String instrument;
    private int skillLevel;

    /**
     * Konstruktør for objekter af klassen Musician
     */
    public Musician(String name, String instrument, int skillLevel)
    {
        this.name = name;
        this.instrument = instrument;
        this.skillLevel = skillLevel;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public String toString()
    {
        // indsæt din egen kode her
        return name + ", " + instrument + " (Skill level: " + skillLevel + ")";
    }
    
    public int getSkillLevel() {
        return skillLevel;
    }
    
    public String getInstrument() {
        return instrument;
    }
    
    public String getName() {
        return name;
    }
}
