package _08_LIS;

import java.util.Arrays;

import static MyLibrary.Mat.printMat;

public class Adaptive {

    public static int lisAdaptive(int[] arr){
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {0,12,1,2,13,4};
        System.out.println(lisAdaptive(arr));
    }




    static class LIS {

        /**
         * dynamic programming of LIS - get the sequence
         * Complexity: O(n^2)
         */
        public static int[] LISDynamic(int[] arr) {
            int n = arr.length;
            int[][] mat = new int[n][n];
            mat[0][0] = arr[0];
            int len = 1;
            for (int i = 1; i < n; i++) {
                int index = binarySearchBetween(mat,len,arr[i]);
                mat[index][index] = arr[i];
                if(index == len) len++;
                copy(mat,index);
            }
            printMat(mat);
            int[] ans = new int[len];
            if (ans.length >= 0) System.arraycopy(mat[len - 1], 0, ans, 0, ans.length);
            return ans;
        }



        private static void copy(int[][] mat, int index) {
            if (index >= 0) System.arraycopy(mat[index - 1], 0, mat[index], 0, index);
        }

        private static int binarySearchBetween(int[][] mat, int end, int v) {
            if(v > mat[end-1][end-1]) return end;
            if(v < mat[0][0]) return 0;
            int high = end, low = 0;
            while(low <= high) {
                if(low == high)return low;
                int mid = (low + high)/2;
                if(mat[mid][mid] == v) return mid;
                if(mat[mid][mid] > v) high = mid;
                else low = mid+1;
            }
            return -1;
        }

        private static int binarySearchBetween(int[] arr, int end, int v) {
            if(v > arr[end-1]) return end;
            if(v < arr[0]) return 0;
            int high = end, low = 0;
            while(low <= high) {
                if(low == high)return low;
                int mid = (low + high)/2;
                if(arr[mid] == v) return mid;
                if(arr[mid] > v) high = mid;
                else low = mid+1;
            }
            return -1;
        }

        /**
         * dynamic programming of LIS - get the length only (can be done with array instead of matrix)
         * Complexity: O(n*log n)
         */
        public static int LISDynamicLen(int[] arr) {
            int n = arr.length;
            if (n == 0)return 0;
            int[] helpArr = new int[n];
            int len = 1;
            for (int i = 1; i < n; i++) {
                int index = binarySearchBetween(helpArr,len,arr[i]);
                helpArr[index] = arr[i];
                if(index == len) len++;
            }
            return len;
        }

        public static void main(String[] args) {
            int[] arr = {15, -71, -48, 69, -76, 59, 0, -60, 51, 11, -67, -6, 56, -46, 8, -17, 58, 4, 67, -40, 22, -13, -59, -33, -26, 55, -45, 71, 38, -22, -35, -43, -78, 79, 12, 64, -64, 18, 5, -58};
            System.out.println((LISDynamicLen(arr)));
            System.out.println(Arrays.toString(LISDynamic(arr)));
        }
    }

}
