/**
 * Unique Paths II
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * 
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * 
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */

package DP;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) dp[i][j] = -1;
        return helper(obstacleGrid, 0, 0, m, n, dp);
    }

    public int helper(int[][] grid, int row, int col, int totalRows, int totalCols, int[][] dp) {
        if(row == totalRows - 1 && col == totalCols - 1) {
            if(grid[row][col] != 1) return 1;
            return 0;
        }

        if(row == totalRows || col == totalCols) return 0;

        if(grid[row][col] == 1) return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int right = 0, down = 0;

        // go right
        right = helper(grid, row, col+1, totalRows, totalCols, dp);

        // go down
        down = helper(grid, row+1, col, totalRows, totalCols, dp);

        dp[row][col] = right + down;
        return dp[row][col];
    }


    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int totalRows = obstacleGrid.length;
        int totalCols = obstacleGrid[0].length;

        int dp[] = new int[totalRows];
        dp[totalRows - 1] = obstacleGrid[totalRows - 1][totalCols - 1] == 1 ? 0 : 1;

        for(int i = totalRows - 2; i >= 0; i--) {
            if(obstacleGrid[i][totalCols-1] == 1) dp[i] = 0;
            else dp[i] = dp[i+1];
        }

        for (int col = totalCols - 2; col >= 0; col--) {
            for (int row = totalRows - 1; row >= 0; row--) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row] = 0;
                } else if (row != totalRows - 1) {
                    dp[row] = dp[row] + dp[row + 1];
                }
            }
        }

        return dp[0];
    }
}
