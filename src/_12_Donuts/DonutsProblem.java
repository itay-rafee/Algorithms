package _12_Donuts;

public class DonutsProblem {
    public static int getTime(int numDonuts, int cup){
        if (numDonuts < cup)
            return 2;
        else
            return numDonuts%cup == 0 ? (numDonuts/cup)*2: (numDonuts/cup)*2 + 1;
    }

    public static void main(String[] args){
        int d = 10, c = 2;
        System.out.println(getTime(d,c));
    }
}
