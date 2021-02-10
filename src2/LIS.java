

import java.util.*;

import static MyLibrary.Mat.printMat;


public class LIS {
    private final int teta;
    private final int[] arr;
    private final int[] sortArr;
    private final LisData data;
    private final int[][] mat;


    public LIS(int[] arr, int teta) {
        this.teta = teta;
        this.arr = arr;
        data = new LisData();
        int n = arr.length;
        sortArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortArr);
        mat = findMat(sortArr, arr);
        data.lengthLIS = mat[n][n];
        List<LinkedList<Integer>> lcs1 = LCS1(sortArr, arr, n, n, mat);
        Set<LinkedList<Integer>> ss = new HashSet<>(lcs1);
        data.numOfLis = ss.size();
        setAllPath(ss);
    }

    private void setAllPath(Set<LinkedList<Integer>> ss) {
        int min = Math.min(teta, data.numOfLis), ln = data.lengthLIS, i = 0;
        int[][] ans = new int[min][ln];
        for (LinkedList<Integer> l : ss) {
            for (int j = 0; j < ln; j++) {
                ans[i][j] = l.get(j);
            }
            i++;
            if (i > min) break;
        }
        data.allPath = ans;
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

    public List<LinkedList<Integer>> LCS1(int[] X, int[] Y, int m, int n,
                                          int[][] T) {
        if (m == 0 || n == 0) {
            List<LinkedList<Integer>> list = new LinkedList<>();
            list.add(new LinkedList<>());
            return list;
        }
        if (X[m - 1] == Y[n - 1]) {
            List<LinkedList<Integer>> lcs = LCS1(X, Y, m - 1, n - 1, T);
            for (LinkedList<Integer> lc : lcs) {
                lc.add(X[m - 1]);
            }
            return lcs;
        }
        if (T[m - 1][n] > T[m][n - 1]) {
            return LCS1(X, Y, m - 1, n, T);
        }
        if (T[m][n - 1] > T[m - 1][n]) {
            return LCS1(X, Y, m, n - 1, T);
        }
        List<LinkedList<Integer>> top = LCS1(X, Y, m - 1, n, T);
        List<LinkedList<Integer>> left = LCS1(X, Y, m, n - 1, T);
        top.addAll(left);

        return top;
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
        int[] arr = {2, 4, 90, -3, -2, -1, -10, -9, -8};
        int[] arr2 = {1, 2, 4, 3, -3, -2, -1};
        int n = 255;
        arr = arr_creator(n, 3);
        int teta = 100;
        long start = System.currentTimeMillis();
//        LIS test = new LIS(arr, teta);
//        System.out.println("Length of the LIS: " + test.lengthLIS());
//        System.out.println("Number of LIS path: " + test.numOfLIS());
//        System.out.println("All the LIS path:");
//        printMat(test.allLIS());
        long end = System.currentTimeMillis();
        double ed = (end - start) / 1000.0;
        System.out.println("the time is: " + ed);

        System.out.println("\n## lis2 ##");
        start = System.currentTimeMillis();
        lis2 test1 = new lis2(arr, teta);
        System.out.println("Length of the LIS: " + test1.lengthLIS());
        System.out.println("Number of LIS path: " + test1.numOfLIS());
        System.out.println("All the LIS path:");
        int[][] allPath = test1.allLIS();
        printMat(allPath);
        end = System.currentTimeMillis();
        ed = (end - start) / 1000.0;
        System.out.println("the time is: " + ed);
        System.out.println();
        for (int i = 0; i < allPath.length; i++) {
            for (int j = i + 1; j < allPath.length; j++) {
                if (Arrays.equals(allPath[i], allPath[j]))
                    System.out.println("false");
            }
        }
//        printMat(test.mat);
        System.out.println(Arrays.toString(arr));
    }


}

class lis2 {

    private static class LisData {
        private int[][] allPath;
        private int lengthLIS;
        private int numOfLis;

        public LisData() {
        }
    }

    private final int teta;
    private final int[] arr;
    private final int[] sortArr;
    private final LisData data;
    private final int[][] mat;


    public lis2(int[] arr, int teta) {
        this.teta = teta;
        this.arr = arr;
        data = new LisData();
        int n = arr.length;
        sortArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortArr);
        mat = LIS.findMat(sortArr, arr);
        data.lengthLIS = mat[n][n];
        data.numOfLis = thePaths();
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


    static class Node {
        private final int r;// row
        private final int c;// col
        private final int p;//num of the path
        private final int ind;//the index in the arr

        public Node(int r, int c, int p, int ind) {
            this.r = r;
            this.c = c;
            this.p = p;
            this.ind = ind;
        }
        public int getInd() {return ind;}
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


    public int thePaths() {
        printMat(mat);
        int lis = data.lengthLIS;
        int[][] st = new int[arr.length][lis];
        int[][] lcs = mat;
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> vis = new HashMap<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1, 0, lis - 1);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC(), p = n.getP(), ind = n.getInd();
            if (r != 0 && c != 0) {
                if (sortArr[r - 1] == arr[c - 1]) {
                    st[p][ind] = arr[c - 1];
                    q.add(new Node(r - 1, c - 1, p, ind - 1));
                } else if (lcs[r][c] != 0) {
                    int i = r;

                    int j2 = c;
                    while (lcs[r][c] == lcs[i][j2 - 1]) j2--;
                    while (lcs[r][c] == lcs[i - 1][j2]) i--;
                    q.add(new Node(i, j2, p, ind));
                    i--;

                    while (lcs[r][c] == lcs[i][c]) {
                        int j = c;
                        while (lcs[r][c] == lcs[i][j - 1]) j--;
                        while (lcs[r][c] == lcs[i - 1][j]) i--;
                        ans++;
//                        System.out.println("p="+p+", ind="+ind+", ans-1="+(ans-1)+", lis-ind="+(lis-ind));
                        System.arraycopy(st[p], ind, st[ans - 1], ind, lis - ind);
                        q.add(new Node(i, j, ans - 1, ind));
                        i--;
                    }
                }
            }
        }
        int min = Math.min(ans, teta);
        int[][] ans2 = new int[min][lis];
        if (min >= 0) System.arraycopy(st, 0, ans2, 0, min);
        data.allPath = ans2;
        return ans;
    }
}




