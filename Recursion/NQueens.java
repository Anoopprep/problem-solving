/**
 * 51. N-Queens
 * Algorithm:
 * We use backtracking to place queens row by row. For each row, we try placing a queen in each column and check if it's safe to place it there.
 * If it's safe, we place the queen and move to the next row. If we reach the end (row == n), we have found a valid configuration and add it to the result.
 * If placing a queen in a column leads to no solution, we backtrack by removing the queen and trying the next column.
 * 
 * Time Complexity: O(N!) in the worst case, as we may need to explore all possible placements of queens.
 * Space Complexity: O(N^2) for the board representation.
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        helper(n, board, 0, res);
        return res;
    }

    private void helper(int n, char[][] board, int row, List<List<String>> res) {
        if(row == n) {
            List<String> snapshot = new ArrayList<String>();
            for(char[] s: board) snapshot.add(new String(s));
            res.add(snapshot);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafeToPlace(row, i, board, n)) {
                board[row][i] = 'Q';
                helper(n, board, row + 1, res);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSafeToPlace(int row, int col, char[][] board, int n) {
        // Up
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row-1, j = col+1; i >= 0 && j< n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}
