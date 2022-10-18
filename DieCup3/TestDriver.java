
/**
 * Lav en beskrivelse af klassen TestDriver her.
 * 
 * @author (dit navn her
 * @version (versions nummer eller dato her)
 */
public class TestDriver
{
    private static DieCup dieCup, dieCup2, dieCup3, dieCup4;
    private static final int minSides = 2; //Same as the old versions.
    private static final int lowestRolls = 1; //This too.
    private static final int firstVal = 0; //Gets the first value in the arrayList

    /**
     * Konstruktør for objekter af klassen TestDriver
     */   
    public static void test(int noOfSides) {
        dieCup = new DieCup(noOfSides,lowestRolls);
        System.out.println(dieCup.getEyes(firstVal));
    }

    public static void testMultiple(int noOfSides, int noOfRolls) {
        dieCup = new DieCup(noOfSides, noOfRolls+lowestRolls);
        dieCup.multipleRolls(noOfRolls);
    }

    public static void compareDieCups(int s1, int s2, int s3, int s4, int noOfRolls) {
        if(s1 >= minSides && s2 >= minSides && s3 >= minSides && s4 >= minSides && noOfRolls >= lowestRolls) {
            dieCup     = new DieCup(s1, noOfRolls);
            dieCup2    = new DieCup(s2, noOfRolls);
            dieCup3    = new DieCup(s3, noOfRolls);
            dieCup4    = new DieCup(s4, noOfRolls);
            int oneWin, twoWin;
            oneWin = twoWin = 0;
            for(int i = 1; i <= noOfRolls; i++) {
                dieCup.roll();
                dieCup2.roll();
                dieCup3.roll();
                dieCup4.roll();
                int DieCupRoll  = dieCup.getEyes(firstVal);
                int DieCup2Roll = dieCup2.getEyes(firstVal);
                int DieCup3Roll = dieCup3.getEyes(firstVal);
                int DieCup4Roll = dieCup4.getEyes(firstVal);
                int Die1Roll = DieCupRoll+DieCup2Roll;
                int Die2Roll = DieCup3Roll+DieCup4Roll;
                //I made these variables just so the if statement looks better
                //they are essentially just dieCup.getEyes(firstVal)+dieCup2.getEyes(firstVal) boiled down into
                //one variable.
                if(Die1Roll > Die2Roll) {oneWin++;}
                else if(Die1Roll < Die2Roll) {twoWin++;}
            }
            System.out.println("Diecup 1 with " + s1 + " and " + s2 + " sides is highest: " + oneWin);
            System.out.println("Diecup 2 with " + s3 + " and " + s4 + " sides is highest: " + twoWin);
            //changed this to remove same variable
            System.out.println("Same score in both: " + (int)(noOfRolls-(oneWin+twoWin)));
        } else {
            System.out.println("Please input valid values.");
        }
    }
}
