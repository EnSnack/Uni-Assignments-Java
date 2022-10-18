import java.util.*;
/**
 * Represents a whole country including all the cities and roads in it.
 * The cities and roads are represented by a HashMap.
 *
 * @author Steffen W. Christensen
 * @version 8/11-2018 22:00, version 1.0
 */
public class Country
{
    private Map<City, List<Road>> network = new HashMap<>();
    private String name;
    private Game game;

    /**
     * Constructor for the Country object.
     */
    public Country(String name, Map<City, List<Road>> network)
    {
        this.name = name;
        this.network = network;
    }

    public String getName() {
        return name;
    }

    public Map<City, List<Road>> getNetwork() {
        return network;
    }

    public List<Road> getRoads(City c) {
        return network.containsKey(c) ? network.get(c) : new ArrayList<>();
    }

    public List<City> getCities() {
        if(network != null && network.keySet().size() > 0) {
            List<City> list = new ArrayList<City>(network.keySet());
            Collections.sort(list);
            return list;
        }
        return new ArrayList<>();
    }

    public City getCity(String name) {
        City result = null;
        for(City city : getCities()) {
            if(city.getName().equals(name)) { 
                result = city;
            }
        }
        return result;
    }

    public void reset() {
        for(City city : getCities()) {
            city.reset();
        }
    }

    public int bonus(int value) {
        if(value > 0) {
            Random r = game.getRandom();
            return r.nextInt(value+1);
        }
        return 0;
    }

    public void addRoads(City a, City b, int length) {
        if(network.containsKey(a) && network.containsKey(b)) {
            List<Road> aRoads = network.get(a), bRoads = network.get(b);
            aRoads.add(new Road(a,b,length));
            bRoads.add(new Road(b,a,length));
        } else if(network.containsKey(a)) {
            List<Road> aRoads = network.get(a);
            aRoads.add(new Road(a,b,length));
        } else if(network.containsKey(b)) {
            List<Road> aRoads = network.get(b);
            aRoads.add(new Road(b,a,length));
        }
    }

    public Position position(City city) {
        return new Position(city, city, 0);
    }

    public Position readyToTravel(City from, City to) {
        if(from.getCountry().getName().equals(name)) {
            List<Road> list = getRoads(from);
            for(Road road : list) {
                if(road.getTo().equals(to)) {
                    return new Position(from, to, road.getLength());
                }
            }
        }
        return position(from);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
