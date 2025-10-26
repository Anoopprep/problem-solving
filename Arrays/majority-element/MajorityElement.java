import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElementUsingHashMap(int[] nums) {
        int majorityElement = 0;
        Map<Integer, Integer> res = new HashMap<>();

        // Count occurrences
        for (int num : nums) {
            res.put(num, res.getOrDefault(num, 0) + 1);
        }

        // Find the majority element
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                majorityElement = entry.getKey();
                break;
            }
        }

        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElementUsingHashMap(nums)); // Output: 3
    }
}
