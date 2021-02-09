
import java.util.*;

import static MyLibrary.Mat.printMat;


public class LIS {
    private int teta;
    private int[] arr;
    private int[] sortArr;
    private LisData data;
    private int[][] mat;


    public LIS(int[] arr, int teta) {
        this.teta = teta;
        this.arr = arr;
        data = new LisData();
        int n = arr.length;
        sortArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortArr);
//        for (int j : sortArr) {
//            System.out.println(j);
//        }
        mat = findMat(sortArr, arr);
        data.lengthLIS = mat[n][n];
//        printMat(mat);
        data.numOfLis = thePaths();
        allThePath();
    }

    public int lengthLIS() {
        return data.lengthLIS;
    }


    public int numOfLIS() {
        return data.numOfLis;
    }

    public int[][] allLIS() {
        return data.allPath;
    }


    /////////////////////////////////
    //////// private area ///////////
    /////////////////////////////////

    public static int[][] findMat(int[] x, int[] y) {
        int xl = x.length + 1, yl = y.length + 1;
        int[][] lcs = new int[xl][yl];
        for (int i = 1; i < xl; i++) {
            for (int j = 1; j < yl; j++) {
                if (x[i - 1] == y[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs;
    }


    private static class LisData {
        private int[][] allPath;
        private int lengthLIS;
        private int numOfLis;

        public LisData() {
        }
    }

    static class Node {
        private final int r;
        private final int c;
        private final int p;

        public Node(int r, int c, int p) {
            this.r = r;
            this.c = c;
            this.p = p;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getP() {
            return p;
        }
    }

    public int[][] allThePath() {
        int[][] ans1 = new int[data.numOfLis][data.lengthLIS];
        //the paths
        Stack<Integer>[] stack = new Stack[data.numOfLis];
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Stack<>();
        }
        int[][] lcs = mat;
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> vis = new HashMap<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1, ans);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC();
            if (r != 0 && c != 0) {
                int tor = n.getP();
                if (sortArr[r - 1] == arr[c - 1]) {
                    stack[tor-1].push(sortArr[r - 1]);
                    q.add(new Node(r - 1, c - 1, tor));
                }
                else if (lcs[r - 1][c] > lcs[r][c - 1]) {
                    q.add(new Node(r - 1, c, tor));
                }
                else if (lcs[r - 1][c] < lcs[r][c - 1])
                    q.add(new Node(r, c - 1, tor));
                else {
                    addVis(r - 1, c, tor, vis, q);
                    if (lcs[r - 1][c - 1] != lcs[r][c]) {
                        ans++;
                        stack[ans-1] = deepCopyStack(stack[tor-1]);
                    }
                    addVis(r, c - 1, tor, vis, q);
                }
            }
        }
        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < ans1[0].length; j++) {
                if (!stack[i].empty())
                    ans1[i][j] = stack[i].pop();
            }
        }
        data.allPath = ans1;
        return ans1;
    }


    private static Stack<Integer> deepCopyStack(Stack<Integer> integers1) {
        return (Stack<Integer>)integers1.clone();
    }

    // return the paths
    //0 - right , 1 - down
    public int thePaths() {
        int[][] lcs = mat;
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> vis = new HashMap<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1, ans);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC();
            if (r != 0 && c != 0) {
                if (sortArr[r - 1] == arr[c - 1]) {
                    q.add(new Node(r - 1, c - 1, ans));
                } else if (lcs[r - 1][c] > lcs[r][c - 1]) {
                    q.add(new Node(r - 1, c, ans));
                } else if (lcs[r - 1][c] < lcs[r][c - 1])
                    q.add(new Node(r, c - 1, ans));
                else if (lcs[r - 1][c - 1] == lcs[r][c]) {
                    addVis(r - 1, c, ans, vis, q);
                    addVis(r, c - 1, ans, vis, q);
                } else {
                    addVis(r - 1, c, ans, vis, q);
                    ans++;
                    addVis(r, c - 1, ans, vis, q);
                }
            }
        }
        return ans;
    }

    private void addVis(int r, int c, int ans, HashMap<Integer, HashSet<Integer>> vis, Queue<Node> q) {
        if (!vis.containsKey(r)) {
            HashSet<Integer> t = new HashSet<>();
            t.add(c);
            vis.put(r, t);
            q.add(new Node(r, c, ans));
        } else if (!vis.get(r).contains(c)) {
            vis.get(r).add(c);
            q.add(new Node(r, c, ans));
        }
    }

    private static Random _rnd = null;

    static public int[] arr_creator(int n, int seed) {
        int[] arr = new int[n];
        _rnd = new Random(seed);
        HashSet<Integer> vis = new HashSet<>();
        int n1 = n;
        while (0 < n) {
            int a = nextRnd(0, n1 * 2);
            while (vis.contains(a)) {
                a = nextRnd(0, n1 * 2);
            }
            vis.add(a);
            arr[n - 1] = a;
            n--;
        }
        return arr;
    }

    private static int nextRnd(int min, int max) {
        double v = nextRnd(0.0 + min, (double) max);
        int ans = (int) v;
        return ans;
    }

    private static double nextRnd(double min, double max) {
        double d = _rnd.nextDouble();
        double dx = max - min;
        return d * dx + min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 90, -3, -2, -1, -10, -9, -8,-7};
        int[] arr2 = {1, 2, 4, 3, -3, -2, -1};
//        int n = 21;
//        arr = arr_creator(n, 3);
        int teta = 10;
        LIS test = new LIS(arr, teta);
        System.out.println("Length of the LIS: "+test.lengthLIS());
        System.out.println("Number of LIS path: "+test.numOfLIS());
        System.out.println("All the LIS path:");
        printMat(test.allLIS());
    }

}

