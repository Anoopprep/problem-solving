/**
 * 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getCombination(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    public void getCombination(int[] candidates, int target, List<List<Integer>> res, List<Integer> subset, int sum, int i) {
        if(sum == target) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        if(i == candidates.length || sum > target) {
            return;
        }
        subset.add(candidates[i]);
        getCombination(candidates, target, res, subset, sum + candidates[i], i);
        subset.remove(subset.size()-1);
        getCombination(candidates, target, res, subset, sum, i+1);
    }
}
