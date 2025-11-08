/*
 * 438. Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * Input: s = "cbaebabacd", p = "abc", Output: [0,6], Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc"
 * Input: s = "abab", p = "ab", Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Algorithm:
 * For each window, compute the hashSignature and compare with the hashSignature of p.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> bruteForceTimeExceeded(String s, String p) {
        int windowSize = p.length();
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < windowSize; i++) freq[p.charAt(i) - 97]++;
        String hashSignature = Arrays.toString(freq);

        for(int i = 0; i < s.length() - windowSize + 1; i++) {
            StringBuilder window = new StringBuilder(s.substring(i, i + windowSize));
            Arrays.fill(freq, 0);
            for(int j = 0; j < window.length(); j++) freq[window.charAt(j) - 97]++;
            String windowSignature = Arrays.toString(freq);

            if(windowSignature.equals(hashSignature)) res.add(i);
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<Integer>();
        int windowSize = p.length();
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < windowSize; i++) freq[p.charAt(i) - 97]++;
        String hashSignature = Arrays.toString(freq);

        Arrays.fill(freq, 0);
        for(int j = 0; j < p.length(); j++) freq[s.charAt(j) - 97]++;

        if (Arrays.toString(freq).equals(hashSignature)) 
        res.add(0);

        for(int i = 1; i < s.length() - windowSize + 1; i++) {
            freq[s.charAt(i - 1) - 97]--;
            freq[s.charAt(i + windowSize - 1) - 97]++;
            String windowSignature = Arrays.toString(freq);

            if(windowSignature.equals(hashSignature)) res.add(i);
        }
        return res;
    }
}
