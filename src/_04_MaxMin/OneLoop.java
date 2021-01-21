package _04_MaxMin;

public class OneLoop {

    // Complexity: O(2n-2)
    public static int oneLoop(int[] arr) {
        int comparisons = 0;
        int indexMax = 0;
        int indexMin = 0;
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] > max) { //***** find MAX *****
                max = arr[i];
                indexMax = i;
            }
            comparisons++;
            if( arr[i] < min) { //***** find MIN *****
                min = arr[i];
                indexMin = i;
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
        System.out.println("\n********** One loop Random Array **********");
        int comp1 = oneLoop(a);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*a.length - 2));
        System.out.println("\n********** One loop Increasing Array **********");
        comp1 = oneLoop(aInc);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*aInc.length - 2));
        System.out.println("\n********** One loop Decreasing Array **********");
        comp1 = oneLoop(aDec);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*aDec.length - 2));
    }
}
