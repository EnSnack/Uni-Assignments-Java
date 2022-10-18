import java.util.*;
import java.util.Optional;

/**
 * This class tests the Animal drivers license exam
 * Introduktion til Programmering, 2017
 *
 * @author Nikolaj Ignatieff Schwartzbach
 * @author Kristian Cordes-Andersen
 * @version 11/12/2017
 */
public class TestAnimal
{
	/**
	 * Run the main method from shell
	 */
	public static void main(String[] args){
		testAnimal();
	}

	/** Labels for methods (gives less boilerplate code) */
	private static String[] labels = new String[]{"toString", "largestPopulation", "animals", "printZoo"};

	/** Animal objects */
	private static Animal a1,a2,a3,a4,a5;

	/** Zoo object */
	private static Zoo zoo;

	/**
	 * Tests the Animal and Zoo classes
	 */
	public static void testAnimal() {
		boolean[] tests = new boolean[labels.length];

		// Five well-chosen examples
		a1 = new Animal("Elephant", 17, 24);
		a2 = new Animal("Jaguar", 3,0);
		a3 = new Animal("Penguin", 25,24);
		a4 = new Animal("Giraffe", 3,2);
		a5 = new Animal("Lemur", 17,15);

		// Create the Zoo and add the Animals
		zoo = new Zoo("The Funky Zoo");
		zoo.add(a1);
		zoo.add(a2);
		zoo.add(a3);
		zoo.add(a4);
		zoo.add(a5);

		//Perform first three tests
		tests[0] = testToString();
		tests[1] = testLargestPopulation();
		tests[2] = testAnimals();

		//Test printZoo
		try{
			Comparable<Animal> b = (Comparable<Animal>) a1;
			tests[3] = testPrintZoo();
		} catch(ClassCastException e){
			System.out.println("compareTo has not been implemented.");
		}

		//Print results
		boolean success = true;
		System.out.println("TestAnimal");
		for(int i=0; i<tests.length-1; i++){
			System.out.println("* " + labels[i]+": Test "+(tests[i]?"successful!":"failed..."));
			success &= tests[i];
		}

		System.out.println("* "
				+ labels[3]
				+ ": Test "
				+ (tests[3] ? "successful!":"failed")
				+ " (here we only test that compareTo is correct)");

		//Print overall
		System.out.println("Test "
				+ (success?"successful!":"failed..."));
	}


	/** Expected result of toString() for every Animal */
	private static final String s1 = "Elephant: 17 female and 24 male",
			s2 = "Jaguar: 3 female and 0 male",
			s3 = "Penguin: 25 female and 24 male",
			s4 = "Giraffe: 3 female and 2 male",
			s5 = "Lemur: 17 female and 15 male";

	/**
	 * Tests that toString works as expected
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testToString(){
		boolean success = true;

		if(!(a1.toString()).equals(s1)){
			printError("a1.toString()", s1, a1.toString());
			success = false;
		}
		if(!(a2.toString()).equals(s2)){
			printError("a2.toString()", s2, a2.toString());
			success = false;
		}
		if(!(a3.toString()).equals(s3)){
			printError("a3.toString()", s3, a3.toString());
			success = false;
		}
		if(!(a4.toString()).equals(s4)){
			printError("a4.toString()", s4, a4.toString());
			success = false;
		}
		if(!(a5.toString()).equals(s5)){
			printError("a5.toString()", s5, a5.toString());
			success = false;
		}
		return success;
	}

	/**
	 * Tests largestPopulation()
	 * @return whether the test was successful or not.
	 */
	private static boolean testLargestPopulation(){
		boolean success = true;

		Animal expected = a3;

		Animal result = unwrap(zoo.largestPopulation());

		if (!expected.equals(result)) {
			printError("zoo.largestPopulation()", expected, result);
			success = false;
		}

		return success;
	}

	/**
	 * Tests animals()
	 * @return whether the test was successful or not.
	 */
	private static boolean testAnimals() {
		boolean success = true;
		int result = (int) zoo.animals();
		int expected = 127;

		if (result != expected) {
			printError("zoo.animals()", expected, result);
			success = false;
		}


		return success;
	}

	/**
	 * Tests the natural ordering of the Animal class
	 * Will report errors to System.out
	 * @return whether the test was successful or not.
	 */
	private static boolean testPrintZoo(){
		/* Expected sorting of the Animals */
		Animal[] correctResult = new Animal[]{a3, a1, a5, a4, a2};
        Comparable<Animal>[] comps = getComparables(correctResult);

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
	private static Animal unwrap(Object object) {
		if (object instanceof Animal) {
			return (Animal) object;
		} else if (object instanceof Optional) {
			if ((((Optional<Animal>) object).isPresent()))
				return ((Optional<Animal>) object).get();
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