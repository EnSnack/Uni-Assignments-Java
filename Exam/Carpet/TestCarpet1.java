import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class tests the Carpet drivers license exam
 * Introduktion til Programmering, 2017
 *
 * @author Nikolaj Ignatieff Schwartzbach
 * @author Kristian Cordes-Andersen
 * @version 13/12/2017
 */
public class TestCarpet1
{
	/**
	 * Run the main method from shell
	 */
	public static void main(String[] args){
		testCarpet();
	}

	/** Labels for methods (gives less boilerplate code) */
	private static String[] labels = new String[]{"toString", "selection", "cheapest", "printShop"};

	/** Carpet objects */
	private static Carpet c1,c2,c3,c4,c5;

	/** Shop */
	private static Shop shop;

	/**
	 * Tests the Carpet class
	 */
	public static void testCarpet() {
		boolean[] tests = new boolean[labels.length];

		// Five well-chosen examples
		c1 = new Carpet("Green", 3,150);
		c2 = new Carpet("Blue", 2, 350);
		c3 = new Carpet("Purple", 4, 300);
		c4 = new Carpet("Blue", 3,300);
		c5 = new Carpet("Cyan", 1, 100);

		// Create the Shop and add the Carpets
		shop = new Shop("The Funky Shop");
		shop.add(c1);
		shop.add(c2);
		shop.add(c3);
		shop.add(c4);
		shop.add(c5);

		//Perform first three tests
		tests[0] = testToString();
		tests[1] = testSelection();
		tests[2] = testCheapest();

        //Test printStore
        boolean comparable = false;
        try{
            Comparable<Carpet> c = (Comparable<Carpet>) c1;
            comparable = true;
            tests[3] = testPrintShop();
        } catch(ClassCastException e){
            System.out.println("compareTo has not been implemented.");
        }

        //Print results
        boolean success = true;
        System.out.println("Test Carpet-1");
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


	/** Expected result of toString() for every Carpet */
	private static final String s1 = "Green carpet, 3 meter of 150 kr.",
			s2 = "Blue carpet, 2 meter of 350 kr.",
			s3 = "Purple carpet, 4 meter of 300 kr.",
			s4 = "Blue carpet, 3 meter of 300 kr.",
			s5 = "Cyan carpet, 1 meter of 100 kr.";

	/**
	 * Tests that toString works as expected
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testToString(){
		boolean success = true;

		if(!(c1.toString()).equals(s1)){
			printError("c1.toString()", s1, c1);
			success = false;
		}
		if(!(c2.toString()).equals(s2)){
			printError("c2.toString()", s2, c2);
			success = false;
		}
		if(!(c3.toString()).equals(s3)){
			printError("c3.toString()", s3, c3);
			success = false;
		}
		if(!(c4.toString()).equals(s4)){
			printError("c4.toString()", s4, c4);
			success = false;
		}
		if(!(c5.toString()).equals(s5)){
			printError("c5.toString()", s5, c5);
			success = false;
		}
		return success;
	}

	/**
	 * Tests selection(int price)
	 * @return whether the test was successful or not.
	 */
	private static boolean testSelection(){
		boolean success = true;

		List<Carpet> expected = new ArrayList<>();
		expected.add(c1);
		expected.add(c3);
		expected.add(c4);
		expected.add(c5);

		List<Carpet> result = shop.selection(300);

		if (!expected.equals(result)) {
			printError("shop.selection(300)", expected, result);
			success = false;
		}

		return success;
	}

	/**
	 * Tests cheapest(String color)
	 * @return whether the test was successful or not.
	 */
	private static boolean testCheapest() {
		boolean success = true;
		Carpet cheapest = unwrap(shop.cheapest("Blue"));

		if (cheapest != c4) {
			printError("shop.cheapest(Blue)", c4, cheapest);
			success = false;
		}

		if (shop.cheapest("Magenta") != null) {
			printError("shop.cheapest(Magenta)", "null", cheapest);
			success = false;
		}

		return success;
	}

	/**
	 * Tests the natural ordering of the Carpet class
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testPrintShop(){
		/* Expected sorting of the Carpets */
		Carpet[] correctResult = new Carpet[]{c1, c3, c4, c5, c2};
        Comparable<Carpet>[] comps = getComparables(correctResult);

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
					printError("c" + (i+1) + ".compareTo(c" + (i+1) + ")", 0, val);
					success = false;
				}

				//Test that mj.compareTo(mi) < 0 for i<j
				val = comps[j].compareTo(correctResult[i]);
				if(j != i && val >= 0){
					printError("c" + (j+1) + ".compareTo(c" + (i+1) + ")", "negative", val);
					success = false;
				}

				//Test that mi.compareTo(mj) > 0 for i<j
				val = comps[i].compareTo(correctResult[j]);
				if(j != i && val <= 0){
					printError("c" + (i+1) + ".compareTo(c" + (j+1) + ")", "positive", val);
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
	private static Carpet unwrap(Object object) {
		if (object instanceof Carpet) {
			return (Carpet) object;
		} else if (object instanceof Optional) {
			if ((((Optional<Carpet>) object).isPresent()))
				return ((Optional<Carpet>) object).get();
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