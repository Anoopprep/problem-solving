/*
 * At any given point, we need 2nd max between left and right.
 * The trapped water at an index depends on the smaller of the maximum heights on its left and right. 
 * So while mutating the pointers, we always keep the max at same position and switch the smaller one between left and right.
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length, leftMax = height[0], rightMax = height[n-1];
        int i = 0, j = n - 1, res = 0;

        while(i <= j) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[i]);
                res += leftMax - height[i];
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
