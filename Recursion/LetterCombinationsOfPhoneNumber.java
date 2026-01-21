/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Algorithm:
 * We use backtracking to generate all possible combinations. For each digit, we iterate through its corresponding letters and recursively build the combinations.
 * Time Complexity: O(3^N * 4^M) where N is the number of digits that map to 3 letters and M is the number of digits that map to 4 letters.
 */

package Recursion;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<String>();
        helper(digits, map, new StringBuilder(""), res, 0);
        return res;
    }

    private void helper(String digits, Map<Character, String> map, StringBuilder combination, List<String> res, int idx) {
        if(idx == digits.length()) {
            res.add(new String(combination));
            return;
        }

        char digit = digits.charAt(idx);
        String chars = map.get(digit);
        for(int i = 0; i < chars.length(); i++) {
            helper(digits, map, combination.append(chars.charAt(i)), res, idx+1);
            combination.deleteCharAt(combination.length() - 1);
        }
    } 
}
