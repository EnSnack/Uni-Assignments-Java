
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        ToolBox toolbox = new ToolBox("Jensen");
        Tool t1 = new Tool("hammer", 240, 150);
        Tool t2 = new Tool("screwdriver", 200, 100);
        Tool t3 = new Tool("screwdriver", 100, 110);
        Tool t4 = new Tool("saw", 200, 125);
        Tool t5 = new Tool("drill", 250, 150);
        System.out.println("**Opgave 1-3**");
        System.out.println("Stringify: ");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        
        System.out.println("**Opgave 4-8**");
        toolbox.add(t1);
        toolbox.add(t2);
        toolbox.add(t3);
        toolbox.add(t4);
        toolbox.add(t5);
        
        System.out.println("værktøjer på mindst 125 gram: ");
        System.out.println(toolbox.heavyTools(125));
        
        System.out.println("**Opgave 9**");
        System.out.println("det lætteste værktøj's pris: ");
        System.out.println(toolbox.lightTool());
        
        System.out.println("**Opgave 10**");
        toolbox.printToolBox();
        
        System.out.println("**Opgave 11**");
        System.out.println("værktøjer på mindst 125 gram: ");
        System.out.println(toolbox.heavyToolsFunc(125));
        System.out.println("det lætteste værktøj's pris: ");
        System.out.println(toolbox.lightToolFunc());
        
        System.out.println("**Opgave 12**");
        toolbox.printToolBoxFunc();
        
    }
}
