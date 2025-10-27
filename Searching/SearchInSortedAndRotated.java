/*
 * 33. Search in Rotated Sorted Array
 * Works for both left and right rotated and ASCENDINGLY sorted
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array 
 * is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * Input: nums = [4,5,6,7,0,1,2], target = 0, Output: 4
 * Input: nums = [4,5,6,7,0,1,2], target = 3, Output: -1
 */

 class SearchInSortedAndRotated {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            if(nums[i] == target) return i;
            if(nums[j] == target) return j;

            int mid = (int)Math.floor((i+j)/2);
            if(nums[mid] == target) return mid;

            if(nums[i] <= nums[mid]) {
                if(nums[i] < target && target < nums[mid]) j = mid - 1;
                else i = mid + 1;
            }
            else {
                if(nums[mid] < target && target < nums[j]) i = mid + 1;
                else j = mid - 1;
            }
        }
        return -1;
    }
}