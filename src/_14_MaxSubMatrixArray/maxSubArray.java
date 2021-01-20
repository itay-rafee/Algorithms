package _14_MaxSubMatrixArray;

import java.util.Arrays;

public class maxSubArray {
    public static int[] greedyArr(int[] arr){
        int maxOne = 0, i = 0;
        while (i < arr.length){
            if (arr[i] == 1)
            {
                maxOne++;
                break;
            }
            i++;
        }
        while (arr[++i] == 1)maxOne++;
        int[] ans = new int[maxOne];
        for (int j = 0; j < maxOne; j++) {
            ans[j] = 1;
        }
        return ans;
    }

    public static int[] adaptiveArr(int[] arr){
        int maxOne = 0, counter = 0;
        boolean flag = false;
        for (int j : arr) {
            if (j == 1) {
                flag = true;
                counter++;
            } else if (flag) {
                maxOne = Math.max(maxOne, counter);
                counter = 0;
                flag = false;
            }
        }
        maxOne = Math.max(maxOne, counter);
        int[] ans = new int[maxOne];
        for (int i = 0; i < maxOne; i++) {
            ans[i] = 1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0,0,1,1,0,1,1,1,0,0,1,1,1,1};
        System.out.println(Arrays.toString(greedyArr(arr)));
        System.out.println(Arrays.toString(adaptiveArr(arr)));
    }
}
