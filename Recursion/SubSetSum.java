/**
 * Find all subsets are including in result only if the sum of all elements = target
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    class Solution {
    public List<List<Integer>> subsetSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getCombination(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    public void getCombination(int[] candidates, int target, List<List<Integer>> res, List<Integer> set, int sum, int i) {
        if(i == candidates.length) {
            if(sum == target) {
                res.add(new ArrayList<Integer>(set));
            }
            return;
        }
        set.add(candidates[i]);
        getCombination(candidates, target, res, set, sum + candidates[i], i+1);
        set.remove(set.size()-1);
        getCombination(candidates, target, res, set, sum, i+1);
    }
}
}
