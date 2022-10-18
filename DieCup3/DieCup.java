import java.util.ArrayList;
/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private ArrayList<Die> dies; //first die
    private int maxEyes;         //highest rolled combined dice
    private final int minDice = 0;     //minimum value a user can input for die index
    private final int minNoD  = 1;     //minimum number of dies requested

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int sides, int noOfDies) {
        //If the input number of dies is equal to or higher than 1
        if(noOfDies >= minNoD) {
            dies = new ArrayList<>(noOfDies);
            for(int i = 1; i <= noOfDies; i++) {
                dies.add(new Die(sides));
            }
            roll();
        } else {
            System.out.println("How would you ever roll no dies in a diecup?");
        }
    }

    /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        //Using for each loop to go through each die and rolling them
        for(Die die : dies) {
            die.roll();
        }
    }

    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes(int dice) {
        if(dice >= minDice && dice <= dies.size()) {
            if(dies.get(dice) != null) {
                return dies.get(dice).getEyes();
            }
        }
        else {
            System.out.println("Dice not found.");
        }
        return 0;
    }

    /**
     * Roll multiple times
     */
    public void multipleRolls(int noOfRolls) {
         if(noOfRolls < dies.size()) {
            double avgRoll = 0;
            for(Die die : dies) {
                die.roll();
            }
            for(int i = 1; i <= noOfRolls; i++) {
                System.out.println("Throw no. " + i + ": " + dies.get(i).getEyes());
                avgRoll += dies.get(i).getEyes();
            }
            avgRoll /= noOfRolls;
            System.out.println("Average no. of eyes: " + avgRoll);
        } else {
            System.out.println("You are rolling more dies than in the cup.");
        }
    }
}
