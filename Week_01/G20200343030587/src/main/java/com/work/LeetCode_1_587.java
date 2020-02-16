package com.work;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
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

public class LeetCode_1_587 {
    public int[] twoSum(int[] nums, int target) {
        //暴力法
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        //hashmap 二次循环
        // Map<Integer,Integer> map = new HashMap();
        // for(int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], i);
        // }
        // for(int i = 0; i < nums.length; i++) {
        //     Integer num = map.get(target - nums[i]);
        //     if(num != null && num != i) {
        //         return new int[]{i,num};
        //     }
        //}

        //hashmap 一次循环
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if(val != null && val.intValue() != i){
                return new int[]{i,val};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
