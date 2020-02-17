/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(final int[] height) {
        if (height.length < 2) return 0;

        int ret = 0;
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for(var i = 1; i < len; ++ i) 
            left[i] = Math.max(height[i], left[i - 1]);
        right[len - 1] = height[len - 1];
        for(var i = len - 2; i >= 0; --i )
            right[i] = Math.max(height[i], right[i + 1]);
        for(var i = 1; i < len - 1 ; ++i) {
            ret += Math.min(left[i], right[i]) - height[i];
        }
        return ret;
    }
}
// @lc code=end

