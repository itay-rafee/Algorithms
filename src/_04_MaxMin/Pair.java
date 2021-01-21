package _04_MaxMin;

public class Pair {

    // Complexity: O(3(n-2)/2)
    public static int pair(int[] arr) {
        int comparisons = 0;
        int max, min;
        int indexMax, indexMin;

        if (arr[0] > arr[1]) {
            max = arr[0];
            indexMax = 0;
            min = arr[1];
            indexMin = 1;
        } else {
            max = arr[1];
            indexMax = 1;
            min = arr[0];
            indexMin = 0;
        }

        for (int i = 2; i < arr.length - 1; i += 2) {
            comparisons++;
            if (arr[i] < arr[i + 1]) {
                comparisons += 2;
                if (max < arr[i + 1]) {
                    max = arr[i + 1];
                    indexMax = i + 1;
                }
                if (arr[i] < min) {
                    min = arr[i];
                    indexMin = i;
                }

            } else {
                comparisons += 2;
                if (max < arr[i]) {
                    max = arr[i];
                    indexMax = i;
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                    indexMin = i + 1;
                }
            }
        }
        if (arr.length % 2 != 0) {
            comparisons++;
            if (arr[arr.length - 1] > max) {
                max = arr[arr.length - 1];
                indexMax = arr.length - 1;
            } else {
                comparisons++;
                if (arr[arr.length - 1] < min) {
                    min = arr[arr.length - 1];
                    indexMin = arr.length - 1;
                }
            }
        }

        System.out.println("max = " + max + " indexMax = " + indexMax + " min = " + min +
                " indexMin = " + indexMin);
        return comparisons;
    }

    public static void main(String[] args) {
        int[] a = BuildArray.buildRandomArray();
        int[] aInc = BuildArray.buildSortIncreasingArray();
        int[] aDec = BuildArray.buildSortDecreasingArray();
        System.out.println("\n********** Pairs comparison Random Array **********");
        int comp1 = pair(a);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Pairs comparison Increasing Array **********");
        comp1 = pair(aInc);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Pairs comparison Decreasing Array **********");
        comp1 = pair(aDec);
        System.out.println("comp1 = " + comp1);
    }

}
