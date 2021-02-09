package MyLibrary;

import java.util.Arrays;

public class Mat {
    public static void printMat(int[][] mat) {
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
