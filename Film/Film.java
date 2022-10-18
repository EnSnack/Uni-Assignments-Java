
/**
 * Lav en beskrivelse af klassen Film her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Film
{
    String title;
    String genre;
    int score;
    int ageLimit;
    
    public Film(String title, String genre, int score, int ageLimit) {
        this.title = title;
        this.genre = genre;
        this.score = score;
        this.ageLimit = ageLimit;
    }
    
    public String toString() {
        return title + ", " + genre + ", Score: " + score + ", Age Limit: " + ageLimit + " years.";
    }
    
    public String getGenre() {
        return genre;
    }

    public int getScore() {
        return score;
    }
    
    public int getAgeLimit() {
        return ageLimit;
    }
}
