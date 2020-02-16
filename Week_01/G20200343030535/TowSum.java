package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TowSum {

    /***
     * 题目：
     * https://leetcode-cn.com/problems/two-sum/
     */


    public static int[] twoSum1(int[] nums, int target) {
        /**使用哈希的数据结构特点和jdk自带函数来解决*/
        int[] indexValue = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                indexValue[0] = i;
                indexValue[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return indexValue;
    }

    public static int[] twoSum(int[] nums, int target) {
        /**暴力法*/
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

    public static void main(String[] args) {
        int[] A = {2,7,11,15};
        int[] index = twoSum1(A,9);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }
}
