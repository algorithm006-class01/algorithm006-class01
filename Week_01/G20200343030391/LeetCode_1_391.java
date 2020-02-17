package G20200343030391;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_1_391 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum_2(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 解法1：暴力求解
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    /**
     * 解法2：hash表
     * 时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n2 = target - nums[i];
            if (hashMap.containsKey(n2)) {
                return new int[]{i, hashMap.get(n2)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
