package _13_FiboPow;

public class FibonacciNumbers {
    public static int fibRec(int n) {
        if (n == 0)
            return 0;
        return fibRec2(n);
    }

    public static int fibRec2(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibRec2(n - 1) + fibRec2(n - 2);
    }


    public static int fibIte(int n) {
        if (n == 1) return 1;
        int f0 = 0, f1 = 1, ans = 0;
        for (int i = 1; i < n; i++) {
            ans = f0 + f1;
            f0 = f1;
            f1 = ans;
        }
        return ans;
    }

    public static int fibLoop(int n) {//O(log(n))
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        int[][] mat = {{1, 1}, {1, 0}};
        int[][] result = mat;
        while (n != 0) {
            if (n % 2 != 0)
                result = mulMat(result, mat);
            mat = mulMat(mat, mat);
            n /= 2;
        }
        return result[1][1];
    }

    public static int[][] mulMat(int[][] m1, int[][] m2) {
        int[][] ans = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = m1[i][0] * m2[0][j] + m1[i][1] * m2[1][j];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 20;
        long S = System.nanoTime();
        System.out.println("fibIte = " + fibIte(n));
        long E = System.nanoTime();
        System.out.println("time : " + (float) (E - S) / 1000);

        S = System.currentTimeMillis();
        System.out.println("fibRec = "+fibRec(n));
        E = System.currentTimeMillis();
        System.out.println("time : "+ (E - S)/1000);

        S = System.nanoTime();
        System.out.println("fibLoop = " + fibLoop(n));
        E = System.nanoTime();
        System.out.println("time : " + (float) (E - S) / 1000);
    }
}
