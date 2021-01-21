package _04_MaxMin;

public class OneLoopElse {
    public static int oneLoopElse(int[] arr){
        int comparisons = 0;
        int max = arr[0];
        int min = arr[0];
        int indexMax = 0;
        int indexMin = 0;

        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] > max){
                indexMax = i;
                max = arr[i];
            }
            else {
                comparisons++;
                if (arr[i] < min){
                    min = arr[i];
                    indexMin = i;
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
        System.out.println("\n********** One loop ELSE Random Array **********");
        int comp1 = oneLoopElse(a);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** One loop ELSE Increasing Array **********");
        comp1 = oneLoopElse(aInc);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** One loop ELSE Decreasing Array **********");
        comp1 = oneLoopElse(aDec);
        System.out.println("comp1 = " + comp1);
    }
}
