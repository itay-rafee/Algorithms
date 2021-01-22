package _16_Tests._2020_a;

public class Q1 {

    // 1.a
    private static String lcs(String s1, String s2) {
        int l1 = s1.length() + 1, l2 = s2.length() + 1;
        int[][] mat = new int[l1][l2];
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        int count = mat[--l1][--l2];
        StringBuilder ans = new StringBuilder();
        while (count > 0 ){
            if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
                ans.insert(0, s1.charAt(l1-1));
                count--;l2--;l1--;
            } else if (mat[l1][l2] == mat[l1][l2-1]){
                l2--;
            } else
                l1--;
        }
        return ans.toString();
    }

    // 1.b
    public static int minSub(String x,String y){
        return x.length() + y.length() - lcs(x,y).length();
    }

    public static void main(String[] args) {
        String s1 = "abcrca";
        String s2 = "acabcr";

        System.out.println(lcs(s1, s2));
        System.out.println(minSub(s1,s2));
    }

}
