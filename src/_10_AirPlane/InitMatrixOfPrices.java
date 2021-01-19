package _10_AirPlane;

public class InitMatrixOfPrices {
    //mat that was given as example
    public  static Node[][] initMatOfNodes1(){ // n = 4
        int n=4;
        Node[][] mat = new Node[n][n];
        // the 1-st row
        mat[0][0] = new Node(3,1);
        mat[0][1] = new Node(5,2);
        mat[0][2] = new Node(10,4);
        mat[0][3] = new Node(0,2);
        // the 2-nd row
        mat[1][0] = new Node(4,8);
        mat[1][1] = new Node(11,5);
        mat[1][2] = new Node(1,3);
        mat[1][3] = new Node(0,3);
        // the 3-d row
        mat[2][0] = new Node(8,3);
        mat[2][1] = new Node(1,3);
        mat[2][2] = new Node(4,1);
        mat[2][3] = new Node(0,5);
        // the 4-th row
        mat[3][0] = new Node(4,0);
        mat[3][1] = new Node(2,0);
        mat[3][2] = new Node(8,0);
        mat[3][3] = new Node(0,0);
        return mat;
    }
    //mat of 6*6 with 2 best ways
    public static Node[][] initMatOfNodes2(){
        Node[][] mat = new Node[6][6];
        // the 1-st row
        mat[0][0] = new Node(10,1);
        mat[0][1] = new Node(2,4);
        mat[0][2] = new Node(12,5);
        mat[0][3] = new Node(9,1);
        mat[0][4] = new Node(1,2);
        mat[0][5] = new Node(0,5);
        // the 2-nd row
        mat[1][0] = new Node(3,10);
        mat[1][1] = new Node(4,4);
        mat[1][2] = new Node(2,2);
        mat[1][3] = new Node(8,5);
        mat[1][4] = new Node(4,6);
        mat[1][5] = new Node(0,7);
        // the 3-d row
        mat[2][0] = new Node(2,5);
        mat[2][1] = new Node(8,1);
        mat[2][2] = new Node(8,5);
        mat[2][3] = new Node(13,4);
        mat[2][4] = new Node(8,5);
        mat[2][5] = new Node(0,5);
        // the 4-th row
        mat[3][0] = new Node(2,3);
        mat[3][1] = new Node(7,10);
        mat[3][2] = new Node(4,8);
        mat[3][3] = new Node(3,2);//check it!
        mat[3][4] = new Node(4,2);
        mat[3][5] = new Node(0,3);
        // the 5-th row
        mat[4][0] = new Node(1,10);
        mat[4][1] = new Node(2,4);
        mat[4][2] = new Node(9,7);
        mat[4][3] = new Node(5,11);
        mat[4][4] = new Node(1,3);
        mat[4][5] = new Node(0,4);
        // the 6-th row
        mat[5][0] = new Node(8,0);
        mat[5][1] = new Node(5,0);
        mat[5][2] = new Node(15,0);
        mat[5][3] = new Node(4,0);
        mat[5][4] = new Node(10,0);
        mat[5][5] = new Node(0,0);
        return mat;
    }

}
