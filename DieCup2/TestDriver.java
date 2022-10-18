
/**
 * Lav en beskrivelse af klassen TestDriver her.
 * 
 * @author (dit navn her
 * @version (versions nummer eller dato her)
 */
public class TestDriver
{
    private static DieCup DieCup, DieCup2; //Initiate both DieCups.
    private static final int minSides = 2; //for if statement to avoid magic numbers

    /**
     * Test a single roll
     */   
    public static void test(int sides1, int sides2) {
        //Make a new DieCup that has used sides and then print its eyes.
        DieCup = new DieCup(sides1, sides2);
        System.out.println(DieCup.getEyes());
    }

    /**
     * Test multiple rolls
     */  
    public static void testMultiple(int noOfRolls, int sides1, int sides2) {
        //Do the same as above but using a defined amount of rolls.
        DieCup = new DieCup(sides1, sides2);
        DieCup.multipleRolls(noOfRolls);
    }

    /**
     * Compare two die cups of chosen sides to each other
     */  
    public static void compareDieCups(int s1, int s2, int s3, int s4, int noOfRolls) {
        //First we check if the variables are alright.
        if(s1 >= minSides && s2 >= minSides && s3 >= minSides && s4 >= minSides && noOfRolls >= 1) {
            //Initiate our DieCups.
            DieCup     = new DieCup(s1, s2);
            DieCup2    = new DieCup(s3, s4);
            //Initiate our scores.
            int oneWin, twoWin, same;
            oneWin = twoWin = same = 0;
            for(int i = 1; i <= noOfRolls; i++) {
                DieCup.roll();
                DieCup2.roll();
                //Add one to 1 if they win, one to 2 if they win, else add one to same.
                if(DieCup.getEyes() > DieCup2.getEyes()) {oneWin++;}
                else if(DieCup.getEyes() < DieCup2.getEyes()) {twoWin++;}
                else {same++;}
            }
            //Once done, print out the scores.
            System.out.println("Diecup 1 with " + s1 + " and " + s2 + " sides is highest: " + oneWin);
            System.out.println("Diecup 2 with " + s3 + " and " + s4 + " sides is highest: " + twoWin);
            System.out.println("Same score in both: " + same);
        } else {
            System.out.println("Please input valid values.");
        }
    }
}
