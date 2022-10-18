// Version: 2017100201
import java.io.*;
import java.util.*;
public class Dodgeball {
    private TreeSet<Integer> tree = new TreeSet<>();
          
    public int findNearest(int x) {
        int lo = 0;
        int hi = 0;
        if(tree.lower(x) != null) {
            lo = tree.lower(x);
        }
        if(tree.higher(x) != null) {
            hi = tree.higher(x);
        }
        if(lo != 0 && hi == 0) {
            return lo;
        } else if(lo == 0 && hi != 0) {
            return hi;
        } else {
            if(Math.abs(x - lo) > Math.abs(x - hi)) {
                return hi;
            } else {
                return lo;
            }
        }
    }
    
    public void addPlayer(int x) {
        tree.add(x);
    }

    public int throwBall(int x) {
        int distance = 0;
        if(tree.contains(x)) {
            tree.remove(x);
            return distance;
        } else {
            int value = findNearest(x);
            distance = Math.abs(value-x);
            tree.remove(value);
            addPlayer(x);
            return distance;
        }
    }
}
