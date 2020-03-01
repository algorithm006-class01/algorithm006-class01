/*
 * @lc app=leetcode.cn id=74 lang=javascript
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (!matrix.length)
        return false;
    let row = matrix.length,
        col = matrix[0].length;
    let low = 0,
        high = row * col - 1;
    while (low <= high) {
        let mid = low + ((high - low) >> 1);

        let i = (mid / col) >> 0,
            j = mid % col;
        if (matrix[i][j] > target) {
            high = mid - 1;
        } else if (matrix[i][j] < target) {
            low = mid + 1
        } else {
            return true;
        }
    }

    return false;
};
// @lc code=end


