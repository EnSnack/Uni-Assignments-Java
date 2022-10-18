// Version: 2017100201
import java.io.*;
import java.util.*;
public class ReversePolishCalculator {
    Stack<Integer> stack = new Stack<Integer>();
    private int number1 = 0;
    private int number2 = 0;
    private int result  = 0;
    public void push(int n) {
        stack.push(n);
        result = n;
    }

    public void plus() {
        number1 = stack.pop();
        number2 = stack.pop();
        result = number1 + number2;
        stack.push(result);
    }

    public void minus() {
        number1 = stack.pop();
        number2 = stack.pop();
        result = number2 - number1;
        stack.push(result);
    }

    public void times() {
        number1 = stack.pop();
        number2 = stack.pop();
        result = number1 * number2;
        stack.push(result);
    }

    public int read() {
        return result;
    }
}
