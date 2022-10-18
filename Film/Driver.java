
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        FilmCollection movs = new FilmCollection("My Movie Collection");
        Film f1 = new Film("The Room", "drama", 1, 14);
        Film f2 = new Film("Lion King", "animation", 8, 8);
        Film f3 = new Film("Scary Movie", "horror", 6, 18);
        Film f4 = new Film("Friday the 13th", "horror", 8, 14);
        Film f5 = new Film("Dramatic", "drama", 3, 8);
        f1.toString();
        f2.toString();
        f3.toString();
        f4.toString();
        f5.toString();
        movs.add(f1);
        movs.add(f2);
        movs.add(f3);
        movs.add(f4);
        movs.add(f5);
        movs.filmsOfGenre("animation");
        movs.bestFilmOfGenre("horror");
        movs.printFilmCollection(12);
    }
}
