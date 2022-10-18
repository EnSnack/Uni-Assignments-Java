/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private Die d1, d2;          //first & second die (we can initiate both in same statement)
    private int maxEyes;         //highest rolled combined dice
    private int lowestRolls = 1; //for if statement in multiple rolls to remove magic numbers
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup() {
        /**
         * Here we initiate both dies, we haven't generalized it very much:
         * We force two dies and number of sides are not a choice, however
         * this will be changed in a future version.
         */
        d1 = new Die();
        d2 = new Die();
        /**
         * Time to roll()! We could have removed this part and forced the
         * user to use the roll function through BlueJ themselves, however
         * it seems far easier to automatically roll in the beginning
         * without forcing user input, so that the user may immediately see
         * feedback.
         * 
         * I realized from the lecture that Kurt didn't expect these automatic
         * feedbacks, but that's how I liked to do it, and it is not
         * difficult to remove.
         */
        roll();
    }
    
     /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        //We simply call the roll() method in the Die class in both
        //individual dies.
        d1.roll();
        d2.roll();
        /**
         * I personally normally don't like longer if functions like this
         * d1.getEyes() + d2.getEyes() could easily have been changed to
         * a variable in the roll method here itself, however for simplicity
         * I have chosen to keep it like this.
         * On that note, I was unsure whether getMaxEyes should have this
         * if statement to check if the eyes were higher than the current
         * maxEyes and then replace them, else just return them if not.
         * If needed, this very solution is easily implemented.
         * The reason I have added getMaxEyes here, is so that whenever the
         * dies have rolled, it will immediately check if they are the max
         * rolled eyes.
         */
        if(d1.getEyes() + d2.getEyes() > maxEyes) {
            getMaxEyes();
        }
    }
    
     /**
      * Get the current max amount of rolled eyes
      */
    public int getMaxEyes() {
        /**
         * I'm not a big fan of this written code, I believe the choice of
         * the previous comment would have made this piece of code better
         * since it would have:
         * 1. Allowed me to make maxEyes a local variable exlusive to
         * getMaxEyes, since maxEyes will only be used in this very method.
         * 2. Allowed me to lessen the amount of code in roll() and perhaps
         * even in getMaxEyes.
         * 3. Make getMaxEyes more of a GET and less of a SET (as it
         * currently is)
         */
        //Initiate both d1E (d1 Eyes) and d2E (d2 Eyes)
        int d1E = d1.getEyes();
        int d2E = d2.getEyes();
        //maxEyes would be d1E's value plus d2E's value.
        maxEyes = d1E + d2E;   
        //return this value to the user.
        return maxEyes;
    }
    
     /**
      * Resets the current max amount of rolled eyes
      */
    public void resetMaxEyes() {
        //We just reset maxEyes to set it back to 0.
        maxEyes = 0;
    }
    
    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        //Alike to getMaxEyes, we just return d1's eyes plus d2's eyes.
        int d1E = d1.getEyes();
        int d2E = d2.getEyes();
        return d1E+d2E;
    }
    
    /**
     * Roll multiple times (Extra assignment)
     */
    public void multipleRolls(int noOfRolls) {
        //First we check to make sure the chosen amount of rolls is bigger
        //than 1.
        if(noOfRolls >= lowestRolls) {
            /**
             * My original submission made use of arrays, however I realized
             * that one problem I have is that I love to use hard ways to
             * solve a problem (I've learnt from pEuler and leetcode), so
             * I have attempted to code this whole thing doing it as basic
             * as I can.
             */
            //We initiate a double that calculates average.
            //I believe a float would be perfectly fine here due to the
            //smaller size, however I will do a double just for certainty.
            double avgRoll = 0;
            //Go through every roll with a for-loop, I start at 1 because
            //I want to make it as easily usable for the user so they don't
            //have to type 9 to roll 10 dies.
            for(int i = 1; i <= noOfRolls; i++) {
                //Roll both dies.
                d1.roll();
                d2.roll();
                //Get their values.
                int d1E = d1.getEyes();
                int d2E = d2.getEyes();
                //Calculate total value.
                int val = d1E + d2E;
                //Add that to average roll.
                avgRoll += val;
                //Show what the value was including the throw number.
                System.out.println("Throw no. " + i + ": " + val);
            }
            //Take the avgRoll and divide by noOfRolls
            // /= just means divide by and set, it's basically:
            //avgRoll/noOfRolls;
            avgRoll /= noOfRolls;
            //Print average once it is fully done.
            System.out.println("Average no. of eyes: " + avgRoll);
        } else {
            //Print an error should the user not input a large enough number.
            System.out.println("Please input a number larger than or equal to 1");
        }
    }
}
/**
 * Opgave 4:
 * 2: 1+1 - 1/36 [2.78%] (1/36)
 * 3: 1+2, 2+1 - 2/36 [5.56%] (3/36)
 * 4: 2+2, 1+3, 3+1 - 3/36 [8.33%] (6/36)
 * 5: 2+3, 3+2, 4+1, 1+4 - 4/36 [11.11%] (10/36)
 * 6: 3+3, 4+2, 2+4, 5+1, 1+5 - 5/36 [13.89%] (15/36)
 * 7: 6+1, 1+6, 2+5, 5+2, 3+4, 4+3 - 6/36 [16.67%] (21/36)
 * 8: 4+4, 3+5, 5+3, 6+2, 2+6 - 5/36 [13.89%] (26/36)
 * 9: 5+4, 4+5, 6+3, 3+6 - 4/36 [11.11%] (30/36)
 * 10: 5+5, 6+4, 4+6 - 3/36 [8.33%] (33/36)
 * 11: 6+5, 5+6 - 2/36 [5.56%] (35/36)
 * 12: 6+6 - 1/36 [2.78%] (36/36)
 * Alle summe samlet: 252
 * 252/36 = 7
 * Derfor er gennemsnittet 7.
 * -> 20 rul [3+6,3+1,4+1,1+1,1+4,4+1,3+6,6+6,2+1,2+2,6+6,6+5,3+2,2+1,4+6,2+4,3+6,1+6,4+6,2+2]
 * Alle summe samlet: 135
 * 135/20 = 6.75
 * 3.57% under det forventede gennemsnit.
 */

/**
 * Opgave 5 (Fortsat)
 * -> 1000 rul, gennemsnit: 7.033
 * 0.46% over det forventede gennemsnit.
 */
