package _6_NumberGame;

public class AdaptiveAlgorithm {
    static public int AliceResult;
    static public int BobResult ;
    static public int[] array; // number's array
    static public int begin; // array's first index
    static public int end; // array's last index
    static public int oddSum; // sum of odd-numbered elements
    static public int evenSum; // sum of even-numbered elements
    //**************************************************************************
    public AdaptiveAlgorithm(){
        AliceResult = 0;
        BobResult = 0;
        array = buildArray();
        begin = 0;
        end = array.length - 1;
        oddSum = 0;
        evenSum = 0;
    }

    static public void gameAdaptive() {
        boolean even = true;
        if (evenSum < oddSum)
            even = false;
        int endNew = 0;
        int beginNew = 0;
        int step = 1;
        System.out.println("****************************** THIS IS A GAME **********");
        printArray();
        System.out.println("**************************************************************");
        while (end > begin) {
            System.out.println("********************************");
            System.out.println("********** step # " + step + " **********");
            System.out.println("********************************");
//***** First player ( Alice ) choice *****
            printArray();
            if (even) {
                System.out.println("ALICE: I take the first: "+array[begin]);
                AliceResult = AliceResult + array[begin++];
            }
            else {
                System.out.println("ALICE: I take the last: "+array[end]);
                AliceResult = AliceResult + array[end--];
            }
//***** Second player ( Bob ) choice *****
            printArray();
            if (array[begin] > array[end]) {
                System.out.println("BOB : I take the first: "+array[begin]);
                BobResult = BobResult + array[begin++];
            }
            else {
                System.out.println("BOB : I take the last: "+array[end]);
                BobResult = BobResult + array[end--];
            }
            step++;
            System.out.println(" -------------------------");
            System.out.println(" Sum - ALICE: " + AliceResult +
                    ", BOB: " + BobResult);
            System.out.println(" -------------------------");
            System.out.println();
            evenSum = 0;
            oddSum = 0;
            calculateOddEvenSum();
            even = evenSum >= oddSum;
        }
        System.out.println("Congratulations! ALICE = " + AliceResult + ", BOB = " + BobResult);
    }

    static public void oddEvenAdaptiveAlgorithm(){
        boolean even = true;
        if (evenSum < oddSum)even = false;
        while (end > begin){
            // first player
            if (even){
                AliceResult += array[begin++];
            } else {
                AliceResult += array[end--];
            }

            // second player
            if (array[begin] > array[end])
                BobResult = BobResult + array[begin++];
            else
                BobResult = BobResult + array[end--];
            calculateOddEvenSum();
            even = evenSum >= oddSum;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\n");
        new AdaptiveAlgorithm();
        calculateOddEvenSum();
        gameAdaptive();
        System.out.println("\n\n*********************************************************************");
        new AdaptiveAlgorithm();
        printArray();
        calculateOddEvenSum();
        oddEvenAdaptiveAlgorithm();
        System.out.println("Alice : " + AliceResult + " Bob : " + BobResult);
    }
    //**************************************************************************
    public static void calculateOddEvenSum() {
        evenSum = 0;
        oddSum = 0;
        for(int i = begin; i < end; i = i+2) {
            evenSum = evenSum + array[i];
            oddSum = oddSum + array[i + 1];
        }
    }
    //**************************************************************************
    public static int[] buildArray(){
        return new int[]{ 6, 9, 1, 2, 16, 12};
    }
    //**************************************************************************
    public static void printArray(){
        System.out.print(" Array : ");
        for(int i = begin; i <= end; i++)
            System.out.print(array[i]+", ");
        System.out.println();
    }

}
