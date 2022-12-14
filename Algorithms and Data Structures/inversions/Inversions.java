// Version: 2017091401
import java.io.*;
import java.util.*;

public class Inversions {
    //O(N^2) LØSNING
    /*public int countInversions(ArrayList<Integer> input) {
        int count = 0;
        for(int i = 0; i < input.size()-1; i++) {
            for(int j = i+1; j < input.size(); j++) {
                if(input.get(i) > input.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }*/
    
    //O(N*LOG(N)) LØSNING
    public int countInversions(ArrayList<Integer> input) {
        ArrayList<Integer> temp = new ArrayList<Integer>(input.subList(0, input.size()));
        return mergeSort(input, temp, 0, input.size()-1);
    }
    
    public int mergeSort(ArrayList<Integer> input, ArrayList<Integer> temp, int s, int e) {
        if(s==e) {
            return 0;
        }       
        int mid = (s+e)/2;
        int count = 0;    
        count += mergeSort(input, temp, s, mid);
        count += mergeSort(input, temp, mid+1, e);
        count += merge(input, temp, s, mid, e);      
        return count;
    }
    
    public int merge(ArrayList<Integer> input, ArrayList<Integer> temp, int s, int m, int e) {
        int c = s, i = s, j = m+1;
        int count = 0;   
        while(i <= m && j <= e) {
            if(input.get(i) <= input.get(j)) {
                temp.set(c++, input.get(i++));
            }
            else {
                temp.set(c++, input.get(j++));
                count += (m - i + 1);
            }
        }   
        while(i <= m) {
            temp.set(c++, input.get(i++));
        }  
        for(i = s; i <= e; i++) {
            input.set(i, temp.get(i));
        }
        return count;
    }

    public static void testAll() {
        clearTerminal();
        testSingle();
        testTwoSorted();
        testTwoInverted();
        test1();
        test2();
        testQuadraticTime();  // This is confusing, so don't run it by default
    }

    public static void testSingle() {
        int[] input = { 1 };
        int correctAnswer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testSingle",
                "Expected output " + correctAnswer +
                " but got " + output);
        else
            outputPass("testSingle");
    }

    public static void testTwoSorted() {
        int[] input = { 1, 2 };
        int correctAnswer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testTwoSorted",
                "Expected output " + correctAnswer +
                " but got " + output);
        else
            outputPass("testTwoSorted");
    }

    public static void testTwoInverted() {
        int[] input = { 2, 1 };
        int correctAnswer = 1;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("testTwoInverted",
                "Expected output " + correctAnswer +
                " but got " + output);
        else
            outputPass("testTwoInverted");
    }

    public static void test1() {
        int[] input = { 2, 14, 6, 4, 15, 3, 7, 9, 11, 1, 10, 5, 8, 13, 12 };
        int correctAnswer = 42;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("test1",
                "Expected output " + correctAnswer +
                " but got " + output);
        else
            outputPass("test1");
    }

    public static void test2() {
        int[] input = { 2, 11, 5, 9, 13, 4, 3, 15, 6, 8, 12, 10, 7, 1, 14 };
        int correctAnswer = 46;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : input) list.add(i);

        int output = new Inversions().countInversions(list);

        if (output != correctAnswer)
            outputFail("test2",
                "Expected output " + correctAnswer +
                " but got " + output);
        else
            outputPass("test2");
    }

    public static void testQuadraticTime() {
        int n1 = 1000;
        int n2 = 3000;
        long t11 = timeTest(n1);
        long t12 = timeTest(n1);
        long t13 = timeTest(n1);
        long t14 = timeTest(n1);
        long t15 = timeTest(n1);
        long t1 = Math.min(Math.min(Math.min(Math.min(t11, t12), t13), t14), t15);
        System.out.println("");
        System.out.println("Testing time complexity.");
        System.out.println("Elapsed time on input size n1 = " + n1 + ": t1 = " + t1);
        long t21 = timeTest(n2);
        long t22 = timeTest(n2);
        long t23 = timeTest(n2);
        long t2 = Math.min(Math.min(t21, t22), t23);
        System.out.println("Elapsed time on input size n2 = " + n2 + ": t2 = " + t2);
        double slowdown = ((double) t2) / t1;
        double linearSlowdown = ((double) n2) / n1;
        System.out.println("Expected slowdown (for linear time): n2 / n1 = " + linearSlowdown);
        System.out.println("Measured slowdown: t2 / t1 = " + slowdown);
        if (slowdown > Math.pow(linearSlowdown, 1.2))
            System.out.println("That's not linear time!");
        else
            System.out.println("OK.");
    }

    private static long timeTest(int n) {
        long t1 = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            list.add((int) (i * 982451653L % 413158511L));
        }
        new Inversions().countInversions(list);
        long t2 = System.nanoTime();
        // For debugging, output the individual times:
        // System.out.println(n + " " + (t2 - t1));
        return t2 - t1;
    }

    private static void clearTerminal() {
        System.out.print('\u000C');
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) list.add(sc.nextInt());
            System.out.println(new Inversions().countInversions(list));
        }
    }
}
