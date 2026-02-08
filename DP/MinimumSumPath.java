package DP;

public class MinimumSumPath {
    int res = Integer.MAX_VALUE;
    // Brute Force Approach: We can use a recursive approach to explore all possible paths from the top-left corner to the bottom-right corner of the grid. 
    // We will keep track of the current path sum and update the minimum path sum whenever we reach the bottom-right corner. The recursion will explore both right and down directions at each step.
    public int minPathSumBrute(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        helperBrute(grid, 0, 0, 0, totalRows, totalCols);
        return res;
    }

    private void helperBrute(int[][] grid, int row, int col, int pathSum, int totalRows, int totalCols) {
        if(row == totalRows - 1 && col == totalCols - 1) {
            pathSum += grid[row][col];
            if(pathSum < res) res = pathSum;
            return;
        }

        if(row >= totalRows || col >= totalCols) return;

        helperBrute(grid, row, col+1, pathSum + grid[row][col], totalRows, totalCols);
        helperBrute(grid, row+1, col, pathSum + grid[row][col], totalRows, totalCols);
    }

    /**
     * Memoization Approach: We can optimize the brute force approach by using a memoization technique. 
     * We will create a 2D array (dp) to store the minimum path sum for each cell in the grid.
     */
    public int minPathSumMemoiz(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int[][] dp = new int[totalRows][totalCols];
        return helperMemoiz(grid, 0, 0, totalRows, totalCols, dp);
    }

    private int helperMemoiz(int[][] grid, int row, int col, int totalRows, int totalCols, int[][] dp) {
        if(row >= totalRows || col >= totalCols) {
            return Integer.MAX_VALUE;
        }

        if(row == totalRows-1 && col == totalCols-1) {
            return grid[row][col];
        }

        if(dp[row][col] != 0) return dp[row][col];

        int right = helperMemoiz(grid, row, col+1, totalRows, totalCols, dp);
        int down = helperMemoiz(grid, row+1, col, totalRows, totalCols, dp);
        dp[row][col] = grid[row][col] + Math.min(right, down);
        return dp[row][col];
    }

    public int minPathSumTab(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        int[] tab = new int[totalRows];
        tab[totalRows - 1] = grid[totalRows - 1][totalCols - 1];
        for(int i = totalRows - 2; i >= 0; i--) {
            tab[i] = tab[i+1] + grid[i][totalCols - 1];
        }

        for(int col=totalCols - 2; col >= 0; col--) {
            tab[totalRows - 1] = grid[totalRows - 1][col] + tab[totalRows - 1];
            for(int row=totalRows - 2; row >=0; row--) {
                tab[row] = grid[row][col] + Math.min(tab[row], tab[row+1]);
            }
        }

        return tab[0];
    }
}
