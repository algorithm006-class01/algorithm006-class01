/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.21%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    33.5K
 * Total Submissions: 66.8K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

/*
* 思路: 二分思想 旋转数组中最小值，要么在数组的左半部分，要么在数组的右半部分
* if 数组仅有一个元素或，lo值 < hi值
     数据是递增的，返回第一个值即可
* if mid值 > hi值
*    说明从lo到mid过程中经历过增长、猛降后再增长，最小值则在右半部分；
*    递归处理右半部分；
* else
*    即最小值在左半部分；  
*    递归处理左半部分；
*
* Note：注意有可能mid值恰好是最小值，所以不管左侧还是右侧递归，都带着mid值。
*       (递归改为循环，以下代码经过精简)
*/

// @lc code=start
class Solution {
    /*
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi && nums[lo] > nums[hi]) {            
            // 数组片段长度>=2，且中间有起伏（旋转点在中间）
            int mid = (hi + lo) / 2;
            if (nums[lo] <= nums[mid])
                lo = mid + 1; // mid前(含mid)递增，旋转点在mid之后
            else
                hi = mid;  // mid前的片段有起伏，旋转点在mid前
        }

        // 数组片段仅有一个元素，或数组是递增的，直接返回第一个值
        return nums[lo];
    }
    */
    
    public int findMin(int[] nums) {
        return findMinCore(nums, 0, nums.length - 1);
    }

    private int findMinCore(int[] nums, int lo, int hi) {
        // 数组片段仅有一个元素，或数组是递增的，直接返回第一个值
        if (lo >= hi || nums[lo] < nums[hi])
            return nums[lo];

        int mid = (lo + hi) / 2;
        if (nums[lo] <= nums[mid])
            return findMinCore(nums, mid + 1, hi);
        else
            return findMinCore(nums, lo, mid);
    }       
}
// @lc code=end

