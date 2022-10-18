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
public class TestTool2
{
	/**
	 * Run the main method from shell
	 */
	public static void main(String[] args){
		testTool();
	}

	/** Labels for methods (gives less boilerplate code) */
	private static String[] labels = new String[]{"toString", "heavyTools", "lightTool", "printToolBox"};

	/** Tool objects */
	private static Tool t1,t2,t3,t4,t5;

	/** ToolBox */
	private static ToolBox toolBox;

	/**
	 * Tests the Tool class
	 */
	public static void testTool() {
		boolean[] tests = new boolean[labels.length];

		// Five well-chosen examples
		t1 = new Tool("Hammer", 150,2000);
		t2 = new Tool("Screwdriver", 50, 250);
		t3 = new Tool("Saw", 100, 500);
		t4 = new Tool("Tablesaw", 1000,17000);
		t5 = new Tool("Wrench", 175, 500);

		// Create the ToolBox and add the Tools
		toolBox = new ToolBox("The Funky ToolBox");
		toolBox.add(t1);
		toolBox.add(t2);
		toolBox.add(t3);
		toolBox.add(t4);
		toolBox.add(t5);

		//Perform first three tests
		tests[0] = testToString();
		tests[1] = testHeavyTools();
		tests[2] = testLightTool();

        //Test printToolBox
        boolean comparable = false;
        try{
            Comparable<Tool> t = (Comparable<Tool>) t1;
            comparable = true;
            tests[3] = testPrintToolBox();
        } catch(ClassCastException e){
            System.out.println("compareTo has not been implemented.");
        }

        //Print results
        boolean success = true;
        System.out.println("Test Tool-2");
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
	private static final String s1 = "Hammer: 150 kr., 2000 gram",
			s2 = "Screwdriver: 50 kr., 250 gram",
			s3 = "Saw: 100 kr., 500 gram",
			s4 = "Tablesaw: 1000 kr., 17000 gram",
			s5 = "Wrench: 175 kr., 500 gram";

	/**
	 * Tests that toString works as expected
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testToString(){
		boolean success = true;

		if(!(t1.toString()).equals(s1)){
			printError("t1.toString()", s1, t1);
			success = false;
		}
		if(!(t2.toString()).equals(s2)){
			printError("t2.toString()", s2, t2);
			success = false;
		}
		if(!(t3.toString()).equals(s3)){
			printError("t3.toString()", s3, t3);
			success = false;
		}
		if(!(t4.toString()).equals(s4)){
			printError("t4.toString()", s4, t4);
			success = false;
		}
		if(!(t5.toString()).equals(s5)){
			printError("t5.toString()", s5, t5);
			success = false;
		}
		return success;
	}

	/**
	 * Tests heavyTools(weight)
	 * @return whether the test was successful or not.
	 */
	private static boolean testHeavyTools(){
		boolean success = true;

		List<Tool> expected1000Gram = new ArrayList<>();
		expected1000Gram.add(t1);
		expected1000Gram.add(t4);

		List<Tool> result1000Gram = toolBox.heavyTools(1000);

		if (!expected1000Gram.equals(result1000Gram)) {
			printError("toolBox.heavyTools(1000)", expected1000Gram, result1000Gram);
			success = false;
		}

		List<Tool> expected500Gram = new ArrayList<>();
		expected500Gram.add(t1);
		expected500Gram.add(t3);
		expected500Gram.add(t4);
		expected500Gram.add(t5);

		List<Tool> result500Gram = toolBox.heavyTools(500);

		if (!expected500Gram.equals(result500Gram)) {
			printError("toolBox.heavyTools(500)", expected500Gram, result500Gram);
			success = false;
		}

		List<Tool> expectedExceedinglyHeavy = new ArrayList<>();
		List<Tool> resultExceedinglyHeavy = toolBox.heavyTools(17001);
		if (!expectedExceedinglyHeavy.equals(resultExceedinglyHeavy)) {
			printError("toolBox.heavyTools(17001)", expectedExceedinglyHeavy, resultExceedinglyHeavy);
			success = false;
		}

		return success;
	}

	/**
	 * Test lightTool()
	 * @return whether the test was successful or not.
	 */
	private static boolean testLightTool() {
		boolean success = true;
		int expected = 50;
		int result = (int) toolBox.lightTool();


		if (result != expected) {
			printError("toolBox.lightTool()", expected, result);
			success = false;
		}

		return success;
	}

	/**
	 * Tests the natural ordering of the Tool class
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testPrintToolBox(){
		/* Expected sorting of the tools */
		Tool[] correctResult = new Tool[]{t2, t3, t5, t1, t4};
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
					printError("t" + (i+1) + ".compareTo(t" + (i+1) + ")", 0, val);
					success = false;
				}

				//Test that mj.compareTo(mi) < 0 for i<j
				val = comps[j].compareTo(correctResult[i]);
				if(j != i && val >= 0){
					printError("t" + (j+1) + ".compareTo(t" + (i+1) + ")", "negative", val);
					success = false;
				}

				//Test that mi.compareTo(mj) > 0 for i<j
				val = comps[i].compareTo(correctResult[j]);
				if(j != i && val <= 0){
					printError("t" + (i+1) + ".compareTo(t" + (j+1) + ")", "positive", val);
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