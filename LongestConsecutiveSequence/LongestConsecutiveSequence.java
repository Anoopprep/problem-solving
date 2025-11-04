/*
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Input: nums = [100,4,200,1,3,2], Output: 4, Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Input: nums = [0,3,7,2,5,8,4,6,0,1], Output: 9
 * 
 * Algorithm:
 * Add all elements into a set
 * Start counting only if the number is the starting of the sequence, meaning don't count if nums-1 exist.
 */

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence{
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        // Can't create a set directly from array by passing to constructor, because it doesn't exists.
        // Can't do Set<Integer> set = new HashSet<Integer>(Arrays.toList(nums)) since it's an int[] not Integer[].
        for(int num: nums) set.add(num);

        for(int num: set) {
            if(!set.contains(num-1)) {
                int length = 1;
                int current = num;

                while(set.contains(current + 1)) {
                    length += 1;
                    current += 1;
                }

                max = Math.max(max, length);
            }
        }
        return max;
    }
}
