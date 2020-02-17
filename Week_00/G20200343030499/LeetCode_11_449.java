/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
/**
 * an能承载的水量由离an最远的不矮于an的竖线ax决定
 * calculateMaxArea()从左右两个方向寻找ax，并返回最大值。
 * 时间复杂度：O(n^2) 最优O(n)，当两端的竖线最长时；最差O(n^2)，当最长竖线在中间时
 * 空间复杂度：O(1)
 */
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result = Math.max(result, calculateMaxArea(height, i));
        }
        return result;
    }

    private int calculateMaxArea(int[] height, int selfIndex) {
        int left = 0;
        int right = height.length - 1;
        while (left != selfIndex) {
            if (height[selfIndex] <= height[left]) {
                break;
            }
            left++;
        }
        while (right != selfIndex) {
            if (height[selfIndex] <= height[right]) {
                break;
            }
            right--;
        }
        return Math.max(height[selfIndex] * (selfIndex - left), height[selfIndex] * (right - selfIndex));
    }
}
// @lc code=end
