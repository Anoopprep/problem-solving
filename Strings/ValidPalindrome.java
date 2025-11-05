/*
 * 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Input: s = "A man, a plan, a canal: Panama", Output: true, Explanation: "amanaplanacanalpanama" is a palindrome.
 * Input: s = "race a car", Output: false, Explanation: "raceacar" is not a palindrome.
 * Input: s = " ", Output: true, Explanation: s is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // String sanitized = ""; Don't do this since when appending, it always creates a new string
        StringBuilder sanitized = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            int ascii = (int)s.charAt(i);
            if((ascii >=48 && ascii <= 57) || (ascii >=65 && ascii <= 90) || (ascii >=97 && ascii <= 122))
                sanitized.append(Character.toLowerCase(s.charAt(i)));
        }

        int i = 0, j = sanitized.length() - 1;
        while(i < j) {
            if(sanitized.charAt(i) != sanitized.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
