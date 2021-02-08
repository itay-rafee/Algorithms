package _20_Tests._2021_a;

public class Q1 {

    public static int[][] findMat(int[] X, int[] Y){
        int xl = X.length + 1, yl = Y.length + 1;
        int[][] lcs = new int[xl][yl];
        for (int i = 1; i < xl; i++) {
            for (int j = 1; j < yl; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs;
    }

    public static int lcs(int[] X, int[] Y) {
        return findMat(X,Y)[X.length][Y.length];
    }

    private static int[] lcsArr(int[] x, int[] y){
        int[][] lcs = findMat(x,y);
        int xl = lcs.length - 1, yl = lcs[0].length - 1;
        int nLcs = lcs[xl][yl], count = nLcs - 1;
        int[] result = new int[nLcs];
        while (count >= 0) {
            if (x[xl - 1] == y[yl - 1]) {
                result[count] = x[xl-1];
                xl--;
                yl--;
                count--;
            } else if (lcs[xl][yl] == lcs[xl - 1][yl])
                xl--;
            else
                yl--;
        }
        return result;
    }
    public static int lcs3(int[] X, int[] Y, int[] Z) {
        int lcsXY = lcs(lcsArr(X,Y),Z);
        int lcsYZ = lcs(lcsArr(Y,Z),X);
        int lcsZX = lcs(lcsArr(Z,X),Y);
        return Math.max(Math.max(lcsYZ,lcsZX),lcsXY);
    }

}
