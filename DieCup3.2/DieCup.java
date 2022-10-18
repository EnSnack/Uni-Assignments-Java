import java.util.ArrayList;
/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private ArrayList<Die> dies;       //first die
    private ArrayList<Integer> newDies;
    private int maxEyes;  //highest rolled combined dice
    private int minDice = 0;
    private int minNoD = 1;

    /**
     * Constructor for DieCup objects
     */
    public DieCup(ArrayList<Integer> newDies) {
        if(newDies.size() >= minNoD) {
            dies = new ArrayList<>(newDies.size());
            for(int i = 0; i < newDies.size(); i++) {
                dies.add(new Die(newDies.get(i)));
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
       for(Die die: dies) {
           die.roll();
        }
    }

    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        int val = 0;
        for(int i = 0; i < dies.size(); i++) {
            val+=dies.get(i).getEyes();
        }
        return val;
    }

    /**
     * Roll multiple times
     */
    public void multipleRolls(int noOfRolls) {
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
    }
}
