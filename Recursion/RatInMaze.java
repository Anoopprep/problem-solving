/**
 * Rat in a Maze Problem
 *  Given a square matrix of size N x N. A rat is placed at (0, 0) and has to reach (N-1, N-1). 
 *  The rat can move in four directions: Up, Down, Left, Right. 
 *  Find all possible paths that the rat can take to reach the destination. The path should be represented as a string of characters where 'U' = Up, 'D' = Down, 'L' = Left, 'R' = Right.
 *  
 *  Algorithm:
 *  We use backtracking to explore all possible paths from the starting point to the destination. We maintain a visited matrix to avoid cycles and build the path string as we move.
 *  
 *  Time Complexity: O(4^(N*N)) in the worst case where N is the size of the maze.
 *  Space Complexity: O(N*N) for the visited matrix and recursion stack.
 * 
 * NOTE: Visited array here is not needed for backtracking, it's needed to avoid cycles in a same path since the rat can move in all 4 directions. 
 * If we don't use visited array, we will end up in infinite loop.
 */

package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatInMaze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<String>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        helper(maze, 0, 0, new StringBuilder(""), visited, res);
        Collections.sort(res);
        return res;
    }
    
    private void helper(int[][] maze, int row, int col, StringBuilder path, int[][] visited, ArrayList<String> res) {
        int m = maze.length;
        int n = maze[0].length;
        
        if(row == m - 1 && col == n - 1 && maze[row][col] == 1) {
            res.add(new String(path));
            return;
        }
        
        int up = row - 1, down = row + 1, right = col + 1, left = col -1;
        
        // up
        if(up >=0 && maze[up][col] == 1 &&  visited[up][col] != 1) {
            visited[row][col] = 1;
            helper(maze, up, col, path.append("U"), visited, res);
            path.deleteCharAt(path.length() - 1);
            visited[row][col] = 0;
        }
        
        if(down < m && maze[down][col] == 1 && visited[down][col] != 1) {
            visited[row][col] = 1;
            helper(maze, down, col, path.append("D"), visited, res);
            path.deleteCharAt(path.length() - 1);
            visited[row][col] = 0;
        }
        
        if(left >= 0 && maze[row][left] == 1 && visited[row][left] != 1) {
            visited[row][col] = 1;
            helper(maze, row, left, path.append("L"), visited, res);
            path.deleteCharAt(path.length() - 1);
            visited[row][col] = 0;
        }
        
        if(right < n && maze[row][right] == 1 && visited[row][right] != 1) {
            visited[row][col] = 1;
            helper(maze, row, right, path.append("R"), visited, res);
            path.deleteCharAt(path.length() - 1);
            visited[row][col] = 0;
        }
        
    }
}
