/**
 * 73. Set Matrix Zeroes
 * Use a map to store the positions of zeros, then set corresponding rows and columns to zero.
 * Time Complexity: O(m * n)
 * 
 * Efficient Approach without extra space:
 * 1. Use the first row and first column of the matrix as markers.
 * 2. First, check if the first row and first column need to be zeroed
 * 3. Then, iterate through the rest of the matrix. If an element is zero, set the corresponding first row and first column elements to zero.
 * 4. Next, iterate through the matrix again (excluding the first row and column)
 *   and set elements to zero if their corresponding first row or first column element is zero.
 * 5. Finally, zero out the first row and first column if needed.
 * Time Complexity: O(m * n)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Map<Integer, ArrayList<Integer>> zeros = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    ArrayList<Integer> arr = zeros.get(i);
                    if(arr == null) {
                        arr = new ArrayList<Integer>();
                        zeros.put(i, arr);
                    }
                    arr.add(j);
                }
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: zeros.entrySet()) {
            Integer row = entry.getKey();
            ArrayList<Integer> col = entry.getValue();

            for(Integer eachCol: col) {
                int i = eachCol - 1;
                while(i >= 0) {
                    matrix[row][i--] = 0;
                }

                i = eachCol + 1;
                while(i < matrix[0].length) {
                    matrix[row][i++] = 0;
                }

                i = row - 1;
                while(i >= 0) {
                    matrix[i--][eachCol] = 0;
                }

                i = row + 1;
                while(i < matrix.length) {
                    matrix[i++][eachCol] = 0;
                }
            }
        }
    }

    public void setZeroesNoExtraSpace(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1️⃣ Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 2️⃣ Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 3️⃣ Use first row & column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4️⃣ Zero cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5️⃣ Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 6️⃣ Zero first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
