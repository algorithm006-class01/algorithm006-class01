package com.kidand.homework;

import java.util.HashMap;
/**
*
*  ██╗  ██╗██╗██████╗  █████╗ ███╗   ██╗██████╗
*  ██║ ██╔╝██║██╔══██╗██╔══██╗████╗  ██║██╔══██╗
*  █████╔╝ ██║██║  ██║███████║██╔██╗ ██║██║  ██║
*  ██╔═██╗ ██║██║  ██║██╔══██║██║╚██╗██║██║  ██║
*  ██║  ██╗██║██████╔╝██║  ██║██║ ╚████║██████╔╝
*  ╚═╝  ╚═╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝
*
* @description:LeetCode_001_413 两数之和
* @author: Kidand
* @date: 2020/2/15 1:42 下午
* Copyright © 2019-Kidand. 
*/
public class LeetCode_001_413 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 将原本为两个目标值切换为一个目标值，只需要每次从 map 中寻找目标值即可
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            // 每次遍历过的值都存储到 map 中，这样之后就能从 map 中寻找需要的目标值
            map.put(nums[i], i);
        }
        return null;
    }
}
