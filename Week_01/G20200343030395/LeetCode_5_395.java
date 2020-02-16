package Week_01.G20200343030395;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_5_395 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};

        int[] ret = twoSum(nums1, 9);
        System.out.println(Arrays.toString(ret));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] x = new int[2];
        for(int i = 0;i<nums.length-2; ++i) {
            for(int j=i+1;j<nums.length-1;++j){
                if(nums[i] + nums[j] == target) {
                    x[0] = i;
                    x[1] = j;
                    return x;
                }
            }
        }

        return new int[0];
    }

    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
