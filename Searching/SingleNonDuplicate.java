/**
 * 540: Single Element in a Sorted Array - Medium
 * 
 * Problem Statement:
 * You are given a sorted array consisting of only integers where every element appears exactly 
 * twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * Algorithm:
 * Uses binary search to find the single element by analyzing the parity of indices.
 * In a normal array where all elements appear twice, the first occurrence of each pair
 * is at even index and second occurrence is at odd index. The single element breaks
 * this pattern.
 * If mid is paired with left element and (mid-1) is even, single element is on right
 * If mid is paired with left element and (mid-1) is odd, single element is on left
 * If mid is paired with right element and mid is even, single element is on right
 * If mid is paired with right element and mid is odd, single element is on left
 * 
 * Edge Cases:
 * - Single element array
 * - Single element at the beginning
 * - Single element at the end
 */

public class SingleNonDuplicate {
    public static int bruteForce(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i = 0, j = 1;
        while(j<nums.length) {
            if(nums[i] != nums[j]) return nums[i];
            i += 2;
            j += 2;

            if(j>nums.length-1) {
                return nums[nums.length-1];
            }
        }
    }

    public int singleNonDuplicateUsingBinarySearch(int[] nums) {
        int i = 0, j = nums.length - 1, res = -1;

        if(j == 0) return nums[j];

        while(i <= j) {
            int mid = (int)Math.floor((i+j)/2);

            if(mid == 0 || mid == nums.length - 1) return nums[mid];
            
            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                res = nums[mid];
                break;
            }

            if(nums[mid - 1] == nums[mid]) {
                if((mid - 1) % 2 == 0) i = mid + 1;
                else j = mid - 1;
            }
            else {
                if(mid % 2 == 0) i = mid + 1;
                else  j = mid - 1;
            }
        }
        return res;
    }
}
