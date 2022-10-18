import java.util.*;
import java.util.stream.*;
/**
 * Lav en beskrivelse af klassen Toolbox her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class ToolBox
{
    private String name;
    private ArrayList<Tool> toolbox;

    public ToolBox(String name)
    {
        toolbox = new ArrayList<Tool>();
        this.name = name;
    }
    
    public void add(Tool t) {
        toolbox.add(t);
    }
    
    public ArrayList<Tool> electricTools() {
        ArrayList<Tool> result = new ArrayList<Tool>();
        for(Tool t : toolbox) {
            if(t.getElectric()) {
                result.add(t);
            }
        }
        return result;
    }
    
    public List<Tool> electricToolsF() {
        return toolbox.stream()
                      .filter(t -> t.getElectric())
                      .collect(Collectors.toList());
    }
    
    public int price(boolean electric) {
        int result = Integer.MAX_VALUE;
        for(Tool t : toolbox) {
            if(t.getPrice() < result && t.getElectric() == electric) {
                result = t.getPrice();
            }
        }
        return result;
    }
    
    public Optional<Tool> priceF(boolean electric) {
        return toolbox.stream()
                      .filter(t -> t.getElectric() == electric)
                      .min(Comparator.comparing(t -> t.getPrice()));
    }
    
    public void printToolBox() {
        System.out.println(name);
        Collections.sort(toolbox);
        for(Tool t : toolbox) {
            System.out.println(t);
        }
    }
    
    public void printFToolBox() {
        System.out.println(name);
        Collections.sort(toolbox, Comparator.comparing((Tool t) -> t.getPrice())
                                            .thenComparing((Tool t) -> t.getName()));
        toolbox.forEach(t -> System.out.println(t));
    }
}
