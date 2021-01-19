package _9_Secretary;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class FullSearch {
    public static int[] fullSearchSec(int[] arr) {
        LinkedList<int[]> list = new LinkedList<>();
        int n = arr.length;
        list.add(arr);
        int[] t = copy(arr);
        int[] ans = new int[n];
        int i = 0;
        while (i < n){
            if (ans[i] < i){
                if (2%i == 0)
                    swap(t, 0, i);
                else
                    swap(t, ans[i], i);
                list.add(ans);
                ans[i]++;
                i = 0;
            }
            else {
                ans[i] = 0;
                i++;
            }
        }
        while (!list.isEmpty()){
            System.out.println(Arrays.toString(list.remove()));
        }
        return ans;
    }

    public static void printAllOrdered(int[] elements) {

        Arrays.sort(elements);
        boolean hasNext = true;

        while(hasNext) {
            System.out.println(Arrays.toString(elements));
            int k = 0, l = 0;
            hasNext = false;
            for (int i = elements.length - 1; i > 0; i--) {
                if (elements[i] > elements[i - 1]) {
                    k = i - 1;
                    hasNext = true;
                    break;
                }
            }

            for (int i = elements.length - 1; i > k; i--) {
                if (elements[i] > elements[k]) {
                    l = i;
                    break;
                }
            }

            swap(elements, k, l);
            elements = revers(elements);
        }
    }

    private static int[] revers(int[] elements) {
        int n = elements.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[n-i-1] = elements[i];
        }
        return r;
    }


    public static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static int[] copy(int[] arr){
        return Arrays.copyOf(arr,arr.length);
    }

    public static double theTime(int[] times) {
        double avg = 0;
        for(int x : times) avg = avg + avg + x;
        return avg/times.length;
    }

    public static void permute(int[] arr){
        permuteHelper(arr, 0);
    }

    private static void permuteHelper(int[] arr, int index){
        if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            swap(arr,i,index);

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1);

            //Swap the elements back
            swap(arr,i,index);
        }
    }

    public static void main(String[] args) {
        int[] t = {1,2,3};
        permute(t);
//        printAllOrdered(t);
    }
}
