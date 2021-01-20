package _14_MaxSubMatrixArray;

import java.util.Arrays;
import java.util.Vector;

public class maxSubMatrix {

    /**
     * returns the biggest square contains ones
     * Complexity: O((n*m)^2*min(n,m))
     */
    public static int getBiggestSubMatrix(int[][] mat) {
        Vector<int[][]> allMatrix = getAllSubMatrix(mat);
        int maxSize = 0;
        for (int[][] m : allMatrix) {
            boolean isOnes = true;
            for (int i = 0; i < m.length && isOnes; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if (m[i][j] == 0) {
                        isOnes = false;
                        break;
                    }
                }
            }
            if (isOnes) {
                if (m.length > maxSize) maxSize = m.length;
            }
        }
        return maxSize;
    }

    private static Vector<int[][]> getAllSubMatrix(int[][] mat) {
        Vector<int[][]> ans = new Vector<>();
        for (int i = 1; i < Math.min(mat.length, mat[0].length) + 1; i++) {
            for (int j = 0; j < mat.length - i + 1; j++) {
                for (int k = 0; k < mat[0].length - i + 1; k++) {
                    int[][] temp = new int[i][i];
                    for (int i1 = j; i1 < j + i; i1++) {
                        System.arraycopy(mat[i1], k, temp[i1 - j], 0, k + i - k);
                    }
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private static int[][] adaptiveMat(int[][] mat) {
        int ansNum = 0;
        int n = mat.length, m = mat[0].length;
        int [][] helpMat = new int[n][m];
        for (int i = 0; i < n; i++) {
            helpMat[i][0] = mat[i][0];
        }
        System.arraycopy(mat[0], 0, helpMat[0], 0, m);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1){
                    helpMat[i][j] = min3(helpMat[i][j-1], helpMat[i-1][j], helpMat[i-1][j-1]) + 1;
                    if (helpMat[i][j] > ansNum)ansNum = helpMat[i][j];
                }
            }
        }
        return buildMat(ansNum);
    }

    public static int[][] buildMat(int ansNum){
        int[][] ans = new int[ansNum][ansNum];
        for (int i = 0; i < ansNum; i++) {
            for (int j = 0; j < ansNum; j++) {
                ans[i][j] = 1;
            }
        }
        return ans;
    }

    public static int min3(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0}
        };
        printMat(mat);
        System.out.println();
        printMat(buildMat(getBiggestSubMatrix(mat)));
        System.out.println();
        printMat(adaptiveMat(mat));
    }

    public static void printMat(int[][] mat) {
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
