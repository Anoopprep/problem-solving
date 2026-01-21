/**
 * 52. N-Queens II
 * Same as N-Queens but we only need to return the count of distinct solutions.
 */

package Recursion;

public class NQueensII {
    int res = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        helper(board, n, 0);
        return res;
    }

    private void helper(char[][] board, int n, int row) {
        if(row == n) {
            res++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafeToPlace(board, row, i, n)) {
                board[row][i] = 'Q';
                helper(board, n, row+1);
                board[row][i] = '.';
            }
        }
    }

    public int totalNQueensAddApproach(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        return helper2(board, n, 0);
    }

    private int helper2(char[][] board, int n, int row) {
        int count = 0;
        if(row == n) {
            return 1;
        }

        for(int i = 0; i < n; i++) {
            if(isSafeToPlace(board, row, i, n)) {
                board[row][i] = 'Q';
                count += helper2(board, n, row+1);
                board[row][i] = '.';
            }
        }
        return count;
    }

    private boolean isSafeToPlace(char[][] board, int row, int col, int n) {
        for(int i = row - 1; i >= 0; i--)
            if(board[i][col] == 'Q') return false;

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) 
            if(board[i][j] == 'Q') return false;

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) 
            if(board[i][j] == 'Q') return false;

        return true;
    }
}
