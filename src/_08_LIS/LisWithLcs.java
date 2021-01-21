package _08_LIS;

import java.util.Arrays;


public class LisWithLcs {

    // O(n^2) + O(nlog(n))
    public static int[] lisWithLcs(int[] arr) {
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    // O(xl*yL)
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

    //O(xl*yl + lcs)
    public static int[] lcs(int[] x, int[] y) {
        int[][] lcs = findMat(x, y);
        int xl = lcs.length - 1, yl = lcs[0].length - 1;
        int nLcs = lcs[xl][yl], count = nLcs - 1;
        int[] result = new int[nLcs];
        while (count >= 0) {
            if (x[xl - 1] == y[yl - 1]) {
                result[count] = x[xl - 1];
                xl--; yl--; count--;
            } else if (lcs[xl][yl] == lcs[xl - 1][yl])
                xl--;
            else
                yl--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 12, 1, 2, 13, 4, 23};
        System.out.println(Arrays.toString(lisWithLcs(arr)));
    }

}
