
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private int x;

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public static void exam()
    {
        FormulaOne formulaOne = new FormulaOne("The Big Race");
        Racer r1 = new Racer("Ferrari", 1995, 180);
        Racer r2 = new Racer("Porsche", 2000, 160);
        Racer r3 = new Racer("Lamborghini", 1989, 195);
        Racer r4 = new Racer("Ferrari", 2000, 185);
        Racer r5 = new Racer("Porsche", 1990, 180);
        formulaOne.add(r1);
        formulaOne.add(r2);
        formulaOne.add(r3);
        formulaOne.add(r4);
        formulaOne.add(r5);
        /*System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());
        System.out.println(r5.toString());
        System.out.println(formulaOne.averageTopSpeed());
        System.out.println(formulaOne.fastestRacer());*/
        formulaOne.printFormulaOne();
    }
}
