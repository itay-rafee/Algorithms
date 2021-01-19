package _7_LCS;

public class AdaptiveAlgorithm {

    // O(xl*yL)
    public static int[][] findMat(String x, String y) {
        int xl = x.length() + 1, yl = y.length() + 1;
        int[][] lcs = new int[xl][yl];
        for (int i = 1; i < xl; i++) {
            for (int j = 1; j < yl; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs;
    }

    //O(xl*yl + lcs)
    public static String adaptiveAlgo(String x, String y) {
        int[][] lcs = findMat(x, y);
        int xl = lcs.length - 1, yl = lcs[0].length - 1;
        int nLcs = lcs[xl][yl], count = nLcs - 1;
        StringBuilder result = new StringBuilder();
        while (count >= 0) {
            if (x.charAt(xl - 1) == y.charAt(yl - 1)) {
                result.insert(0, x.charAt(xl - 1));
                xl--; yl--; count--;
            } else if (lcs[xl][yl] == lcs[xl - 1][yl])
                xl--;
            else
                yl--;
        }
        return result.toString();
    }

    // need find the number of the paths
    public static int numOfPath(String x, String y) {
        return -1;
    }

    // return the paths
    public static int[][] thePaths(String x, String y) {
        return null;
    }

    public static void main(String[] args) {
        String x = "abcbdssdfdsadfasdff";
        String y = "bdcabshdfasdfasfgdsf";
        System.out.println(findMat(x, y)[x.length()][y.length()]);
        System.out.println(adaptiveAlgo(x, y));
    }
}
