/**
 * 37. Sudoku Solver
 * Algorithm:
 * We use backtracking to fill the Sudoku board. We try placing digits from '1' to '9' in each empty cell and check if it's valid.
 * If valid, we recursively attempt to fill the next cell. If we reach a point where no digit can be placed, we backtrack.
 * 
 * Time Complexity: O(9^K) in case of K empty cells
 * O(9^(m*n)) in the worst case, where m and n are the dimensions of the board (9x9) where all cells are empty.
 * Space Complexity: O(1) as we are modifying the board in place.
 */

package Recursion;

class SudukoSolver {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        if(row == 9) return true;

        int nextRow = col == 8 ? row + 1 : row;
        int nextCol = col == 8 ? 0 : col + 1;

        if(board[row][col] != '.') {
            return helper(board, nextRow, nextCol);
        }

        for(int dig = 1; dig <= 9; dig++) {
            char ch = (char)(dig + '0');
            if(isSafeToPlace(board, row, col, ch)) {
                board[row][col] = ch;
                if(helper(board, nextRow, nextCol)) return true;
                board[row][col] = '.';
            }
        }

        return false;
    }
    
    private boolean isSafeToPlace(char[][] board, int row, int col, char ch) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == ch) return false;
        }

        for(int i = 0; i < 9; i++) {
            if(board[i][col] == ch) return false;
        }

        int initRow = (row / 3) * 3;
        int initCol = (col / 3) * 3;

        for(int i = initRow; i < initRow + 3; i++)
            for(int j = initCol; j < initCol + 3; j++)
                if(board[i][j] == ch)
                    return false;

        return true;
    }
}