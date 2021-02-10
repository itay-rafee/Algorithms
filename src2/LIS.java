import java.util.*;

public class LIS {
    private final int teta;
    private final int[] arr;
    private int[] sortArr;
    private int[][] mat;

    private int[][] allPath;
    private final int lengthLIS;
    private final int numOfLis;


    public LIS(int[] arr, int teta) {
        this.teta = teta;
        this.arr = arr;
        int n = arr.length;
        if (arr.length == 0) {
            allPath = new int[0][0];
            numOfLis = 0;
            lengthLIS = 0;
            return;
        }
        sortArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortArr);
        mat = findMat(sortArr, arr);
        lengthLIS = mat[n][n];
        numOfLis = thePaths();
    }

    public int lengthLIS() {
        return lengthLIS;
    }

    public int numOfLIS() {
        return numOfLis;
    }

    public int[][] allLIS() {
        return allPath;
    }

    public int thePaths() {
        int lis = lengthLIS;
        int[][] st = new int[teta][lis];
        int[][] lcs = mat;
        Queue<Node> q = new LinkedList<>();
        int ans = 1;
        Node n = new Node(lcs.length - 1, lcs[0].length - 1, 0, lis - 1);
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            int r = n.getR(), c = n.getC(), p = n.getP(), ind = n.getInd();
            if (r != 0 && c != 0) {
                if (sortArr[r - 1] == arr[c - 1]) {
                    if (p < teta)
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
                        if (ans <= teta)
                            System.arraycopy(st[p], ind, st[ans - 1], ind, lis - ind);
                        q.add(new Node(i, j, ans - 1, ind));
                        i--;
                    }
                }
            }
        }
        int[][] ans2;
        if (teta < ans) {
            ans2 = new int[1][lis];
            System.arraycopy(st, 0, ans2, 0, 1);
        } else {
            ans2 = new int[ans][lis];
            System.arraycopy(st, 0, ans2, 0, ans);
        }
        allPath = ans2;
        return ans;
    }

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


    /////////////// private class ////////

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

        public int getInd() {
            return ind;
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
}




