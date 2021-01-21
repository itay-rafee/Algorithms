package _08_LIS;

import java.util.Arrays;

public class Greedy {
    public static int lisGreedy(int[] arr){//O(n)
        if (arr.length == 0)return 0;
        int maxLis = 0, count = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1])
                count++;
            else {
                if (count > maxLis)
                    maxLis = count;
                count = 1;
            }
        }
        return maxLis;
    }

    public static int[] lisGreedyArr(int[] arr){//O(n+lisGreedy)
        int n = arr.length;
        if (n == 0)return new int[0];
        int[] temp = new int[n];
        temp[0] = arr[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp[count])
                temp[++count] = arr[i];
        }
        int[] maxLis = new int[count+1];
        while (count >= 0){
            maxLis[count] = temp[count];
            count--;
        }
        return maxLis;
    }

    public static void main(String[] args){
        int[] arr = {0,12,1,2,13,4,23};
        System.out.println(lisGreedy(arr));
        System.out.println(Arrays.toString(lisGreedyArr(arr)));
    }
}
