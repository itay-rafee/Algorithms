package _15_GlassBall;

import static MyLibrary.Mat.printMat;

public class KBall {

    // n balls, k floors
    public static int numOfCheck(int n, int k) {
        int[][] check = new int[n + 1][k+1];
        for (int i = 1; i <= n; i++) {
            check[i][0] = 0;
            check[i][1] = 1;
        }
        for (int i = 1; i <= k; i++) {
            check[1][i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                check[i][j] = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    check[i][j] = Math.min(Math.max(check[i - 1][l - 1], check[i][j - l]) +1, check[i][j]);
                }
            }
        }
        printMat(check);
        return check[n][k];
    }

    public static void main(String[] args){
        int n = 3, k = 50;
        System.out.print(" ");
        for (int i = 0; i <= k; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(numOfCheck(n, k));
    }
}
