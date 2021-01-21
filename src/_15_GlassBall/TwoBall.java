package _15_GlassBall;

public class TwoBall {
    public static int numOfCheck(int n){
        int[] f = new int[n+1];
        if (n == 0)return 0;
        else if (n == 1) return 1;
        f[0] = 0; f[1] = 1; f[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = n;
            for (int j = 0; j < i - 1; j++) {
                int x = Math.max(j, f[i-j]+1);
                if (x < min)min = x;
            }
            f[i] = min;
        }
        return f[n];
    }

    public static void main(String[] args){
        int n = 10;
        System.out.println(numOfCheck(n));
    }
}
