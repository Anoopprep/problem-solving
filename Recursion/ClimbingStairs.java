/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1: Input: n = 2, Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2: Input: n = 3, Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
package Recursion;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return findDistictWays(0, n);
    }

    public int findDistictWays(int i, int n) {
        if(i > n) return 0;
        if(i == n) return 1;

        int left = findDistictWays(i+1, n);
        int right = findDistictWays(i+2, n);

        return left + right;
    }
}
