/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Algorithm:
 * We use backtracking to build the parentheses combinations. We keep track of the number of open and close parentheses used so far.
 * We can add an open parenthesis if we haven't used all n open parentheses yet.
 * We can add a close parenthesis if the number of close parentheses used is less than the number of open parentheses used.
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, new StringBuilder(""), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder str, int open, int close, int n) {
        if(str.length() == n * 2) {
            res.add(str.toString());
            return;
        }

        if (open < n) {
            str.append("(");
            helper(res, str, open + 1, close, n);
            str.deleteCharAt(str.length() - 1); // backtrack
        }

        if (close < open) {
            str.append(")");
            helper(res, str, open, close + 1, n);
            str.deleteCharAt(str.length() - 1); // backtrack
        }
    }
}
