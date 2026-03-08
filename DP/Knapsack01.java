/**
 * Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
 * The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
 * Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.
 */

package DP;

import java.util.*;

public class Knapsack01 {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < wt.length; i++) {
            dp.add(new HashMap<>());
        }
        
        int res = helper(W, val, wt, 0, 0, dp);
        return res == -1 ? 0 : res;
    }
    
    public int helper(int W, int val[], int wt[], int wtSum, int i, List<Map<Integer, Integer>> dp) {
        if(wtSum > W) return -1;
        
        if(i == wt.length) return 0;
        
        if(dp.get(i).containsKey(wtSum)) return dp.get(i).get(wtSum);
        
        int take = helper(W, val, wt, wtSum + wt[i], i+1, dp);
        int skip = helper(W, val, wt, wtSum, i+1, dp);
        if(take != -1) take += val[i];
        
        int res;
        
        if(take == -1 && skip == -1) res = -1;
        else if(take == -1) res = skip;
        else if(skip == -1) res = take;
        else res = Math.max(take, skip); 
        
        dp.get(i).put(wtSum, res);
        return res;
    }
}
