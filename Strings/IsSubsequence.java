/*
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Input: s = "abc", t = "ahbgdc", Output: true
 * Input: s = "axc", t = "ahbgdc", Output: false
 * 
 * Algorithm:
 * Make sure if all characters of small exists in large but in order
 * Take an index for large, for every small[i], find if it exists in large, after finding, continue at index+1 for large
 */

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int[] freq = new int[26];

        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            while(index < t.length() &&s.charAt(i) != t.charAt(index)) index++;
            if(index == t.length()) return false;
            index++;
        }
        return true;
    }
}