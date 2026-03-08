/**
 * 403. Frog Jump
 * A frog is crossing a river. The river is divided into x units and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 */

package DP;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        Map<String, Boolean> dp = new HashMap<>();
        for(int i = 0; i < stones.length; i++)
            valueToIndex.put(stones[i], i);
        return helper(stones, 0, 0, valueToIndex, dp);
    }

    private boolean helper(int[] stones, int position, int lastJumpUnit, Map<Integer, Integer> valueToIndex, Map<String, Boolean> dp) {
        if(position == stones.length - 1)
            return true;

        if(position == 0 && !valueToIndex.containsKey(1)) return false;
        
        String key = position + "," + lastJumpUnit;
        if(dp.containsKey(key)) return dp.get(key);

        int current = stones[position];
        
        for (int jump = lastJumpUnit - 1; jump <= lastJumpUnit + 1; jump++) {
            if (jump <= 0) continue;
            int target = current + jump;
            if (valueToIndex.containsKey(target)) {
                int nextIndex = valueToIndex.get(target);

                if (helper(stones, nextIndex, jump, valueToIndex, dp)) {
                    dp.put(key, true);
                    return true;
                }
            }
        }
        dp.put(key, false);
        return false;
    }
}
