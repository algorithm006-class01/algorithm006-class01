/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int lo = 0, hi = matrix.length - 1, mid, dim = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if ((matrix[mid][0] <= target && mid == matrix.length - 1) || 
                (matrix[mid][0] <= target && matrix[mid + 1][0] > target)) {
                dim = mid;
                break;
            } else if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }
        int left = 0, right = matrix[dim].length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[dim][mid] == target) {
              return true;
            } else if (matrix[dim][mid] < target) {
                left = mid + 1;
            } else if (matrix[dim][mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

