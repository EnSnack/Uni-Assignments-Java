// import class for generation of random numbers
import java.util.Random;
/**
 * This class models a Die (terning)
 * 
 * @author Kurt Jensen
 * @version 2017-01-05
 */
public class Die {
    private Random random;      //used for generation of random numbers
    private int eyes;           //number of eyes shown
    private int diceRoll   = 6; //for if statement in multiple rolls
    private int lowestRoll = 1; //for if statement in multiple rolls

    /**
     * Constructor for Die objects
     */
    public Die() {
        //First we make the random function be a new random number
        random = new Random();
        //Time to roll our die.
        roll();
    }

    /**
     * Obtain a new number of eyes for this die
     */
    public void roll() {
        //We roll a set of eyes, making diceRoll and lowestRoll a variable
        //allows us to quickly change how the roll will happen above.
        eyes = random.nextInt(diceRoll)+lowestRoll;
        //Time to return these eyes!
        getEyes();
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        //Return these eyes!
        return eyes;
    }
}
