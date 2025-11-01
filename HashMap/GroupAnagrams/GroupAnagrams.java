/*
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Input: strs = ["eat","tea","tan","ate","nat","bat"], Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Input: strs = [""], Output: [[""]]
 * Input: strs = ["a"], Output: [["a"]]
 * 
 * Algorithm:
 * Maintain an hashmap with sort/signature of the word as key
 */

import java.util.*;

public class GroupAnagrams {
    // TC: O(n * klogk)
    public List<List<String>> groupAnagramsSorted(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(res.get(sorted) == null) res.put(sorted, new LinkedList<String>());
            res.get(sorted).add(strs[i]);
        }
        return new LinkedList<List<String>>(res.values());
    }

    // TC: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            char[] chars = strs[i].toCharArray();
            for(int j = 0; j < chars.length; j++) {
                freq[chars[j] - 97]++;
            }
            String signature = Arrays.toString(freq);
            // or String signature = String.join(",", freq.toString());
            if(res.get(signature) == null) res.put(signature, new LinkedList<String>());
            res.get(signature).add(strs[i]);
        }
        return new LinkedList<List<String>>(res.values());
    }
}
