/**
 * Same as previous, but return true as soon as you find even one subset.
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumII {
    public boolean subsetSum(int[] candidates, int target) {    
        return getCombination(candidates, target, new ArrayList<Integer>(), 0, 0);
    }

    public boolean getCombination(int[] candidates, int target, List<Integer> set, int sum, int i) {
        if(sum == target) {
            return true;
        }
        if(i == candidates.length) {
            return false;
        }
        set.add(candidates[i]);
        boolean res = getCombination(candidates, target, set, sum + candidates[i], i+1);
        if(res) return res;
        set.remove(set.size()-1);
        return getCombination(candidates, target, set, sum, i+1);
    }
}
