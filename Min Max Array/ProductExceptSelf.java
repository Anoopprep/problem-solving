/*
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 * Input: nums = [1,2,3,4], Output: [24,12,8,6]
 * Input: nums = [-1,1,0,-3,3], Output: [0,0,9,0,0]
 */

import java.util.ArrayList;
import java.util.List;

public class ProductExceptSelf {

    /*
     * Edge cases:
     * If there's one zero, find the product except 0, for every element product is 0, for 0, product is the product found.
     * If there are more than one zeros, product for all is zero
     * Used ArrayList below for learning, just declare an array of the size of input array and modify using indices.
     */
    public int[] divisionApproach(int[] nums) {
        int product = 1, noOfZeros = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int num: nums) {
            if(num == 0) noOfZeros++;
            else product *= num; 
        }
        for(int num: nums) {
            if(noOfZeros > 0) {
                if(num == 0 && noOfZeros == 1) res.add(product);
                else res.add(0);
            }
            else res.add(product/num);
        }
        // convert List<Integer> -> int[] using streams
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // Efficient: TC: O(n), SC: O(1)
    public int[] minMaxApproach(int[] nums) {
        int[] res = new int[nums.length];
        int rightProduct = 1;
        res[0] = 1;

        // Find left product
        for(int i = 1; i < nums.length; i++) {
            res[i] = nums[i-1] * res[i - 1];
        }

        for(int i = nums.length - 1; i >= 0 ; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}
