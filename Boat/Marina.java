import java.util.*;
/**
 * Lav en beskrivelse af klassen Marina her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Marina
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private ArrayList<Boat> marina;

    /**
     * Konstruktør for objekter af klassen Marina
     */
    public Marina(String name)
    {
        marina = new ArrayList<Boat>();
        this.name = name;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public void add(Boat b)
    {
        if(!marina.contains(b)) {
            marina.add(b);
        } else {
            System.out.println("This boat is already a part of this marina!");
        }
    }
    
    public void remove(Boat b)
    {
        if(marina.contains(b)) {
            marina.remove(b);
        } else {
            System.out.println("This boat is not a part of this marina!");
        }
    }
    
    public ArrayList<Boat> cheaperThanAndForSale(int t)
    {
        ArrayList<Boat> result = new ArrayList<Boat>();
        for(Boat boat : marina) {
            if(boat.getForSale() && boat.getValue() < t) {
                result.add(boat);
            }
        }
        return result;
    }
    
    public Boat mostValuable()
    {
        Boat result = null;
        for(Boat boat : marina) {
            if(result == null || boat.getValue() > result.getValue()) {
                result = boat;
            }
        }
        return result;
    }
    
    public void printBoats()
    {
        System.out.println(name);
        Collections.sort(marina);
        for(Boat b : marina) {
            System.out.println(b);
        }
    }
}
