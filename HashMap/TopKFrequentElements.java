/*
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2, Output: [1,2]
 * Input: nums = [1], k = 1, Output: [1]
 * 
 * Algorithm:
 * Find the frequency using hashmap
 * Find k max elements by finding max and removing that max from map to compute new max for next iteration.
 *
 * TODO: Check PriorityQueue/Heap implementation.
 */

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int[] res = new int[k];

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < k; i++) {
            int max = 0, maxKey = Integer.MIN_VALUE;
            for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            res[i] = maxKey;
            freq.remove(maxKey);
        }

        return res;
    }
}
