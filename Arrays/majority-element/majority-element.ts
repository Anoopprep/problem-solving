/**
 * In typescript, keys at runtime are always strings, so doing parseInt at the end.
 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 * Input: nums = [3,2,3]
 * Output: 3
 */

function majorityElementUsingHashMap(nums: number[]): number {
    let majorityElement;
    let res: Record<number, number> = {};
    for(let i = 0; i < nums.length; i++) {
        if(res[nums[i]] === undefined) {
            res[nums[i]] = 1;
        } else res[nums[i]]++;
    }

    Object.entries(res).forEach(([key, value])=>{
        if(value as number > nums.length/2) {
            majorityElement = key;
            return;
        }
    });
    return parseInt(majorityElement!, 10);
};
