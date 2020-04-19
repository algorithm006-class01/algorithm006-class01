/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (61.67%)
 * Likes:    1352
 * Dislikes: 0
 * Total Accepted:    188.9K
 * Total Submissions: 300K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 
 */

// @lc code=start
class Solution {
    /*
     * 解决方案：暴力法，枚举容器的左右边界
     * 
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for(int left = 0; left < height.length - 1; left++) for (int right = left + 1; right < height.length; right++) {
            int validHeight = Math.min(height[left], height[right]);
            int currentArea = validHeight * (right - left);
            if (currentArea > maxArea) maxArea = currentArea;
        }
        return maxArea;
    }

    /*
     * 解决方案：暴力法，枚举容器的左右边界
     * 
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int left = 0, right = height.length - 1; left < right;)
            maxArea = height[left] > height[right] ? Math.max(maxArea, (right - left) * height[right--]) : Math.max(maxArea, (right - left) * height[left++]);
        return maxArea;
    }
}
// @lc code=end

