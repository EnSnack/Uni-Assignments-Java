
/**
 * Lav en beskrivelse af klassen Boat her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Boat implements Comparable<Boat>
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private int value;
    private boolean forSale;

    /**
     * Konstruktør for objekter af klassen Boat
     */
    public Boat(String name, int value, boolean forSale)
    {
        this.name    = name;
        this.value   = value;
        this.forSale = forSale;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public String toString()
    {
        if(!forSale) {
            return name + ": " + value + " kr., not for sale";
        } else {
            return name + ": " + value + " kr., for sale";
        }
    }
    
    public int getValue()
    {
        return value;
    }
  
    public String getName()
    {
        return name;
    }
    
    public boolean getForSale()
    {
        return forSale;
    }
    
    public int compareTo(Boat other) {
        if(value == other.value) {
            return name.compareTo(other.name);
        }
        return other.value - value;
    }
}
