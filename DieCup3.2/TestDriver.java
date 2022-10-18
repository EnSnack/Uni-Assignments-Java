import java.util.ArrayList;
/**
 * Lav en beskrivelse af klassen TestDriver her.
 * 
 * @author (dit navn her
 * @version (versions nummer eller dato her)
 */
public class TestDriver
{
    private static DieCup dieCup, dieCup2, dieCup3, dieCup4;
    private static int minSides = 2;
    private static int lowestRolls = 1;
    private static int firstVal = 0;

    /**
     * Konstruktør for objekter af klassen TestDriver
     */   
    public static void test4638(int noOfRolls) {
        ArrayList<Integer> newDies = new ArrayList<>();
        newDies.add(4);
        newDies.add(6);
        newDies.add(3);
        newDies.add(8);
        dieCup = new DieCup(newDies);
        double avgVal = 0;
        for(int i = 1; i <= noOfRolls; i++) {
            avgVal += dieCup.getEyes();
            System.out.println("Throw no. " + i + ": " + dieCup.getEyes());
            dieCup.roll();
        }
        avgVal /= noOfRolls;
        System.out.println("Average no. of eyes: " + avgVal);
    }

    public static ArrayList createArrayList(int digits) {
        int length = (int)(Math.log10(digits)+1); //get the length of digits
        ArrayList<Integer> digitsList = new ArrayList<>(length); //make an arraylist of that length
        if(length >= 2) {
            int squared = (int)(Math.pow(10, length-1)); //this is a type of counter
            while(length > 0) {
                digitsList.add((digits/squared)%10); //add each digit to our arraylist
                squared/=10;
                length--;
            }
        } else {
            if(digits >= 0) {
                System.out.println(digits);
            }
        }
        return digitsList;
    }

    public static void compareDieCups(int dc1, int dc2, int noOfRolls) {
        DieCup dCup1 = new DieCup(createArrayList(dc1));
        DieCup dCup2 = new DieCup(createArrayList(dc2));
        int oneWin, twoWin;
        oneWin = twoWin = 0;
        for(int i = 1; i <= noOfRolls; i++) {
            dCup1.roll();
            dCup2.roll();
            int dc1E = dCup1.getEyes();
            int dc2E = dCup2.getEyes();
            if(dc1E > dc2E) {oneWin++;}
            else if(dc1E < dc2E) {twoWin++;}
        }
        System.out.println("Diecup 1 with " + createArrayList(dc1) + " sides is highest: " + oneWin);
        System.out.println("Diecup 2 with " + createArrayList(dc2) + " sides is highest: " + twoWin);
        System.out.println("Same score in both: " + (int)(noOfRolls-(oneWin+twoWin)));
    }
}
