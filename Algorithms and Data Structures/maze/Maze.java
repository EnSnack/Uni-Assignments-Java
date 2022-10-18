// Version: 2017112801

import java.io.*;
import java.util.*;

public class Maze {
    public int shortestPath(char[][] maze) {
        int height = maze.length;
        int width = maze[0].length;
        int rowNum[] = {-1,0,0,1};
        int colNum[] = {0,-1,1,0};
        Point src = new Point(1, 1);
        Point dest = new Point(height-2, width-2);
        if((maze[src.x][src.y] == 'o') || (maze[dest.x][dest.y] == 'o')) return Integer.MAX_VALUE;
        boolean[][] visited = new boolean[height][width];
        visited[src.x][src.y] = true;
        Queue<QueueNode> q = new ArrayDeque<QueueNode>();
        QueueNode s = new QueueNode(src, 0);
        q.add(s);
        while(!q.isEmpty()) {
            QueueNode curr = q.peek();
            Point pt = curr.pt;
            if(pt.x == dest.x && pt.y == dest.y) return curr.dist;
            q.poll();
            for(int i=0;i<4;i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];
                if((valid(row,col,height,width) && maze[row][col] == '.') && !visited[row][col]) {
                    visited[row][col] = true;
                    QueueNode adjCell = new QueueNode(new Point(row, col), curr.dist +1);
                    q.add(adjCell);
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    static class Point {
        public Point(int row, int col) {
            this.x = row;
            this.y = col;
        }
        int x;
        int y;
    }
    static class QueueNode {
        public QueueNode(Point src, int d) {
            this.pt = src;
            this.dist = d;
        }
        Point pt;
        int dist;
    }
    
    boolean valid(int row, int col, int width, int height) {
        return (((row >= 0) && (row < width)) && ((col >= 0) && (col < height)));
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
        test8();
        test9();
        test10();
    }

    public static void test1() {
        char[][] maze = {
            "oooooo".toCharArray(),
            "o....o".toCharArray(),
            "o....o".toCharArray(),
            "o....o".toCharArray(),
            "oooooo".toCharArray()
        };
        int correctAnswer = 5;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test1",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test1");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test1", "Exception: " + e);
        }
    }

    public static void test2() {
        char[][] maze = {
            "ooooo".toCharArray(),
            "o.ooo".toCharArray(),
            "ooooo".toCharArray(),
            "ooo.o".toCharArray(),
            "ooooo".toCharArray()
        };
        int correctAnswer = Integer.MAX_VALUE;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test2",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test2");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test2", "Exception: " + e);
        }
    }

    public static void test3() {
        char[][] maze = {
            "oooooooo".toCharArray(),
            "o......o".toCharArray(),
            "oooooo.o".toCharArray(),
            "o......o".toCharArray(),
            "o.oooooo".toCharArray(),
            "o......o".toCharArray(),
            "oooooooo".toCharArray()
        };
        int correctAnswer = 19;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test3",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test3");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test3", "Exception: " + e);
        }
    }

    public static void test4() {
        char[][] maze = {
            "ooooooooo".toCharArray(),
            "o.o...o.o".toCharArray(),
            "o.o.o.o.o".toCharArray(),
            "o.o.o.o.o".toCharArray(),
            "o.o.o.o.o".toCharArray(),
            "o...o...o".toCharArray(),
            "ooooooooo".toCharArray()
        };
        int correctAnswer = 18;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test4",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test4");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test4", "Exception: " + e);
        }
    }

    public static void test5() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o...o.......o".toCharArray(),
            "o.o.o.ooo.ooo".toCharArray(),
            "o.o...o...o.o".toCharArray(),
            "o.ooooooooo.o".toCharArray(),
            "o.ooo.o...o.o".toCharArray(),
            "o.o...o.o...o".toCharArray(),
            "o.o.o.o.ooo.o".toCharArray(),
            "o...o.....o.o".toCharArray(),
            "ooooo...ooo.o".toCharArray(),
            "ooooooooooooo".toCharArray()
        };
        int correctAnswer = 28;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test5",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test5");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test5", "Exception: " + e);
        }
    }

    public static void test6() {
        char[][] maze = {
            "ooooooooooo".toCharArray(),
            "o...o.....o".toCharArray(),
            "o.o.ooo.ooo".toCharArray(),
            "o.o.......o".toCharArray(),
            "ooo.o.ooo.o".toCharArray(),
            "o...o...o.o".toCharArray(),
            "o.o.o.o.o.o".toCharArray(),
            "o.....o...o".toCharArray(),
            "ooo.o.ooo.o".toCharArray(),
            "o.........o".toCharArray(),
            "o.......o.o".toCharArray(),
            "ooooooooooo".toCharArray()
        };
        int correctAnswer = 17;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test6",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test6");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test6", "Exception: " + e);
        }
    }

    public static void test7() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o.....o.....o".toCharArray(),
            "o.ooooo.ooo.o".toCharArray(),
            "o.o..o..o...o".toCharArray(),
            "o.o.ooo.ooo.o".toCharArray(),
            "o.....o.o...o".toCharArray(),
            "ooo.o.ooo.ooo".toCharArray(),
            "o.......o...o".toCharArray(),
            "ooooooooooooo".toCharArray()
        };
        int correctAnswer = Integer.MAX_VALUE;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test7",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test7");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test7", "Exception: " + e);
        }
    }

    public static void test8() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o...........o".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "o...........o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo..........o".toCharArray(),
            "ooooooooooooo".toCharArray()
        };
        int correctAnswer = 16;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test8",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test8");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test8", "Exception: " + e);
        }
    }

    public static void test9() {
        char[][] maze = {
            "oooooooooooooo".toCharArray(),
            "o..o.........o".toCharArray(),
            "o.o..........o".toCharArray(),
            "o..o.........o".toCharArray(),
            "o.oo...o.ooo.o".toCharArray(),
            "o.o...o.o....o".toCharArray(),
            "o.o.ooo...oooo".toCharArray(),
            "o...ooo......o".toCharArray(),
            "oooooooooooooo".toCharArray(),
        };
        int correctAnswer = 31;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test9",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test9");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test9", "Exception: " + e);
        }
    }

    public static void test10() {
        char[][] maze = {
            "ooooo".toCharArray(),
            "o...o".toCharArray(),
            "o.o.o".toCharArray(),
            "o...o".toCharArray(),
            "o.ooo".toCharArray(),
            "o...o".toCharArray(),
            "ooooo".toCharArray(),
        };
        int correctAnswer = 6;

        try {
            int output = new Maze().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test10",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test10");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test10", "Exception: " + e);
        }
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
            int m = sc.nextInt();
            char[][] maze = new char[n][];
            for (int i = 0; i < n; ++i) {
                maze[i] = sc.next().toCharArray();
                if (maze[i].length != m) {
                    System.out.println("Wrong line length");
                    return;
                }
            }
            System.out.println(new Maze().shortestPath(maze));
        }
    }
}
