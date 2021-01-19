package _13_FiboPow;

public class PowFun {
    public static int powRe(int n, int m) {
        if (m == 0) return 1;
        else if (m == 1) return n;
        return n * powIt(n, m - 1);
    }

    public static int powIt(int n, int m) {
        int ans = 1;
        for (int i = 0; i < m; i++) {
            ans *= n;
        }
        return ans;
    }

    public static int powAdaptive(int n, int m) {
        if (m == 0) return 1;
        else if (m == 1) return n;
        return powAdaptive(n, m, 1);
    }

    // O(log(n))
    public static int powAdaptive(int n, int m, int ans) {
        if (m == 0) return ans;
        if (m % 2 == 1) {
            ans *= n;
            m--;
        }
        n *= n;
        m /= 2;
        return powAdaptive(n, m, ans);
    }

    public static void main(String[] args) {
        int n = 2, m = 0;
        long S = System.nanoTime();
        System.out.println(powRe(n, m));
        long E = System.nanoTime();
        System.out.println("time : " + (float) (E - S) / 1000);

        S = System.nanoTime();
        System.out.println(powIt(n, m));
        E = System.nanoTime();
        System.out.println("time : " + (float) (E - S) / 1000);

        S = System.nanoTime();
        System.out.println(powAdaptive(n, m));
        E = System.nanoTime();
        System.out.println("time : " + (float) (E - S) / 1000);
    }
}
