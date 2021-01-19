package _10_AirPlane;

import java.util.ArrayList;

public class AdaptiveAlgo {
    int numOfPaths, cheapestPrice;
    private Node[][] mat;

    public AdaptiveAlgo(Node[][] nodes) {
        numOfPaths = 0;
        cheapestPrice = 0;
        mat = nodes;
    }

    public void getBestPrice() {
        // n rows, m columns
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0;
        for (int i = 1; i < n; i++) {// first column
            mat[i][0].price = mat[i - 1][0].y + mat[i - 1][0].price;
            mat[i][0].numOfPaths = 1;
        }
        for (int j = 1; j < m; j++) {// first row
            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
            mat[0][j].numOfPaths = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;
                if (a < b) {
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i - 1][j].numOfPaths;
                } else if (a > b) {
                    mat[i][j].price = b;
                    mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths;
                } else {//x==y
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths + mat[i - 1][j].numOfPaths;
                }
            }
        }
        numOfPaths = mat[n - 1][m - 1].numOfPaths;
        cheapestPrice = mat[n - 1][m - 1].price;
    }

    ////////
    String getOneCheapestPath() {
        String ans = "";
        int i = mat.length - 1, j = mat[0].length - 1;
        while (i > 0 && j > 0) {
            int a = mat[i - 1][j].price + mat[i - 1][j].y;
            int b = mat[i][j - 1].price + mat[i][j - 1].x;
            if (a < b) {
                ans = "1" + ans;
                i--;
            } else {//a>b
                ans = "0" + ans;
                j--;
            }
        }
        if (i == 0) {
            while (j > 0) {
                ans = "0" + ans;
                j--;
            }
        } else {//j==0
            while (i > 0) {
                ans = "1" + ans;
                i--;
            }
        }
        return ans;
    }

    //calculate all the cheapest paths
    public void AllPathsRecurs(int teta) {
        if (numOfPaths <= teta) {
            ArrayList<String> paths = new ArrayList<String>(numOfPaths);
            buildPaths("", mat.length - 1, mat[0].length - 1, paths);
            System.out.println(paths);
        }
    }

    public void buildPaths(String path, int i, int j, ArrayList<String> paths) {
        if (i > 0 && j > 0) {
            int a = mat[i - 1][j].price + mat[i - 1][j].y;
            int b = mat[i][j - 1].price + mat[i][j - 1].x;
            if (a < b) {
                buildPaths("1" + path, i - 1, j, paths);
            } else if (a > b) {
                buildPaths("0" + path, i, j - 1, paths);
            } else {//a==b
                buildPaths("1" + path, i - 1, j, paths);
                buildPaths("0" + new String(path), i, j - 1, paths);
            }
        } else if (i == 0 && j == 0) {
            paths.add(path);
        } else if (i == 0) {
            String t = "";
            for (int k = 0; k < j; k++) t = t + "0";
            paths.add(t + path);
        } else if (j == 0) {
            String t = "";
            for (int k = 0; k < i; k++) t = t + "1";
            paths.add(t + path);
        }
    }

    // find the best price in submatrix from bottom left point (i0, j0) to upper right point (i1 ,j1)
    public void getBestPrice(int i0, int j0, int i1, int j1) {
        mat[i0][j0].price = 0;
        for (int i = i0 + 1; i <= i1; i++) {// first column
            mat[i][j0].price = mat[i - 1][j0].y + mat[i - 1][j0].price;
            mat[i][j0].numOfPaths = 1;
        }
        for (int j = j0 + 1; j <= j1; j++) {// first row
            mat[i0][j].price = mat[i0][j - 1].price + mat[i0][j - 1].x;
            mat[i0][j].numOfPaths = 1;
        }
        for (int i = i0 + 1; i <= i1; i++) {
            for (int j = j0 + 1; j <= j1; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;
                if (a < b) {
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i - 1][j].numOfPaths;
                } else if (a > b) {
                    mat[i][j].price = b;
                    mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths;
                } else {//x==y
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths + mat[i - 1][j].numOfPaths;
                }
            }
        }
        numOfPaths = mat[i1][j1].numOfPaths;
        cheapestPrice = mat[i1][j1].price;
    }

    public int getNumOfPaths() {
        return numOfPaths;
    }

    public int getCheapestPrice() {
        return cheapestPrice;
    }

    public static void resizePrice(Node[][] mat) {
        int y = mat.length, x = mat[0].length;
        for (int k = 1; k < y; k++)
            mat[k][0].price = mat[k - 1][0].y + mat[k - 1][0].price;
        for (int k = 1; k < x; k++)
            mat[0][k].price = mat[0][k-1].x + mat[0][k-1].price;
        for (int k = 1; k < y; k++) {
            for (int l = 1; l < x; l++) {
                int xMin = mat[k][l - 1].price + mat[k][l - 1].x;
                int yMin = mat[k - 1][l].price + mat[k - 1][l].y;
                mat[k][l].price = Math.min(yMin, xMin);
            }
        }
    }

    public static int adaptiveAlgo(Node[][] mat) {
        int y = mat.length, x = mat[0].length;
        resizePrice(mat);
        return mat[y - 1][x - 1].price;
    }

    public static void main(String[] args) {
        int teta = 10;
        Node[][] nodes = InitMatrixOfPrices.initMatOfNodes1();
        nodes[1][0].x = 9;
        AdaptiveAlgo ap = new AdaptiveAlgo(nodes);
        ap.getBestPrice();
        System.out.println("the price of the cheapest path: " + ap.getCheapestPrice());
        System.out.println("number of the cheapest paths: " + ap.getNumOfPaths());
        System.out.println(ap.getOneCheapestPath());
        int t = 0, x = 0, y = 0;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                t += nodes[y][x].x;
                x++;
            } else {
                t += nodes[y][x].y;
                y++;
            }
        }
        System.out.println("my result:"+adaptiveAlgo(nodes));
        ap.AllPathsRecurs(teta);
    }
}
