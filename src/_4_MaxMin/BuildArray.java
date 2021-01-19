package _4_MaxMin;

import java.util.ArrayList;
import java.util.Collections;

public class BuildArray {
    public static int[] buildRandomArray() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 1000000; i++)
            numbers.add(i + 1);
        Collections.shuffle(numbers);

        int[] arr = new int[1000000];
        for(int i = 0; i < 1000000; i++)
            arr[i] = numbers.get(i);

        return arr;
    }
    //******************************************************
    public static int[] buildSortIncreasingArray() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 1000000; i++)
            numbers.add(i + 1);

        int[] arr = new int[1000000];
        for(int i = 0; i < 1000000; i++)
            arr[i] = numbers.get(i);

        return arr;
    }
    //******************************************************
    public static int[] buildSortDecreasingArray() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 1000000; i++)
            numbers.add(1000000 - i);

        int[] arr = new int[1000000];
        for(int i = 0; i < 1000000; i++)
            arr[i] = numbers.get(i);

        return arr;
    }
    //******************************************************
    public static void main(String[] args) {
        int[] arr = buildRandomArray();
        int[] arrI = buildSortIncreasingArray();
        int[] arrD = buildSortDecreasingArray();
        System.out.println("arr[0] = " + arr[0] + " arr[1] = " + arr[1] + " arr[999999] = " +
                arr[999999]);
        System.out.println("arrI[0] = " + arrI[0] + " arrI[1] = " + arrI[1] + " arrI[999999] = "
                + arrI[999999]);
        System.out.println("arrD[0] = " + arrD[0] + " arrD[1] = " + arrD[1] + " arrD[999999] = " + arrD[999999]);
    }

}
