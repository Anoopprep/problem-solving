public class MissingNumber {
    public int usingSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int sumOfNnumbers = (n * (n + 1))/2;
        return sumOfNnumbers - sum;
    }

    public int usingXor(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor^=num;
        }

        for(int i = 0; i<=nums.length; i++) {
            xor^=i;
        }

        return xor;
    }
}
