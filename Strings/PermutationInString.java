/**
 * 567. Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * 
 * Algorithm:
 * Find frequency of characters in s1
 * Use sliding window of size s1.length() over s2 and find frequency of characters in the window
 * If frequency matches with that of s1, return true   
 */

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int[] freq = new int[26];

        for(int i = 0; i < windowSize; i++) freq[s1.charAt(i) - 97]++;
        String hashSignature = Arrays.toString(freq);

        Arrays.fill(freq, 0);
        for(int j = 0; j < s1.length(); j++) freq[s2.charAt(j) - 97]++;

        if (Arrays.toString(freq).equals(hashSignature)) return true;

        for(int i = 1; i < s2.length() - windowSize + 1; i++) {
            freq[s2.charAt(i - 1) - 97]--;
            freq[s2.charAt(i + windowSize - 1) - 97]++;
            String windowSignature = Arrays.toString(freq);

            if(windowSignature.equals(hashSignature)) return true;
        }
        return false;
    }
}
