package _06_NumberGame;

public class GreedyAlgo {
    static public int AliceResult;
    static public int BobResult;
    static public int[] array;
    static public int begin;
    static public int end;

    public GreedyAlgo(){
        AliceResult = 0;
        BobResult = 0;
        array = buildArray();
        begin = 0;
        end = array.length - 1;
    }

    static public void gameGreedy() {
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
            if (array[begin] > array[end]) {
                System.out.println("ALICE: I take the first: "+array[begin]);
                AliceResult = AliceResult + array[begin++];
            }
            else {
                System.out.println("ALICE: I take the last: "+array[end]);
                AliceResult = AliceResult + array[end--];
            }
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
        }
        System.out.println("Congratulations! ALICE = " + AliceResult + ", BOB = " + BobResult);
    }

    private static void greedyAlgorithm() {
        while (end > begin){
            // alice choose
            if (array[begin] > array[end]){
                AliceResult += array[begin++];
            } else {
                AliceResult += array[end--];
            }
            // bob choose
            if (array[begin] > array[end]){
                BobResult += array[begin++];
            } else {
                BobResult += array[end--];
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("\n\n");
        new GreedyAlgo();
        gameGreedy();
        System.out.println("\n\n*********************************************************************** ");
        new GreedyAlgo();
        printArray();
        greedyAlgorithm();
        System.out.println("Alice : " + AliceResult + " Bob : " + BobResult);
    }



    public static int[] buildArray(){
        return new int[]{ 6, 9, 1, 2, 16, 8};
    }

    public static void printArray(){
        System.out.print(" Array : ");
        for(int i = begin; i <= end; i++)
            System.out.print(array[i]+", ");
        System.out.println();
    }
}
