package _07_LCS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import static MyLibrary.Mat.printMat;


class Node {
    private final int r;
    private final int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class AdaptiveAlgorithm {

    // O(xl*yL)
    public static int[][] findMat(String x, String y) {
        int xl = x.length() + 1, yl = y.length() + 1;
        int[][] lcs = new int[xl][yl];
        for (int i = 1; i < xl; i++) {
            for (int j = 1; j < yl; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs;
    }

    //O(xl*yl + lcs)
    public static String adaptiveAlgo(String x, String y) {
        int[][] lcs = findMat(x, y);
        int xl = lcs.length - 1, yl = lcs[0].length - 1;
        int nLcs = lcs[xl][yl], count = nLcs - 1;
        StringBuilder result = new StringBuilder();
        while (count >= 0) {
            if (x.charAt(xl - 1) == y.charAt(yl - 1)) {
                result.insert(0, x.charAt(xl - 1));
                xl--;
                yl--;
                count--;
            } else if (lcs[xl][yl] == lcs[xl - 1][yl])
                xl--;
            else
                yl--;
        }
        return result.toString();
    }

    // need find the number of the paths
    public static int numOfPath(String x, String y) {
        int[][] lcs = findMat(x, y);
        Queue<Node> q = new LinkedList<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC();
            if (r != 0 && c != 0) {
                if (lcs[r - 1][c] == lcs[r][c] && lcs[r][c - 1] == lcs[r][c]) {
                    ans++;
                    q.add(new Node(r - 1, c));
                    q.add(new Node(r, c - 1));
                } else if (lcs[r - 1][c] == lcs[r][c])
                    q.add(new Node(r - 1, c));
                else if (lcs[r][c - 1] == lcs[r][c])
                    q.add(new Node(r, c - 1));
                else
                    q.add(new Node(r - 1, c - 1));

            }
        }
        return ans;
    }

    // return the paths
    //0 - right , 1 - down
    public static Vector<int[]> thePaths(String x, String y) {
        int[][] lcs = findMat(x, y);
        Queue<Node> q = new LinkedList<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC();
            if (r != 0 && c != 0) {
                if (lcs[r - 1][c] == lcs[r][c] && lcs[r][c - 1] == lcs[r][c]) {
                    ans++;
                    q.add(new Node(r - 1, c));
                    q.add(new Node(r, c - 1));
                } else if (lcs[r - 1][c] == lcs[r][c])
                    q.add(new Node(r - 1, c));
                else if (lcs[r][c - 1] == lcs[r][c])
                    q.add(new Node(r, c - 1));
                else
                    q.add(new Node(r - 1, c - 1));

            }
        }
        return null;
    }

    public static void main(String[] args) {
        String x = "abcbdabssdfdsadfasdff";
        String y = "bdcabashdfasdfasfgdsf";
        System.out.println(findMat(x, y)[x.length()][y.length()]);
        System.out.println(adaptiveAlgo(x, y));
        printMat(findMat(x, y));
        System.out.println(numOfPath(x,y));
    }
}
