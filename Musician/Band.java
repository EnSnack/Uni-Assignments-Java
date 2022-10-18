import java.util.*;
/**
 * Lav en beskrivelse af klassen Band her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Band
{
    private String name; //Name of band
    private ArrayList<Musician> band; //List of band members

    /**
     * Konstruktør for objekter af klassen Band
     */
    public Band(String name)
    {
        band = new ArrayList<Musician>();
        this.name = name;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public void add(Musician m)
    {
        if(!band.contains(m)) {
            band.add(m);
        } else {
            System.out.println("Musician is already a part of the band!");
        }
    }

    public void remove(Musician m)
    {
        if(band.contains(m)) {
            band.remove(m);
        } else {
            System.out.println("Musician is not in the band!");
        }
    }
    
    public int skilledMusicians(int level) {
        int amm = 0;
        if(level > 0 && level <= 100) {
            for(Musician musicians : band) {
                if(musicians.getSkillLevel() >= level) {
                    amm++;
                }
            }
        }
        return amm;
    }
    
    public Musician withInstrument(String instrument) {
        for(Musician musicians : band) {
            if(musicians.getInstrument() == instrument) {
                return musicians;
            }
        }
        return null;
    }

    public void printBand() {
        System.out.println(name);
        Collections.sort(band, new Comparator<Musician>() {
            public int compare(Musician m1, Musician m2) {
                if(m1.getInstrument() == m2.getInstrument()) {
                    return m1.getSkillLevel()-m2.getSkillLevel();
                }
                return m1.getInstrument().compareTo(m2.getInstrument());
            }
        });
        //Anden metode
        /*for(Musician m : band) {
            System.out.println(m);
        }*/
        System.out.println(band);
    }
   
}
