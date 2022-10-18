import java.util.Optional;
import java.util.*;

/**
 * This class tests the Vegetable drivers license exam
 * Introduktion til Programmering, 2017
 *
 * @author Nikolaj Ignatieff Schwartzbach
 * @author Kristian Cordes-Andersen
 * @version 28/09/2017
 */
public class TestVegetable1
{
	/**
	 * Run the main method from shell
	 */
	public static void main(String[] args){
		testVegetable();
	}

	/** Labels for methods (gives less boilerplate code) */
	private static String[] labels = new String[]{"toString", "organic", "totalPrice", "printShop"};

	/** Vegetable objects */
	private static Vegetable v1,v2,v3,v4,v5;

	/** Shop */
	private static Shop shop;

	/**
	 * Tests the Vegetable class
	 */
	public static void testVegetable() {
		boolean[] tests = new boolean[labels.length];

		// Five well-chosen examples
		v1 = new Vegetable("Apples", false,120);
		v2 = new Vegetable("Pears", true, 130);
		v3 = new Vegetable("Carrots", false, 100);
		v4 = new Vegetable("Carrots", true,200);
		v5 = new Vegetable("Oranges", false, 100);

		// Create the Shop and add the Vegetables
		shop = new Shop("The Funky Shop");
		shop.add(v1);
		shop.add(v2);
		shop.add(v3);
		shop.add(v4);
		shop.add(v5);

		//Perform first three tests
		tests[0] = testToString();
		tests[1] = testOrganic();
		tests[2] = testTotalPrice();

        //Test printShop
        boolean comparable = false;
        try{
            Comparable<Vegetable> v = (Comparable<Vegetable>) v1;
            comparable = true;
            tests[3] = testPrintShop();
        } catch(ClassCastException e){
            System.out.println("compareTo has not been implemented.");
        }

        //Print results
        boolean success = true;
        System.out.println("Test Vegetable-1");
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


	/** Expected result of toString() for every Vegetable */
	private static final String s1 = "Non-organic Apples, 120 cents",
			s2 = "Organic Pears, 130 cents",
			s3 = "Non-organic Carrots, 100 cents",
			s4 = "Organic Carrots, 200 cents",
			s5 = "Non-organic Oranges, 100 cents";

	/**
	 * Tests that toString works as expected
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testToString(){
		boolean success = true;

		if(!(v1.toString()).equals(s1)){
			printError("v1.toString()", s1, v1);
			success = false;
		}
		if(!(v2.toString()).equals(s2)){
			printError("v2.toString()", s2, v2);
			success = false;
		}
		if(!(v3.toString()).equals(s3)){
			printError("v3.toString()", s3, v3);
			success = false;
		}
		if(!(v4.toString()).equals(s4)){
			printError("v4.toString()", s4, v4);
			success = false;
		}
		if(!(v5.toString()).equals(s5)){
			printError("v5.toString()", s5, v5);
			success = false;
		}
		return success;
	}

	/**
	 * Tests organic()
	 * @return whether the test was successful or not.
	 */
	private static boolean testOrganic(){
		boolean success = true;
		boolean expected = false;
		boolean result = shop.organic();

		if (result) {
			printError("shop.organic()", expected, result);
			success = false;
		}

		return success;
	}

	/**
	 * Tests the method totalPrice()
	 * @return whether the test was successful or not.
	 */
	private static boolean testTotalPrice() {
		boolean success = true;
		int resultNonOrganic = (int) shop.totalPrice(false);
		int resultOrganic = (int) shop.totalPrice(true);
		int expectedNonOrganic = 320;
		int expectedOrganic = 330;

		if (expectedNonOrganic != resultNonOrganic) {
			printError("shop.totalPrice(false)", expectedNonOrganic, resultNonOrganic);
			success = false;
		}

		if (expectedOrganic != resultOrganic) {
			printError("shop.totalPrice(true)", expectedOrganic, resultOrganic);
			success = false;
		}

		return success;
	}

	/**
	 * Tests the natural ordering of the Vegetable class
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testPrintShop(){
		/* Expected sorting of the vegetables */
		Vegetable[] correctResult = new Vegetable[]{v1, v4, v3, v5, v2};
        Comparable<Vegetable>[] comps = getComparables(correctResult);

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
					printError("v" + (i+1) + ".compareTo(v" + (i+1) + ")", 0, val);
					success = false;
				}

				//Test that mj.compareTo(mi) < 0 for i<j
				val = comps[j].compareTo(correctResult[i]);
				if(j != i && val >= 0){
					printError("v" + (j+1) + ".compareTo(v" + (i+1) + ")", "negative", val);
					success = false;
				}

				//Test that mi.compareTo(mj) > 0 for i<j
				val = comps[i].compareTo(correctResult[j]);
				if(j != i && val <= 0){
					printError("v" + (i+1) + ".compareTo(v" + (j+1) + ")", "positive", val);
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
	private static Vegetable unwrap(Object object) {
		if (object instanceof Vegetable) {
			return (Vegetable) object;
		} else if (object instanceof Optional) {
			if ((((Optional<Vegetable>) object).isPresent()))
				return ((Optional<Vegetable>) object).get();
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