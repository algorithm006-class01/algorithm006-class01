package com.aizain.jhome.computer.data.list;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/2/29
 */
public class TwoSum {

    /**
     * 审题：
     * 1 都是整数，有可能有复数
     * 2 返回数组下标，下标不相同
     * 3 列表无序
     * <p>
     * 思路：
     * 1 暴力：两层循环求解
     * 2 hash表：key为目标数与当前数之差
     * 3 双指针：夹逼找到是否有目标数
     * <p>
     * 反馈：
     * 1 国际站有(log n)方法，一个数据排序双指针找，单独复制出来的数组用于找回下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // return directlySolution(nums, target);
        // return hashSolution(nums, target);
        return squeezeSolution(nums, target);
    }


    /**
     * 双指针，除非列表有序
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] squeezeSolution(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * hash方式
     * <p>
     * 执行用时 : 2 ms, 在所有 Java 提交中击败了 99.50% 的用户
     * 内存消耗 : 41.5 MB, 在所有 Java 提交中击败了 5.10% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] hashSolution(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            Integer exist = map.get(v);
            if (exist != null) {
                return new int[]{exist, i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    /**
     * 暴力法
     * <p>
     * 执行用时 : 105 ms, 在所有 Java 提交中击败了 5.10% 的用户
     * 内存消耗 : 39.3 MB, 在所有 Java 提交中击败了 5.10% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] directlySolution(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
