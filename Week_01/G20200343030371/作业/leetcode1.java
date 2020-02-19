package com;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        //思考: 首先想到的方法是就是嵌套循环的暴力破解法，最简单也最直接，但是时间复杂度为O(n^2)
        // 解法1：暴力破解法
        //执行耗时:38 ms,击败了18.29% 的Java用户
        //内存消耗:45.6 MB,击败了5.04% 的Java用户
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};

        // 解法2：上述的解法时间复杂度较高，能否通过减少一层循环来进行优化呢？
        // 如果要减少循环首先要考虑几个问题 只用一层循环需要让数组中的一个数和其他数进行相加
        // 判断是否等于target 以空间换取速度的方式 通过map将值作为Key Value作为下标，通过第一次循环将数据
        // 存入map中，第二循环target - nums[i] 是否等于map中的key，判断map中是否存在这个key
        // 如果存在这返回（i，value) map中判断key是否存在的时间复杂度近似常数为O(1) map
        // 会通过key得到hash 找到数组中的位置，然后找到存储的链表中的key
//        Map<Integer, Integer> map = new HashMap<>();
//        //通过map来存储下标和值
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int t = target - nums[i];
//            //不能是同一个位置
//            if (map.containsKey(t) && map.get(t) != i) {//&& map.get(t) != i 需要注意如果第一个是3 target = 6 那么
//                //得到的结果就是{0,0} 肯定是不对的
//                return new int[]{i, map.get(t)};
//            }
//        }
//        return new int[]{};
        //	执行耗时:4 ms,击败了72.73% 的Java用户
        //	内存消耗:46.4 MB,击败了5.04% 的Java用户

        //解法3：上述解法优化了时间复杂度，但是上述解法中存在两个循环，能否只剩下一个循环呢？
        //思考：int t = target - nums[i]; map.put(t,0) [2,17,7,15] target = 9
        //9 - 2 = 7 map.put(2,0), 9 - 17 = -8 map.put(17,1), 9 - 7 = 2, map.get(2) = 0 {0,2}
        //从上述的解法中我们可以得到一个推论：
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t) && map.get(t) != i) {
                return new int[]{map.get(t), i};//map.get(t) 肯定小于 i因为map 存储的都是i之前的
            } else {
                //如果不存在记录 继续下一个
                map.put(nums[i], i);
            }
        }
        return new int[]{};
        //在时间复杂度上差不多到了一个极致的优化
        //执行耗时:3 ms,击败了97.23% 的Java用户
        //内存消耗:46.8 MB,击败了5.04% 的Java用户
    }
}
