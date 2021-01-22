package _15_GlassBall;

public class TwoBall {
    public static int numOfCheck(int n){
        int[] f = new int[n+1];
        if (n == 0)return 0;
        else if (n == 1) return 1;
        f[0] = 0; f[1] = 1; f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;//int min = n;
            for (int j = 1; j < i; j++) {
                int x = Math.max(j, f[i-j]+1);
                f[i] = Math.min(x, f[i]);
            }
        }

        return f[n];
    }

    public static void main(String[] args){
        int n = 2342;
        System.out.println(numOfCheck(n));
    }
}
