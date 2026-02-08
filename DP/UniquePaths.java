/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */

package DP;

import java.util.Arrays;

public class UniquePaths {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return helper(m, n, 0, 0);
    }

    /**
     * This takes mn space plus the recursion stack space. So this can be optimized using tabulation approach
     * to just mn space.
     */
    public int helper(int m, int n, int row, int col) {
        if(dp[row][col] != 0) {
            return dp[row][col];
        }

        if(row == m || col == n) {
            return 0;
        }

        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        int right = helper(m, n, row, col + 1);
        int down = helper(m, n, row + 1, col);
        dp[row][col] = right + down;

        return dp[row][col];
    }

    /**
     * Tabulation approach: Time Complexity: O(mn), Space Complexity: O(mn)
     */
    public int uniquePathsDPTabular(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < n; i++) dp[m-1][i] = 1;
        for(int i = 0; i < m; i++) dp[i][n-1] = 1;

        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }


    /**
     * Space optimized DP approach: Time Complexity: O(mn), Space Complexity: O(m)
     * Here we are using only one array to store the previous row values and updating it for current row values.
     */
    public int uniquePathsDPEfficient(int m, int n) {
        int[] dp = new int[m];
        int temp = 1;
        Arrays.fill(dp, 1);

        for(int i = n-2; i >= 0; i--) {
            for(int j = m-2; j >= 0; j--) {
                dp[j] = temp + dp[j];
                temp = dp[j]; 
            }
            temp = 1;
        }
        return dp[0];
    }
}
