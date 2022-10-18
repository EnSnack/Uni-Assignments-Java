import java.util.*;
import java.util.stream.Collectors;
/**
 * Lav en beskrivelse af klassen FilmCollection her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class FilmCollection
{
    String owner;
    ArrayList<Film> movies;

    /**
     * Konstruktør for objekter af klassen FilmCollection
     */
    public FilmCollection(String owner)
    {
        this.owner = owner;
        movies = new ArrayList<Film>();
    }
    
    public void add(Film f) {
        movies.add(f);
    }
    
    public void remove(Film f) {
        movies.remove(f);
    }
    
    public Film filmsOfGenre(String genre) {
        Film result = null;
        for(Film f : movies) {
            if(result == null || f.getGenre().equals(genre)) {
                result = f;
            }
        }
        return result;
    }
    
    public Optional<Film> bestFilmOfGenre(String genre) { 
        return movies.stream()
                     .filter(f -> f.getGenre().equals(genre))
                     .max(Comparator.comparing(f -> f.getScore()));
    }
    
    public void printFilmCollection(int age) {
        System.out.println(owner);
        Collections.sort(movies, Comparator.comparing((Film f) -> f.getGenre())
                                           .thenComparing((Film f) -> f.getScore()));
        movies.stream()
              .filter(f -> f.getAgeLimit() > age)
              .collect(Collectors.toList())
              .forEach(f -> System.out.println(f));
    }
}
