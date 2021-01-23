package _20_Tests._2020_a;

import java.util.Arrays;
import java.util.HashSet;

public class Q3 {
    public static int[] horsesProblem(int[] horses){
        int[] ans = new int[3];
        int n = horses.length;
        int[][] race = new int[5][5];
        for (int i = 0; i < n;) {
            int[] t = new int[5];
            for (int j = 0; j < 5; j++) {
                t[j] = horses[i];
                i++;
            }
            race[i-5]= race(t);
        }

        return ans;
    }

    public static int[] race(int[] horses){
        int n = horses.length;
        if (n > 5 || n < 1)return null;
        if (n == 1)return new int[]{horses[0]};
        int[] ans = new int[n];
        System.arraycopy(horses, 0, ans, 0, n);
        Arrays.sort(ans);
        return ans;

    }

    public static void main(String[] args){
        int n = 25;
        int[] horses = new int[n];
        HashSet<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * 30);
            while (vis.contains(x))
                x = (int) (Math.random() * 30);
            vis.add(x);
            horses[i] = x;
        }
        int[] ans = horsesProblem(horses);
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < 3; i++) {
            System.out.println("hors number "+i+" is:"+horses[ans[i]]);
        }
    }
}
