
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_377 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer left = map.get(nums[i]);
            if (null != left) {
                return new int[]{left, i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

