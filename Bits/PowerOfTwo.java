/**
 * 231. Power of Two
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 * Using bit manipulation to check if n is a power of two.
 * Time Complexity: O(1)
 */
package BitManipulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return ((n > 0) && (n & n-1) == 0) ? true : false;
    }
}
