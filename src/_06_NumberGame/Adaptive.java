package _06_NumberGame;

import static _14_MaxSubMatrixArray.maxSubMatrix.printMat;

public class Adaptive {
    public static int[][] buildMat(int[] game){
        int n = game.length;
        int[][] mat = new int[n][n];

        //O(n)
        for (int i = 0; i < n; i++) {
            mat[i][i] = game[i];
        }

        // O(n(n+1)/2) = O(n^2)
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                mat[i][j] = Math.max(game[i] - mat[i+1][j], game[j] - mat[i][j-1]);
            }
        }
        return mat;
    }

    public static int strategy(int[] arr, int b, int e){
        int[][] mat = buildMat(arr);
        int n = mat.length-1;
        if (mat[n][n] == (arr[n] - mat[0][n-1]))return 1;
        return 0;
    }

    public static void main(String[] args){
        int[] a = {1,3,6,1,3,6};

        int[] t = {1,4,5,1,5,7};
        printMat(buildMat(t));

    }
}
