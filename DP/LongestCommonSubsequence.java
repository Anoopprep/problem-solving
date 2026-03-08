/**
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 */

package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    /**
     * This approach is greedy. In greedy, we don't explore all the possibilities
     * We ust try to be greedy and pick the first match we get and move forward.
     * This fails for "oxcpqrsvwf" and "shmtulqrypy", the output is 1(p), but the correct output is 2(qr).
     * So here, there are 2 possibilities but we just explored one and that is why greedy fails.
     */
    public int wrongGreedyApproach(String text1, String text2) {
        int count = 0;
        int initial = 0;
        String longer, shorter;

        if(text1.length() > text2.length()) {
            longer = text1;
            shorter = text2;
        } else {
            longer = text2;
            shorter = text1;
        }

        for (int i = 0; i < shorter.length(); i++) {
            for (int j = initial; j < longer.length(); j++) {
                while(j < longer.length() && shorter.charAt(i) != longer.charAt(j)) j++;
                if(j == longer.length()) continue;
                else {
                    count++;
                    initial = j+1;
                    break;
                }
            }
        }
        return count;
    }

    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];

        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        return helper(text1, text2, 0, m, 0, n, dp);
    }

    private int helper(String text1, String text2, int i, int m, int j, int n, int[][] dp) {
        if(i == m || j == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)) 
            dp[i][j] = 1 + helper(text1, text2, i+1, m, j+1, n, dp);
        else 
            dp[i][j] = Math.max(helper(text1, text2, i+1, m, j, n, dp), helper(text1, text2, i, m, j+1, n, dp));

        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}
