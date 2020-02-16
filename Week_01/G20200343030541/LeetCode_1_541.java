import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_541 {
    public int[] twoSumSolution1(int[] nums, int target) {
        for (int i = 0; i< nums.length; i++) {
           for (int j = i + 1; j < nums.length; j++) {
               if ( nums[i] + nums[j] == target) {
                    return new int[] {i, j};
               }
           }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumSolution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[] {map.get(remaining), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetCode_1_541 test = new LeetCode_1_541();
        int[] nums = {1,2,3,4,5,6};
        int target = 3;
        int[] result = test.twoSumSolution2(nums, target);
        for (int aResult : result) {
            System.out.println(aResult);
        }
    }
}
