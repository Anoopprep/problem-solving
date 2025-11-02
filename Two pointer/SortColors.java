/*
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * Could you come up with a one-pass algorithm using only constant extra space?
 * Input: nums = [2,0,2,1,1,0], Output: [0,0,1,1,2,2]
 * Input: nums = [2,0,1], Output: [0,1,2]
 * 
 * Algorithm:
 * Take 3 pointers, low, mid and high
 * low focuses on 0, mid on 1 and high on 2
 * For every iteration, we make sure the element at mid will be placed at the right place.
 * If mid has 1, do nothing since it's in the right place, mid++
 * If mid has 0, you swap it with low. Now low has 0 so low++ and mid++
 * If mid has 2, you swap it with high, but you are not sure where now mid has 0 or 1, so just high--
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while(mid <= high) {
            if(nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1) mid++;
            else if(nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
