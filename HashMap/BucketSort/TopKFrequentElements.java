/*
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2, Output: [1,2]
 * Input: nums = [1], k = 1, Output: [1]
 * 
 * Algorithm:
 * Find the frequency using hashmap
 * Use bucket sort to put all elements in a frequency based array.
 * Collect elements from the end of the buckets array since we want max frequency
 *
 * Bucket sort:
 * Bucket sort is a distribution sort algorithm. 
 * Instead of comparing elements (like quicksort or mergesort), it groups elements into buckets based on some property — usually value range or frequency — and then sorts or collects within those buckets.
 * Each bucket represents a category or range of values
 * e.g: All numbers between 0–10 go into bucket 0. All numbers between 10–20 go into bucket 1.
 * You always have an index-based array (of buckets) — each index represents a range or category of values.
 * List<Integer>[] buckets = new ArrayList[maxRange + 1];
 * key pattern to recognize: I can map each element to a position in an array based on some numeric property (frequency, range, digit, etc.)
 * 
 * Bucket sort core algorithm:
 * 1. Divide the input into “buckets.”
 * 2. Distribute elements into the appropriate bucket.
 * 3. Sort each bucket (optional).
 * 4. Concatenate buckets back together.
 * 
 * TODO: Check PriorityQueue/Heap implementation.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        @SuppressWarnings("unchecked")
        List<Integer> [] buckets = new List[nums.length + 1];

        int[] res = new int[k];

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // Create buckets: index = frequency
        // buckets[frequency] = [element1, element2]
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if(buckets[entry.getValue()] == null) buckets[entry.getValue()] = new ArrayList<Integer>();
            buckets[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for(int i = buckets.length - 1; i > 0 && index < k; i--) {
            if(buckets[i] != null) {
                for(int num: buckets[i]) {
                    res[index++] = num;
                    if(index >= k) break;
                }
            }
        }
        return res;
    }
}
