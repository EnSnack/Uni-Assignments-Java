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
    private int sides;       //my sides
    private final int minSides = 1;//minimum number rolled on a random die
    private final int minRoll = 2; //minimum number of sides needed to roll

    /**
     * Constructor for Die objects
     */
    public Die(int noOfSides) {
        if(noOfSides >= minRoll) {
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
        eyes = random.nextInt(sides)+minSides;
        getEyes();
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return eyes;
    }
}
