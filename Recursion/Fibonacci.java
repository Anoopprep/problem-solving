package Recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // Iterative approach: Time Complexity: O(n)
    public int fibIterative(int n) {
        if(n == 0) return 0;

        int[] fibb = new int[n + 1];

        fibb[0] = 0;
        fibb[1] = 1;

        int i = 2;
        while(i <= n) {
            fibb[i] = fibb[i-1] + fibb[i-2];
            i++;
        }
        return fibb[i - 1];
    }

    // Recursive approach: Takes too much time, computes redundantly for each branch: Time Complexity: O(2^n)
    public int fibRecursive(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }

    // Recursive efficient approach: Time Complexity: O(n)
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(this.map.containsKey(n)) return map.get(n);
        int res = fib(n-1) + fib(n-2);
        map.put(n, res);
        return res;
    }
}
