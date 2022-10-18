import java.util.*;
/**
 * Lav en beskrivelse af klassen FormulaOne her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class FormulaOne
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private ArrayList<Racer> formulaOne;

    /**
     * Konstruktør for objekter af klassen FormulaOne
     */
    public FormulaOne(String name)
    {
        formulaOne = new ArrayList<Racer>();
        this.name = name;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public void add(Racer r)
    {
        if(!formulaOne.contains(r)) {
            formulaOne.add(r);
        } else {
            System.out.println("This racer is already added!");
        }
    }

    public void remove(Racer r)
    {
        if(formulaOne.contains(r)) {
            formulaOne.remove(r);
        } else {
            System.out.println("This racer was not found!");
        }
    }

    public int averageTopSpeed() {
        int avgSpeed = 0;
        for(Racer racers : formulaOne) {
            avgSpeed += racers.getTopSpeed();
        }
        return avgSpeed /= formulaOne.size();
    }

    public Racer fastestRacer() {
        Racer fastest = null;
        if(formulaOne.size() > 0) {
            for(Racer racers : formulaOne) {
                if(fastest == null || fastest.getTopSpeed() > racers.getTopSpeed()) {
                    fastest = racers;
                }
            }
        }
        return fastest;
    }

    public void printFormulaOne() {
        System.out.println(name);
        Collections.sort(formulaOne);
        for(Racer racer : formulaOne) {
            System.out.println(racer);
        }
    }
}
