package _15_GlassBall;

public class KBall {

    // k balls, n floors
    public static int numOfCheck(int n, int k) {
        int[][] check = new int[k + 1][n + 1];
        for (int i = 0; i < n; i++) {
            check[0][i] = 0;
            check[1][i] = i;
        }
        for (int i = 2; i < k; i++) {
            check[i][0] = 0;
            check[i][1] = 1;
            if (n >= 2) check[i][2] = 2;
            for (int j = 2; j < n; j++) {
                int min = n + 1;
                for (int l = 1; l < j - 1; l++) {
                    min = Math.min(Math.max(check[i - 1][l - 1], check[i][j - l]), min) + 1;
                }
                check[i][j] = min;
            }
        }
        return check[k][n];
    }

    public static void main(String[] args){
        int n = 100, k = 11;
        System.out.println(numOfCheck(n, k));
    }
}
