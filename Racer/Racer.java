
/**
 * Lav en beskrivelse af klassen Racer her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Racer implements Comparable<Racer>
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private int year;
    private int topSpeed;

    /**
     * Konstruktør for objekter af klassen Racer
     */
    public Racer(String name, int year, int topSpeed)
    {
        this.name = name;
        this.year = year;
        this.topSpeed = topSpeed;
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
        return name + "-" + year + ", Top Speed: " + topSpeed + "km/h";
    }
    
    public int getTopSpeed()
    {
        return topSpeed;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int compareTo(Racer other) {
        if(year != other.year) {
            return year - other.year;
        }
        return name.compareTo(other.name);
    }
}
