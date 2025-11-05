/*
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Input: strs = ["flower","flow","flight"], Output: "fl"
 * Input: strs = ["dog","racecar","car"], Output: ""
 * 
 * Algorithm:
 * Get the smallest string
 * longestPrefix = smallest string
 * Now compare with every element and keep reducing the longestPrefix if doesn't match
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = strs[0];

        for(String str: strs) {
            if(str.length() < longestPrefix.length()) longestPrefix = str;
        }

        for(String str: strs) {
            for(int i = 0; i < longestPrefix.length(); i++) {
                if(str.charAt(i) != longestPrefix.charAt(i)) {
                    if (i == 0) return "";
                    longestPrefix = longestPrefix.substring(0,i);
                    break;
                }
            }
        }
        return longestPrefix;
    }
}
