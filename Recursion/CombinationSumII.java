/**
 * 40. Combination Sum II
 * Same as Combination Sum, but each number can be used only once and also there should not be duplicate combinations
 */

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        Set<String> set = new HashSet<String>();
        Arrays.sort(candidates);
        getSum(candidates, target, subset, set, res, 0, 0);
        return res;
    }

    public void getSum(int[] candidates, int target, List<Integer> subset, Set<String> set, List<List<Integer>> res, int i, int sum) {
        if(target == sum) {
            String s = String.join(",", subset.toString());
            if(!set.contains(s)) {
                set.add(s);
                res.add(new ArrayList<Integer>(subset));
            }
            return;
        }

        if(i == candidates.length || sum > target) {
            return;
        }

        subset.add(candidates[i]);
        getSum(candidates, target, subset, set, res, i+1, sum + candidates[i]);
        subset.remove(subset.size() - 1);
        getSum(candidates, target, subset, set, res, i+1, sum);

        return;
    }

    public List<List<Integer>> combinationSum2Efficient(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(candidates);
        getSumEfficient(candidates, target, subset, res, 0, 0);
        return res;
    }

    public void getSumEfficient(int[] candidates, int target, List<Integer> subset, List<List<Integer>> res, int i, int sum) {
        if(target == sum) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }

        if(i == candidates.length || sum > target) {
            return;
        }

        subset.add(candidates[i]);
        getSumEfficient(candidates, target, subset, res, i+1, sum + candidates[i]);
        subset.remove(subset.size() - 1);

        int idx = i + 1;
        while(idx < candidates.length && candidates[idx] == candidates[idx-1]) idx++;
        getSumEfficient(candidates, target, subset, res, idx, sum);

        return;
    }
}
