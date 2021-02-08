package _20_Tests._2021_a;

public class Q3 {
    public static int maxi(int[] arr){
        int n = arr.length;
        if (n == 0)return 0;
        if (n == 1)return arr[0];
        int min = arr[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min){
                index = i;
                min = arr[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != index){
                ans += arr[i];
            }
        }
        ans = ans + (min*(n-1)*2) - min;
        return ans;
    }
    public static void main(String[] args){
        int[] a = {1,2,5,10};
        System.out.println(maxi(a));
    }
}
