/*
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * Input: s = "the sky is blue", Output: "blue is sky the"
 * Input: s = "  hello world  ", Output: "world hello", Explanation: Your reversed string should not contain leading or trailing spaces.
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * 
 * Algorithm:
 * Travese backwards and add the words to a string
 */

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();

        int i = s.length() - 1, j = s.length() - 1;
        while(i >= 0 && j >= 0) {
            while(j >= 0 && s.charAt(j) != ' ') j--;
            res.append(s.substring(j+1, i+1));
            res.append(" ");

            while(j >= 0 && s.charAt(j) == ' ') j--;
            i = j;
        }

        return res.toString().trim();
    }
}
