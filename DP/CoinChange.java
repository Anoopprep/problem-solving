/**
 * 322. Coin Change
 * This problem is literally same as Combination Sum, but instead of counting the number of combinations, we need to find the minimum number of coins needed to make up the amount.
 */

package DP;

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer>[] dp = new HashMap[coins.length];
        for (int i = 0; i < coins.length; i++) {
            dp[i] = new HashMap<>();
        }
        return helper(coins, amount, 0, 0, dp);
    }

    public int helper(int[] coins, int amount, int add, int i, Map<Integer, Integer>[] dp) {
        if(add == amount) {
            return 0;
        }

        if(add > amount || i >= coins.length) return -1;
        
        if(dp[i].containsKey(add)) return dp[i].get(add);

        int left = helper(coins, amount, add + coins[i], i, dp);
        if (left != -1) left += 1;
        int right = helper(coins, amount, add, i+1, dp);
        int res;

        if(left == -1 && right == -1) res = -1;
        else if(left == -1) res = right;
        else if(right == -1) res = left;
        else res = Math.min(left, right);
        dp[i].put(add, res);
        return res;
    }

    public int coinChangeTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int coin: coins) {
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
