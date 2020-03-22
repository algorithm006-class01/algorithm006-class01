package com.aizain.jhome.computer.data.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ThreeSum
 * 15. 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/2/29
 */
public class ThreeSum {

    /**
     * 审题：
     * 1 返回不重复的三元组
     * 2 会有复数，无序
     * 3 可能不存在（实际要求返回空数组）
     * 4 a+b=-c
     * 5 数组内有重复数字，结果有可能有重复
     * <p>
     * 思路：
     * 1 暴力：三重循环
     * 2 hash：两重暴力+hash
     * 3 夹逼：因为不需要下标，可以排序后夹逼
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // return directlySolution(nums);
        // return hashSolution(nums);
        // return squeezeSolution(nums);
        // return hashFastSolution(nums);
        return squeezeFastSolution(nums);
    }

    /**
     * 失败
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> hashFastSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    result.add(Arrays.asList(nums[i], exist, nums[j]));
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
                while (j < nums.length && nums[j] == nums[j + 1]) j++;
            }
        }

        return result;
    }

    /**
     * 夹逼快速版
     * <p>
     * 18 ms	45.6 MB
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> squeezeFastSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }
            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return result;
    }

    /**
     * 夹逼法
     * 899 ms	45.9 MB
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> squeezeSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(value);
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * hash slow
     * 1406 ms	46 MB
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> hashSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 暴力：超出时间限制
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> directlySolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }


}
