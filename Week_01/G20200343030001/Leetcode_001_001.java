package Week_01;

import java.util.HashMap;

public class Leetcode_001_001 {
    // 暴力法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // hash表法,一次遍历过程中完成hash表构建和查找元素功能，善用target
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i];

            if (index.containsKey(target - idx)) {
                return new int[] {index.get(target - idx), i};
            }

            index.put(idx, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
