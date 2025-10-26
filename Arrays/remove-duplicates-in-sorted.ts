/**
 * Leetcode 26. Remove Duplicates from Sorted Array (ascending)
 * Time complexity - O(n)
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */

function removeDuplicates(nums: number[]): number {
    let index = 1;
    for (let i = 1; i < nums.length; i++) {
        while(nums[i] === nums[i-1]) i++;
        if(i < nums.length) {
            nums[index] = nums[i];
            index++;
        }
        else if(i===index) index++;
    }
    return index;
};