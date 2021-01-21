package _09_Secretary;

import java.util.Arrays;

public class Adaptive {

    public static int[] adaptiveSec(int[] arr) {
        int[] ans = Arrays.copyOf(arr,arr.length);
        Arrays.sort(ans);
        return ans;
    }

    public static int theTime(int[] arr){
        int n = arr.length;
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[i]*(n-i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {5, 2, 3, 8, 6};
        System.out.println(theTime(t));
        System.out.println(Arrays.toString(adaptiveSec(t)));

    }
}
