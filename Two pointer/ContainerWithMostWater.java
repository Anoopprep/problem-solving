/*
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7], Output: 49
 * Input: height = [1,1], Output: 1
 * 
 * Just find the maxArea of the rectanglr
 * 2 pointers: 1 at the beginning and one at the end
 * find the area, if maxArea > area, maxArea = area
 * find which is less, i or j, move the one which is less, since the current area is the max for it.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, maxArea = 0;

        while(i != j || i < j) {
            int small = height[i] > height[j] ? j : i;
            int area = (j - i) * height[small];
            if(area > maxArea) maxArea = area;
            if(height[i] >= height[j]) j--;
            else i++;
        }

        return maxArea;
    };
}

