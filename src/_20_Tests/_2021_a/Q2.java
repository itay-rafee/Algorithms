package _20_Tests._2021_a;

import static MyLibrary.Mat.printMat;

public class Q2 {

    public static int longestOfOne(int[] arr) {
        int maxOne = 0, counter = 0;
        boolean flag = false;
        for (int j : arr) {
            if (j == 1) {
                flag = true;
                counter++;
            } else if (flag) {
                maxOne = Math.max(maxOne, counter);
                counter = 0;
                flag = false;
            }
        }
        return Math.max(maxOne, counter);
    }

    public static void setCow(int[] arr, int[] arr2){
        int n = arr.length;
        int[] helpArr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                helpArr[i] = count;
            }
            else
                count = 0;
        }

        for (int i = n-1; i >=0 ; i--) {
            count = helpArr[i];
            int num = count;
            while (count > 0){
                arr2[i] = Math.max(arr2[i], num);
                count--;
                i--;
            }
        }
    }

    public static void setRow(int[][] mat1, int[][] mat2){
        int n = mat1.length, m = mat1[0].length;
        int[][] helpArr = new int[n][m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1[j][i] == 1) {
                    count++;
                    helpArr[j][i] = count;
                }
                else
                    count = 0;
            }
            count = 0;
        }

        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                count = helpArr[j][i];
                int num = count;
                while (count > 0){
                    mat2[j][i] = Math.max(mat2[j][i], num);
                    count--;
                    j--;
                }
            }
        }
    }

    public static int imaginaryPlus(int[][] arr){
        int x = arr.length, y = arr[0].length;
        int[][] mat = new int[x][y];
        for (int i = 0; i < x; i++) {
            setCow(arr[i],mat[i]);
        }
        setRow(arr,mat);
        int max = 0;
        printMat(mat);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat[i][j] > 0){
                    if (i-1 > 0 && i+1 < x && j-1 > 0 && j+1 < y){
                        if (mat[i-1][j] == mat[i][j] || mat[i+1][j] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i][j-1], mat[i][j+1])-1);
                        }
                        else if (mat[i][j-1] == mat[i][j] || mat[i][j+1] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i-1][j], mat[i+1][j])-1);
                        }
                        max = Math.max(max, mat[i][j]);
                    }
                    else if (i-1 > 0 && i+1 < x && j-1 > 0){
                        if (mat[i-1][j] == mat[i][j] || mat[i+1][j] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + mat[i][j-1]-1);
                        }
                        else if (mat[i][j-1] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i-1][j], mat[i+1][j])-1);
                        }
                        max = Math.max(max, mat[i][j]);
                    }
                    else if (i-1 > 0 && i+1 < x && j+1 < y){
                        if (mat[i-1][j] == mat[i][j] || mat[i+1][j] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + mat[i][j+1]-1);
                        }
                        else if (mat[i][j+1] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i-1][j], mat[i+1][j])-1);
                        }
                        max = Math.max(max, mat[i][j]);
                    }
                    else if (i+1 < x && j-1 > 0 && j+1 < y){
                        if (mat[i+1][j] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i][j-1], mat[i][j+1])-1);
                        }
                        else if (mat[i][j-1] == mat[i][j] || mat[i][j+1] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + mat[i+1][j])-1;
                        }
                        max = Math.max(max, mat[i][j]);
                    }
                    else if (i-1 > 0  && j-1 > 0 && j+1 < y){
                        if (mat[i-1][j] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + Math.max(mat[i][j-1], mat[i][j+1])-1);
                        }
                        else if (mat[i][j-1] == mat[i][j] || mat[i][j+1] == mat[i][j]){
                            max = Math.max(max, mat[i][j] + mat[i-1][j]-1);
                        }
                        max = Math.max(max, mat[i][j]);
                    }
                    else if (i-1 > 0 && j+1 < y){
                        if (mat[i][j+1] == mat[i][j] && mat[i-1][j] !=0){
                            max = Math.max(max, mat[i][j] + mat[i-1][j]-1);
                        }
                        else
                            max = Math.max(max, mat[i][j]);

                    }
                    else if (i-1 > 0  && j-1 > 0){
                        if (mat[i][j-1] == mat[i][j] && mat[i-1][j] !=0){
                            max = Math.max(max, mat[i][j] + mat[i-1][j]-1);
                        }
                        else
                            max = Math.max(max, mat[i][j]);
                    }
                    else if (i+1 < x && j+1 < y){
                        if (mat[i+1][j] == mat[i][j] && mat[i][j+1] !=0){
                            max = Math.max(max, mat[i][j] + mat[i][j+1]-1);
                        }
                        else
                            max = Math.max(max, mat[i][j]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args){

        System.out.println("moria");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e){

        }
        System.out.println("end");

//        int[][] a = {
//                {1,1,1,0},
//                {1,1,0,0}
//        };
//        System.out.println(imaginaryPlus(a));
    }
}
