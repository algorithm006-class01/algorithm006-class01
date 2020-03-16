import java.util.*;
/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i = 0; i < stones.length; i ++) 
            dp.put(stones[i], new HashSet<>());
        dp.get(0).add(0);
        for (int i = 0; i < stones.length; i ++) 
            for (int last : dp.get(stones[i])) 
                for (int next = last - 1; next <= last + 1; next ++) 
                    if (next > 0 && dp.containsKey(stones[i] + next)) 
                        dp.get(stones[i] + next).add(next);
        int lastStone = stones[stones.length - 1];
        return !dp.get(lastStone).isEmpty();
    }
}
// @lc code=end

