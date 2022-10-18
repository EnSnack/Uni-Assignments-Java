import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

/**
 * This class tests the Tool drivers license exam
 * Introduktion til Programmering, 2017
 *
 * @author Nikolaj Ignatieff Schwartzbach
 * @author Kristian Cordes-Andersen
 * @version 28/09/2017
 */
public class TestTool1
{
	/**
	 * Run the main method from shell
	 */
	public static void main(String[] args){
		testTool();
	}

	/** Labels for methods (gives less boilerplate code) */
	private static String[] labels = new String[]{"toString", "electricTools", "price", "printToolBox"};

	/** Tool objects */
	private static Tool b1,b2,b3,b4,b5;

	/** ToolBox */
	private static ToolBox toolBox;

	/**
	 * Tests the Tool class
	 */
	public static void testTool() {
		boolean[] tests = new boolean[labels.length];

		// Five well-chosen examples
		b1 = new Tool("Hammer", false,150);
		b2 = new Tool("Screwdriver", true, 350);
		b3 = new Tool("Saw", false, 300);
		b4 = new Tool("Tablesaw", true,1000);
		b5 = new Tool("Wrench", false, 150);

		// Create the ToolBox and add the Tools
		toolBox = new ToolBox("The Funky ToolBox");
		toolBox.add(b1);
		toolBox.add(b2);
		toolBox.add(b3);
		toolBox.add(b4);
		toolBox.add(b5);

		//Perform first three tests
		tests[0] = testToString();
		tests[1] = testElectricTools();
		tests[2] = testPrice();

        //Test printToolBox
        boolean comparable = false;
        try{
            Comparable<Tool> t = (Comparable<Tool>) b1;
            comparable = true;
            tests[3] = testPrintToolBox();
        } catch(ClassCastException e){
            System.out.println("compareTo has not been implemented.");
        }

        //Print results
        boolean success = true;
        System.out.println("Test Tool-1");
        for(int i=0; i<tests.length; i++){
            if(i==3&&!comparable)
                System.out.println("* "+labels[i]+": Not implemented.");
            else
            System.out.println("* "
                    + labels[i]
                    + ": Test "
                    + (tests[i] ? "successful!":"failed...")
                    + (i==3 ? " (here we only test that compareTo is correct)":""));

            success &= tests[i];
        }
        //Print overall
        System.out.println("Test "+(success?"successful!":"failed...")+"");
	}


	/** Expected result of toString() for every Tool */
	private static final String s1 = "Manual Hammer: 150 kr.",
			s2 = "Electric Screwdriver: 350 kr.",
			s3 = "Manual Saw: 300 kr.",
			s4 = "Electric Tablesaw: 1000 kr.",
			s5 = "Manual Wrench: 150 kr.";

	/**
	 * Tests that toString works as expected
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testToString(){
		boolean success = true;

		if (!(b1.toString()).equals(s1)) {
			printError("b1.toString()", s1, b1);
			success = false;
		}

		if (!(b2.toString()).equals(s2)) {
			printError("b2.toString()", s2, b2);
			success = false;
		}

		if (!(b3.toString()).equals(s3)) {
			printError("b3.toString()", s3, b3);
			success = false;
		}

		if (!(b4.toString()).equals(s4)) {
			printError("b4.toString()", s4, b4);
			success = false;
		}

		if (!(b5.toString()).equals(s5)) {
			printError("b5.toString()", s5, b5);
			success = false;
		}

		return success;
	}

	/**
	 * Tests electricTools()
	 * @return whether the test was successful or not.
	 */
	private static boolean testElectricTools(){
		boolean success = true;

		List<Tool> expected = new ArrayList<>();
		expected.add(b2);
		expected.add(b4);

		List<Tool> result = toolBox.electricTools();

		if (!expected.equals(result)) {
			printError("toolBox.electricTools()", expected, result);
			success = false;
		}

		return success;
	}

	/**
	 * Tests price(electric)
	 * @return whether the test was successful or not.
	 */
	private static boolean testPrice() {
		boolean success = true;
		int resultManual = (int) toolBox.price(false);
		int resultElectric = (int) toolBox.price(true);
		int expectedManual = 150;
		int expectedElectric = 350;


		if (resultElectric != expectedElectric) {
			printError("toolBox.price(true)", expectedElectric, resultElectric);
			success = false;
		}

		if (resultManual != expectedManual) {
			printError("toolBox.price(false)", expectedManual, resultManual);
			success = false;
		}


		return success;
	}

	/**
	 * Tests the natural ordering of the Tool class
	 * Will report errors to System.out
	 */
	private static boolean testPrintToolBox(){
		/* Expected sorting of the tools */
		Tool[] correctResult = new Tool[]{b1, b5, b3, b2, b4};
        Comparable<Tool>[] comps = getComparables(correctResult);

		boolean success = true;

		// Holds the result of comparing i with j.
		int val;

		//For every mi
		for(int i = 0; i < correctResult.length; i++) {
			//For every mj, where j<=i
			for(int j = 0; j <= i; j++){

				//Test that mj.compareTo(mj) == 0
				val = comps[i].compareTo(correctResult[i]);
				if(j == i && val != 0){
					printError("a" + (i+1) + ".compareTo(a" + (i+1) + ")", 0, val);
					success = false;
				}

				//Test that mj.compareTo(mi) < 0 for i<j
				val = comps[j].compareTo(correctResult[i]);
				if(j != i && val >= 0){
					printError("a" + (j+1) + ".compareTo(a" + (i+1) + ")", "negative", val);
					success = false;
				}

				//Test that mi.compareTo(mj) > 0 for i<j
				val = comps[i].compareTo(correctResult[j]);
				if(j != i && val <= 0){
					printError("a" + (i+1) + ".compareTo(a" + (j+1) + ")", "positive", val);
					success = false;
				}
			}
		}

		return success;
	}


	/**
	 * Formats the error message to be printed.
	 * Prints to System.err
	 * @param msg the message (usually the method name)
	 * @param exp the expected value
	 * @param rec the received value
	 */
	private static void printError(String msg, Object exp, Object rec) {
		System.err.println("Error in "+msg+"\n\tExpected: "+exp+"\n\tReceived: "+rec);
	}

	/**
	 * Unwraps a given Optional to the Animal-object.
	 * This is done to allow for handling assignments written using functional programming.
	 * @param object the object returned by the students method
	 * @return the unwrapped object of type Animal, null if object is not an Animal or Optional<Animal>
	 */
	private static Tool unwrap(Object object) {
		if (object instanceof Tool) {
			return (Tool) object;
		} else if (object instanceof Optional) {
			if ((((Optional<Tool>) object).isPresent()))
				return ((Optional<Tool>) object).get();
		}
		return null;
	}

    /**
     * This method converts an array of objects into an array of their corresponding Comparables.
     * If T does not implement Comparable<T>, this method will throw an error.
     * This function is used to ensure our test always compiles, even in absense of the method compareTo.
     * @param input An array of class T
     * @return An array of Comparable<T>, if T implements Comparable<T>; otherwise an error.
     */ 
    private static <T> Comparable<T>[] getComparables(T[] input){
        return new ArrayList<T>(Arrays.asList(input))
                  .stream()
                  .map(o -> (Comparable<T>) o)
                  .toArray(Comparable[]::new);

    }
}