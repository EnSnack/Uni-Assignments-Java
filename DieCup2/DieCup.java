/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private Die d1, d2;          //first & second die
    private int maxEyes;         //highest rolled combined dice

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int sides1, int sides2) {
        //Initiate the dies, but also initiate them with the sides of each die as an input.
        d1 = new Die(sides1);
        d2 = new Die(sides2);
        //Roll 
        roll();
    }

    /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        //The same as the original die cup, same issue.
        d1.roll();
        d2.roll();
        if(getEyes() > maxEyes) {
            maxEyes = getEyes();
        }
    }

    /**
     * Get the current max amount of rolled eyes
     */
    public int getMaxEyes() {
        //Changed this to a GET/return only
        return maxEyes;
    }

    /**
     * Resets the current max amount of rolled eyes
     */
    public void resetMaxEyes() {
        //Also nothing changed.
        maxEyes = 0;
    }

    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        //Same here.
        return d1.getEyes()+d2.getEyes();
    }

    /**
     * Roll multiple times
     */
    public void multipleRolls(int noOfRolls) {
        //Nothing different here either, it makes use of the sides by default. So left unchanged.
        if(noOfRolls >= 1) {
            double avgRoll = 0;
            for(int i = 1; i <= noOfRolls; i++) {
                d1.roll();
                d2.roll();
                avgRoll += getEyes();
                System.out.println("Throw no. " + i + ": " + getEyes());
            }
            avgRoll /= noOfRolls;
            System.out.println("Average no. of eyes: " + avgRoll);
        } else {
            System.out.println("Please input a number larger than or equal to 1");
        }
    }
}
