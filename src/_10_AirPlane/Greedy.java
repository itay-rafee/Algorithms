package _10_AirPlane;

import java.util.ArrayList;

public class Greedy {

    public static int greedyAirPlane(Node[][] mat) {
        int y = mat.length-1, x = mat[0].length-1;
        int ans = 0;
        int i = 0, j = 0;
        while (i < x && j < y) {
            if (mat[j][i].x > mat[j][i].y )
            {
                System.out.print("y,");
                ans += mat[j++][i].y;
            }
            else
            {
                System.out.print("x,");
                ans += mat[j][i++].x;
            }
        }
        while (i < x){
            System.out.print("x,");
            ans += mat[j][i++].x;
        }
        while (j < y){
            System.out.print("y,");
            ans += mat[j++][i].y;
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        Node[][] nodes = InitMatrixOfPrices.initMatOfNodes1();
        System.out.println("The greedy solution = " + greedyAirPlane(nodes));
        nodes[1][0].x = 9;
        System.out.println("The greedy solution = " + greedyAirPlane(nodes));
    }

}

