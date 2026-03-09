/**
 * 516. Longest Palindromic Subsequence
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * 
 * Algotithm:
 * Just reverse the string and find the longest common subsequence between the original string and the reversed string.
 */

package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s2 = sb.toString();

        int[][] dp = new int[n][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return helper(s, 0, s2, 0, n, dp);
    }

    private int helper(String s1, int i, String s2, int j, int n, int[][] dp) {
        if(i == n || j == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) 
            dp[i][j] = 1 + helper(s1, i+1, s2, j+1, n, dp);
        
        else dp[i][j] = Math.max(helper(s1, i+1, s2, j, n, dp), helper(s1, i, s2, j+1, n, dp));
        return dp[i][j];
    }

    /**
     * This is optimal approach since we are not creating a new string and just using the original string and comparing the characters from both ends.
     */
    public int longestPalindromeSubseqRecursive(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, dp);
    }

    private int helper(String s, int i, int j, Integer[][] dp) {
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + helper(s, i+1, j-1, dp);
        }

        return dp[i][j] = Math.max(
            helper(s, i+1, j, dp),
            helper(s, i, j-1, dp)
        );
    }
}
