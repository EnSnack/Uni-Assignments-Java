import java.io.Serializable;
import java.util.*;

/**
 * A log of a game that can be replayed in the game.
 * @author Steffen W. Christensen
 * @version 09/12-2018 19:00, version 1.3
 **/
public class Log implements Serializable {
    /** A hashmap of each choice made during the log */
    private Map<Integer, String> choices;
    
    /** The seed of this Log */
    private int seed;
    
    /** Settings object of this log */
    private Settings settings;
    
    /**
     * Constructor for the Log object.
     * @param seed       The Log's seed.
     * @param settings   The settings of the logs.
     */
    public Log(int seed, Settings settings){
        choices = new HashMap<>();
        this.seed = seed;
        this.settings = settings;
    }
    
    /**
     * Gets the seed of this log.
     * @return An integer representing the seed specific to this log.
     */
    public int getSeed(){
        return seed;
    }
    
    /**
     * Gets the settings of this log.
     * @return A Settings object representing the settings specific to this log.
     */
    public Settings getSettings(){
        return settings;
    }
      
    /**
     * Gets which city was clicked on at t time.
     * @param t    The time where a city was clicked.
     * @return The name of the city clicked on at this time.
     */
    public String getChoice(int t){
        return choices.get(t);
    }
    
    /**
     * Adds the given time and city to the list of choices.
     * @param t The current time.
     * @param c The city clicked on at 't' time.
     */
    public void add(int t, City c){
        choices.put(t, c.getName());
    }
}
