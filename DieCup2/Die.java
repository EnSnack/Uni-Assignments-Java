// import class for generation of random numbers
import java.util.Random;
/**
 * This class models a Die (terning)
 * 
 * @author Kurt Jensen
 * @version 2017-01-05
 */
public class Die {
    private Random random;   //used for generation of random numbers
    private int eyes;        //number of eyes shown
    private int sides;       //number of sides rolled

    /**
     * Constructor for Die objects
     */
    public Die(int noOfSides) {
        //check if noOfSides is above or equal to 2
        if(noOfSides >= 2) {
            //Initiate random, sides and roll.
            random = new Random();
            sides = noOfSides;
            roll();
        } else {
            System.out.println("Please input a value equal to or higher than 2");
        }
    }

    /**
     * Obtain a new number of eyes for this die
     */
    public void roll() {
        //Roll a random number based on the sides, but keep a minimum of 1.
        eyes = random.nextInt(sides)+1;
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        //Return the eyes.
        return eyes;
    }
}
