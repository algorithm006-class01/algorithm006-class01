package cn.geek.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月18日 14:22:00
 */
public class LeetCode_001_363 {

    /**
     * Two sum int [ ]. 两数之和 使用hash表处理
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
     *
     * @param nums
     *            the nums
     * @param target
     *            the target
     * @return the int [ ]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number)) {
                return new int[] {map.get(number), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetCode_001_363 leetCode = new LeetCode_001_363();
        int[] result = leetCode.twoSum(new int[] {2, 15, 11, 7}, 9);
        for (int t : result) {
            System.out.print(t + " ");
        }
    }
}
