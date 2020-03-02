/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    /*
    nums[0] <= target <= nums[mid]  [3,4,target=5,6,7,1,2] [1,2,target=3,4,5,6,7]
               target <= nums[mid] < nums[0]  [6,7,target=1,2,3,4,5]
                         nums[mid] < nums[0] <= target  [5,target=6,7,1,2,3,4]
    nums[0] <= target， target <= nums[mid] ，nums[mid] < nums[0]
    */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (! ((nums[0] <= target) ^ (target <= nums[mid]) ^ (nums[mid] < nums[0]))) {
                hi = mid; // because target <= nums[mid], so here can not be hi = mid +1
            } else {
                lo = mid + 1;
            }
        }
        return (lo == hi && nums[lo] == target) ? lo : -1;
    }
}

/* class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;if (lo == mid) {
                if (target =)
            }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else 
                    lo = mid + 1; // 1
            } else {
                if (target <= nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else 
                    hi = mid - 1;
            }
        }
        return -1;
    }
} */

// @lc code=end

