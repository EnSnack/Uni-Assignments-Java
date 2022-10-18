import java.util.*;
import java.util.stream.*;
/**
 * Lav en beskrivelse af klassen ToolBox her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class ToolBox
{
    private String owner;
    private ArrayList<Tool> toolbox;

    public ToolBox(String owner)
    {
        this.owner = owner;
        toolbox = new ArrayList<Tool>();
    }
    
    public void add(Tool t) {
        toolbox.add(t);
    }
    
    public ArrayList<Tool> heavyTools(int weight) {
        ArrayList<Tool> result = new ArrayList<Tool>();
        for(Tool t : toolbox) {
            if(t.getWeight() >= weight) {
                result.add(t);
            }
        }
        return result;
    }
    
    public int lightTool() {
        int result = 0;
        int weight = Integer.MAX_VALUE;
        for(Tool t : toolbox) {
            if(t.getWeight() < weight) {
                weight = t.getWeight();
                result = t.getPrice();
            }
        }
        return result;
    }
    
    public void printToolBox() {
        System.out.println(owner);
        Collections.sort(toolbox);
        for(Tool t : toolbox) {
            System.out.println(t);
        }
    }
    
    public List<Tool> heavyToolsFunc(int weight) {
        return toolbox.stream()
                      .filter(t -> t.getWeight() >= weight)
                      .collect(Collectors.toList());
    }
    
    public Optional<Tool> lightToolFunc() {
        return toolbox.stream()
                      .min(Comparator.comparing(t -> t.getWeight()));
    }
    
    public void printToolBoxFunc() {
        System.out.println(owner);
        Collections.sort(toolbox, Comparator.comparing((Tool t) -> t.getWeight())
                                            .thenComparing((Tool t) -> t.getPrice()));
        toolbox.forEach(t -> System.out.println(t));
    }
}
