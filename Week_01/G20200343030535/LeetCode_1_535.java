package leetcode.Week01;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_535 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 思路1： 暴力法 time : o(n^2)
     * 思路2： 哈希法 time : o(n)
     */

    public static int[] twoSum1(int[] nums, int target) {
        int[] indexValue = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    indexValue[0] = i;
                    indexValue[1] = j;
                    break;
                }
            }
        }
        return indexValue;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /**原因是题目的限定条件：你不能重复利用这个数组中同样的元素。
             * 利用map的key是唯一的，将数组进行去重
             * */
            int value = target - nums[i];
            if (map.containsKey(value)){
                return new int[]{i,map.get(value)};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] A = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum2(A,target);
        System.out.println("符合条件的的下标是：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(i + ",");
        }
    }

}
