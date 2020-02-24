/* 
 * homework
 * https://leetcode-cn.com/problems/two-sum/
 * 方式一、 暴力求解法
 * 双层for循环 
 * time complexity O(n^2)
 * space complexity O(1)
 * 方式二、 使用哈希表
 * time complexity O(n) 只遍历了一边nums所以时间复杂度是O(n)
 * space complexity O(n) 空间复杂度取决于hash表中元素的个数
 *
 *
 *
 * 题目明确: 每种输入只会对应一个答案
 */
class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //    for (int i = 0; i < nums.length; i++) {
    //        for (int j = i + 1; j < nums.length; j++) {
    //            if (nums[i] + nums[j] == target) {
    //                return new int[] { i, j };
    //            }
    //        }
    //    }
   
    //    throw new IllegalArgumentException("No two sum solution");
    // }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}