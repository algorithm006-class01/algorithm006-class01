/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
// best
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            mid = lo + (hi - lo) / 2;
            if (nums[lo] <= nums[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }
}
/* class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid;
                    
        if (nums[hi] >= nums[lo]) return nums[lo];
        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]) // important
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
} */

/* class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) return nums[lo];
            if ((mid = lo + (hi - lo) / 2) == lo) return Math.min(nums[lo], nums[hi]);
            if (nums[lo] < nums[mid]) 
                lo = mid;
            else 
                hi = mid;
        }
        return -1;
    }
} */
// @lc code=end

