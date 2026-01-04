import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        int dir = 0;
        List<Integer> res = new LinkedList<Integer>();

        while (top <= bottom && left <= right) {
            if(dir == 0) {
                for(int i = left; i <= right; i++) res.add(matrix[top][i]);
                top++;
            }
            if(dir == 1) {
                for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
                right--;
            }
            if(dir == 2) {
                for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
                bottom--;
            }
            if(dir == 3) {
                for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
