package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer existIndex = map.get(nums[i]);
            if (existIndex != null) {
                if (target == 2 * nums[i]) {
                    return new int[]{existIndex, i};
                }
            } else {
                map.put(nums[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> keyValue : map.entrySet()) {
            Integer key = map.get(target - keyValue.getKey());
            if (key != null && !key.equals(keyValue.getValue())) {
                return new int[]{keyValue.getValue(), key};
            }
        }
        return new int[]{};

    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] ret = twoSum.twoSum(nums, target);
        for (int i : ret) {
            System.out.println(i);
        }
    }

}
