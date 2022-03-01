package learn.recusion;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int solution(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
            return 1 + solution(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
        } else {
            return Math.max(solution(s1.substring(0, s1.length() - 1), s2)
                    , solution(s1, s2.substring(0, s2.length() - 1)));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String s1 = "DEFAX";
        String s2 = "HEPASDASDX";
        System.out.println(longestCommonSubsequence.solution(s1, s2));
        int[][] mem = new int[s1.length()][s2.length()];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        System.out.println(longestCommonSubsequence.solutionDp(s1, s2, mem));
    }

    public int solutionDp(String s1, String s2, int[][] mem) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        if (mem[i][j] != -1) {
            System.out.println("inside dp array");
            return mem[i][j];
        }
        if (i == 0 || j == 0) {
            mem[i][j] = 0;
        } else {
            if (s1.charAt(i) == s2.charAt(j)) {
                mem[i][j] = 1 + solutionDp(s1.substring(0, i), s2.substring(0, j), mem);
            } else {
                mem[i][j] = Math.max(solutionDp(s1.substring(0, i), s2, mem)
                        , solutionDp(s1, s2.substring(0, j), mem));
            }
        }
        return mem[i][j];
    }
}
