package _9_Secretary;

import java.util.Arrays;

public class Greedy {
    public static int[] greedySec(int[] arr) {
        int[] ans = copy(arr);
        int[] t = copy(arr);
        ans = betterSwap(ans);
        while (theTime(ans) < theTime(t)){
            t = ans;
            ans = betterSwap(ans);
        }
        return ans;
    }

    public static int[] betterSwap(int[] arr){
        int min = theTime(arr);
        int[] t = copy(arr);
        int[] ans = copy(arr);
        for (int i = 0; i < arr.length-1; i++) {
            swap(t, i, i+1);
            if (theTime(ans) > theTime(t))
                ans = t;
            t = copy(arr);
        }
        return ans;
    }

    public static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static int[] copy(int[] arr){
        return Arrays.copyOf(arr,arr.length);
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
        System.out.println(Arrays.toString(greedySec(t)));
    }
}
