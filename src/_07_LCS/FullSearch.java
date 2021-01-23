package _07_LCS;

import java.util.Arrays;

public class FullSearch {

    // exhaustive search
    public static void plus1(int[] arr) {
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == 1) {
            arr[i--] = 0;
        }
        if (i >= 0) arr[i] = 1;
    }

    public static String[] fullSearch(String s) {
        int count = (int) Math.pow(2, s.length()) - 1;
        int[] bin = new int[s.length()];
        String[] ans = new String[count];
        int len = 0;
        for (int i = 0; i < count; i++) {
            plus1(bin);
            StringBuilder sNew = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (bin[j] == 1) {
                   sNew.append(s.charAt(j));
                }
            }
            ans[len++] = sNew.toString();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(Arrays.toString(fullSearch(s)));

    }
}
