package _15_GlassBall;

public class ThreeBall {
    public static int numOfCheck(int n){
        int[] f3 = new int[n+1];
        int[] f2 = new int[n+1];
        if (n == 0)return 0;
        if (n == 1)return 1;
        if (n == 2 || n == 3)return 2;
        f3[0] = 0; f3[1] = 1; f3[2] = 2; f3[3] = 2;
        for (int i = 1; i < n; i++) {
            f2[i] = TwoBall.numOfCheck(i);

        }
        for (int i = 4; i <= n; i++) {
            f3[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int x = Math.max(f2[j-1]+1,f3[i-j]+1);
                if (x < f3[i])f3[i] = x;
            }
        }

        return f3[n];
    }

    public static void main(String[] args){
        int n = 3425;
        System.out.println(numOfCheck(n));
    }
}


