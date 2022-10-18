// Version: 2017100201
import java.io.*;
import java.util.*;

public class Median {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public void add(int x) {
        if(maxHeap.size() == minHeap.size()) {
            if(minHeap.peek() != null && x > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(x);
            } else {
                maxHeap.offer(x);
            }
        } else {
            if(x < maxHeap.peek()) {
               minHeap.offer(maxHeap.poll());
               maxHeap.offer(x);
            } else {
               minHeap.offer(x);
            }
        }
    }

    public int median() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
