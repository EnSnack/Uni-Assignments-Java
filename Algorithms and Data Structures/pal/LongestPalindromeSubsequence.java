// Version: 2017113001
import java.io.*;
import java.util.*;
public class LongestPalindromeSubsequence {
    public ArrayList<Character> longestPalindromeSubsequence(ArrayList<Character> input) {
        ArrayList<Character> result = new ArrayList<>();
        ArrayList<Character> reverse = new ArrayList<>(input);
        Collections.reverse(reverse);
        int n = input.size();
        int m = reverse.size();
        int pal[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0 || j == 0) {
                    pal[i][j]=0;
                }
                else if (input.get(i-1).equals(reverse.get(j-1))) {
                    pal[i][j]=pal[i-1][j-1]+1;
                } else {
                    pal[i][j]=Math.max(pal[i][j-1],pal[i-1][j]);
                }
            }
        }
        int i=n,j=m;
        while(i > 0 && j > 0) {
            if(input.get(i-1) == reverse.get(j-1)) {
                result.add(input.get(i-1));
                i--;
                j--;
            }
            else if (pal[i-1][j] > pal[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void testAll() {
        clearTerminal();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    public static void test1() {
        char[] input = { 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'a' };
        char[] correctAnswer = { 'b', 'a', 'b', 'a', 'b' };

        try {
            checkPal("test1", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test1", "Exception: " + e);
            return;
        }
    }

    public static void test2() {
        char[] input = { 'a', 'i', 'b', 'o', 'h', 'p', 'h', 'o', 'b', 'i', 'a' };
        char[] correctAnswer = { 'a', 'i', 'b', 'o', 'h', 'p', 'h', 'o', 'b', 'i', 'a' };

        try {
            checkPal("test2", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test2", "Exception: " + e);
            return;
        }
    }

    public static void test3() {
        char[] input = { 'r', 'h', 'o', 't', 'a', 't', 'h', 'o', 'r', 'y' };
        char[] correctAnswer = { 'r', 'o', 't', 'a', 't', 'o', 'r' };

        try {
            checkPal("test3", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test3", "Exception: " + e);
            return;
        }
    }

    public static void test4() {
        char[] input = { 'r', 'a', 'h', 'a', 'n', 'n', 'a', 'h' };
        char[] correctAnswer = { 'h', 'a', 'n', 'n', 'a', 'h' };

        try {
            checkPal("test4", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test4", "Exception: " + e);
            return;
        }
    }

    public static void test5() {
        char[] input = { 'a', 'c', 'b', 'a', 'c' };
        char[] correctAnswer = { 'a', 'b', 'a' };

        try {
            checkPal("test5", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test5", "Exception: " + e);
            return;
        }
    }

    public static void test6() {
        char[] input = "aebecdceeccbadce".toCharArray();
        char[] correctAnswer = "abcceeccba".toCharArray();

        try {
            checkPal("test6", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test6", "Exception: " + e);
            return;
        }
    }

    public static void test7() {
        char[] input = "abcbda".toCharArray();
        char[] correctAnswer = "abcba".toCharArray();

        try {
            checkPal("test7", input, correctAnswer);
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test7", "Exception: " + e);
            return;
        }
    }

    private static void checkPal(String testName, char[] input, char[] correctAnswer) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : input) list.add(c);

        ArrayList<Character> answer = (
            new LongestPalindromeSubsequence().longestPalindromeSubsequence(list));

        if (answer.size() != correctAnswer.length) {
            outputFail(testName,
                       "Expected palindrome of length " + correctAnswer.length + ", got " + answer);
            return;
        }

        int j = 0;
        for (int i : input) {
            if (j < answer.size() && answer.get(j) == i) j++;
        }
        if (j < answer.size()) {
            outputFail(testName, "Not a subsequence of the input: " + answer);
            return;
        }

        for (int i = 0; i < answer.size()-1-i; i++)
            if (answer.get(i) != answer.get(answer.size()-1-i)) {
                outputFail(testName, "Not a palindrome: " + answer);
                return;
            }

        outputPass(testName);
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
        if (testcases == 0) testAll();
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) list.add(sc.next().charAt(0));
            LongestPalindromeSubsequence lis = new LongestPalindromeSubsequence();
            ArrayList<Character> pal = lis.longestPalindromeSubsequence(list);
            System.out.println(pal.size());
            for (int i = 0; i < pal.size(); i++)
                System.out.println(pal.get(i));
        }
    }
}
