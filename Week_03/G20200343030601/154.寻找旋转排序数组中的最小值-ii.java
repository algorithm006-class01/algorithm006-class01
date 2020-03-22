/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (46.29%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 30.2K
 * Testcase Example:  '[1,3,5]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 注意数组中可能存在重复的元素。
 * 
 * 示例 1：
 * 
 * 输入: [1,3,5]
 * 输出: 1
 * 
 * 示例 2：
 * 
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 
 * 说明：
 * 
 * 
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * 
 * 
 */

 /*
 * 思路：
 * if lo值 == hi值
 *    将hi前移，直至hi值与lo值不等，或直至仅剩一个元素；
 * if array中仅有一个item 或 lo值 < hi值
 *    即递增array，直接返回lo值
 * if lo值 > mid值
 *    说明旋转点在lo和mid中间，递归处理该片段；
 * if lo值 == mid值
 *    说明lo到mid段值全相等（如果旋转点在lo和mid间，则后半段全与mid值也相等，与前面处理相违背）
 *    递归处理后半段
 * if mid值 > hi值
 *    说明旋转点在mid和hi中间，递归处理该片段；
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            while (lo < hi && nums[lo] == nums[hi])
                hi--;
            if (lo == hi || nums[lo] < nums[hi])
                return nums[lo];

            int mid = lo + (hi - lo) / 2;
            if (nums[lo] > nums[mid])
                hi = mid;
            else
                lo = mid + 1;
        }

        return nums[lo];
    }

    // public int findMin(int[] nums) {
    //     int lo = 0, hi = nums.length -1;

    //     while (lo < hi && nums[lo] > nums[hi]) {            
    //         // 数组片段长度>=2，且中间有起伏（旋转点在中间）
    //         int mid = (hi + lo) / 2;
    //         if (nums[lo] <= nums[mid])
    //             lo = mid + 1; // mid前(含mid)递增，旋转点在mid之后
    //         else
    //             hi = mid;  // mid前的片段有起伏，旋转点在mid前
    //     }

    //     // 数组片段仅有一个元素，或数组是递增的，直接返回第一个值
    //     return nums[lo];
    // }
}
// @lc code=end

