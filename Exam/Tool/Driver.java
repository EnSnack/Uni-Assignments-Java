
/**
 * Lav en beskrivelse af klassen Driver her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class Driver
{
    public static void exam() {
        ToolBox toolbox = new ToolBox("The Tools");
        Tool t1 = new Tool("screwdriver", true, 240);
        Tool t2 = new Tool("hammer", false, 35);
        Tool t3 = new Tool("drill", true, 200);
        Tool t4 = new Tool("screwdriver", false, 40);
        Tool t5 = new Tool("saw", false, 35);
        
        System.out.println("Stringify : ");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        
        toolbox.add(t1);
        toolbox.add(t2);
        toolbox.add(t3);
        toolbox.add(t4);
        toolbox.add(t5);
        
        System.out.println("Electric tools: ");
        System.out.println(toolbox.electricTools());
        
        System.out.println("Billigste elektriske værktøj: ");
        System.out.println(toolbox.price(true));
        
        toolbox.printToolBox();
        
        System.out.println("*** FUNCTIONAL BELOW ***");
        
        System.out.println("Electric tools: ");
        System.out.println(toolbox.electricToolsF());
        
        System.out.println("Billigste elektriske værktøj: ");
        System.out.println(toolbox.priceF(true));
        
        toolbox.printToolBox();
    }

}
