package _08_LIS;

import java.util.Arrays;
    public class Elizabet {
        // binary search between in array
        public static int binarySearchBetween(int []arr, int end, int value){
            int low = 0, high = end;
            if (value<arr[0]) return 0;
            if (value>arr[end])  return end+1;
            while (low <=high){
                int middle = (low + high)/2;
                if (low == high) {// stop search
                    return low;
                }
                else {
                    if (arr[middle] == value){//value was found
                        return middle;
                    }
                    if (value < arr[middle]){// value suppose to be left
                        high = middle;
                    }
                    else{// value suppose to be right
                        low = middle+1;
                    }
                }
            }
            return -1;
        }
        // binary search between in diagonal of matrix
        public static int binarySearchBetween(int [][]arr, int end, int value){
            int low = 0, high = end;
            if (value<arr[0][0]) return 0;
            if (value>arr[end][end])  return end+1;
            while (low <=high){
                int middle = (low + high)/2;
                if (low == high) {// stop search
                    return low;
                }
                else {
                    if (arr[middle][middle] == value){//value was found
                        return middle;
                    }
                    if (value < arr[middle][middle]){// value suppose to be left
                        high = middle;
                    }
                    else{// value suppose to be right
                        low = middle+1;
                    }
                }
            }
            return -1;
        }
        // array contains different integer numbers,assumption: arr.length>2
        // calculation of the length of largest increment subsequence
        public static int LISLength(int [] arr){//O(nlog(n))
            int size = arr.length;
            int[] d = new int[size];
            d[0] = arr[0];
            int end = 0;
            for (int i=1; i<size; i++){
                int index = binarySearchBetween(d, end, arr[i]);
                d[index] = arr[i];
                if (index > end) end++;
            }
            return end+1;
        }
        public static int[] LIS2(int [] arr){//O(n^2*logn)
            int size = arr.length;
            int[][] mat = new int[size][size];
            mat [0][0] = arr[0];
            int lis = 0;
            for (int i=1; i<size; i++){
                int index = binarySearchBetween(mat, lis, arr[i]);
                //System.out.println("i = "+i+", index = "+index + ", element = "+arr[i]);
                for(int j=0; j<index; j++){
                    mat[index][j]=mat[index-1][j];
                }
                mat[index][index] = arr[i];
                if (index > lis) lis++;
                //MyLibrary.printIntMatrix(mat);
                //System.out.println();
            }
            int[] ans = new int[lis+1];
            for(int j=0; j<=lis; j++) ans[j]=mat[lis][j];
            return ans;
        }
        // the longest decreasing sequence
        public static int[] LDS2(int [] arr){
            int[] t = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                t[i] = -arr[i];
            }
            int []ans = LIS2(t);
            for (int i = 0; i < ans.length; i++) {
                ans[i] = -ans[i];
            }
            return ans;
        }
        public static int[] LIS2_Greedy(int [] arr){
            int[] t = new int[arr.length];
            t[0] = arr[0];
            int k = 0;
            for(int i=1; i<arr.length; i++){
                if (arr[i] > t[k]){
                    t[++k] = arr[i];
                }
            }
            int[]ans = new int[k+1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = t[i];
            }
            return ans;
        }
        // exhaustive search
        public static void plus1(int[] arr){
            int i=arr.length-1;
            while( i>=0 && arr[i]==1){
                arr[i--] = 0;
            }
            if (i>=0) arr[i] = 1;
        }
        public static int[] LIS2_ExhaustiveSearch(int[]arr){
            int count = (int)Math.pow(2, arr.length)-1;
            int[] bin = new int[arr.length];
            int[]ans={};
            int maxLen = 0;
            for (int i=0; i<count; i++){
                plus1(bin);
                int [] temp = new int[arr.length];
                boolean flag = true;
                int k=0;
                for (int j=0; flag && j<arr.length; j++){
                    if (bin[j] == 1){
                        if (k >= 1){
                            if (temp[k-1] < arr[j]){
                                temp[k++] = arr[j];
                            }
                            else flag = false;
                        }
                        else temp[k++] = arr[j];
                    }
                }
                if (flag){
                    if (k>maxLen){
                        ans = temp;
                        maxLen = k;
                    }
                }
            }
            int [] res = new int[maxLen];
            for (int j = 0; j < res.length; j++) {
                res[j] = ans[j];
            }
            return res;

        }
        public static int LDSLength(int [] arr){//O(nlogn)
            int n = arr.length;
            int[]reverse = new int[n];
            for(int i=0; i<arr.length; i++) {
                reverse[i] = arr[n-i-1];
            }
            return LISLength(reverse);
        }
        public static void main(String[] args) {
            int[]a1 = {-3, -2, 101, 9, 10, 11, 1, 2, 3, 100, 4, -1, 5, 6};
            int[]a2  = {8,4,12,2,14,10,3,5,6,7};
            int[]a3  = {8,4,13,12};
            System.out.println("lis(a1) = "+Arrays.toString(LIS2(a1)));
            System.out.println("lis(a2) = "+Arrays.toString(LIS2(a2)));
            System.out.println("lis(a3) = "+Arrays.toString(LIS2(a3)));
            System.out.println("lisLen(a1) = "+LISLength(a1));
            System.out.println("lisLen(a2) = "+LISLength(a2));
            System.out.println("lisLen(a3) = "+LISLength(a3));
            ///lds
            System.out.println("lds(a1) = "+Arrays.toString(LDS2(a1)));
            System.out.println("lds(a2) = "+Arrays.toString(LDS2(a2)));
            System.out.println("lds(a3) = "+Arrays.toString(LDS2(a3)));
            System.out.println("ldsLen(a1) = "+LDSLength(a1));
            System.out.println("ldsLen(a2) = "+LDSLength(a2));
            System.out.println("ldsLen(a3) = "+LDSLength(a3));
        }
    }
/*
    lis(a1) = [-3, -2, 1, 2, 3, 4, 5, 6]
	lis(a2) = [2, 3, 5, 6, 7]
	lis(a3) = [4, 12]
	lisLen(a1) = 8
	lisLen(a2) = 5
	lisLen(a3) = 2
	lds(a1) = [101, 100, 4, -1]
	lds(a2) = [14, 10, 7]
	lds(a3) = [13, 12]
	ldsLen(a1) = 4
	ldsLen(a2) = 3
	ldsLen(a3) = 2

 */


