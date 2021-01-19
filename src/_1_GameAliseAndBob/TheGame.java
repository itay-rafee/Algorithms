package _1_GameAliseAndBob;

public class TheGame {
    public static int coinFli(){
        return (int)Math.round(Math.random());
    }

    public static int aliceGame(){
        return coinFli();
    }

    public static int bobGame(){
        return coinFli();
    }

    // 50 percent
    public static boolean gameStrategy1(){
        return aliceGame() > 0;
    }

    // 75 percent
    public static boolean gameStrategy2(){
        return aliceGame() == 1 || bobGame() == 1;
    }

    // 100 percent
    public static boolean gameStrategy3(){
        int alice = aliceGame();
        int bob = bobGame();
        return alice == bob || bob == 1 - alice;
    }

    public static void main(String[] args){
        System.out.println(coinFli());
        System.out.println(coinFli());
        System.out.println(coinFli());
    }
}
