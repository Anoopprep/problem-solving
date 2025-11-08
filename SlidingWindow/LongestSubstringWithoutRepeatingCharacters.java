/*
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Input: s = "abcabcbb", Output: 3, Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Input: s = "bbbbb", Output: 1, Explanation: The answer is "b", with the length of 1.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, res = 0;
        Set<Character> set = new HashSet<Character>();

        while(i<s.length() && j < s.length()) {
            while(j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }

            if(j - i > res) res = j - i;
            while(i < s.length() && j < s.length() && s.charAt(i) != s.charAt(j)){
                set.remove(s.charAt(i));
                i++;
            }
            i++;
            j++;
        }
        return res;
    }
}
