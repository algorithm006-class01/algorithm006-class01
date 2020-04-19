/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 *
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (34.62%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 7.7K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * 
 * 示例:
 * 
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2 
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 
 * 
 * 说明：
 * 
 * 
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * 解决方案：暴力+动态规划
     *      dp(i1, j1, i2, j2) = dp(i1, j1, i2 - 1, j2) + dp(i1, j1, i2, j2 - 1)
     *                          - dp(i1, j1, i2 - 1, j2 - 1) + matrix[i2 - 1][j2 - 1]
     *      dp(i1, j1, i2, j2) 记录(i1, j1)到(i2, j2)的矩阵和
     *      起始位置：dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
     * 
     * 超出内存限制
     * 
     * 时间复杂度：O(m^2*n^2)
     * 空间复杂度：O(m^2*n^2)
     */
    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        int[][][][] dp = new int[rows + 1][cols + 1][rows + 1][cols + 1]; // from (i1,j1) to (i2,j2)
        outer: for (int i1 = 1; i1 <= rows; i1++) for (int j1 = 1; j1 <= cols; j1++) {
            dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
            for (int i2 = i1; i2 <= rows; i2++) for (int j2 = j1; j2 <= cols; j2++) {
                dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] - dp[i1][j1][i2 - 1][j2 - 1]
                        + matrix[i2 - 1][j2 - 1];
                if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max)
                    max = dp[i1][j1][i2][j2];
                if (max == k) break outer;
            }
        }
        return max;
    }

    /*
     * 解决方案：暴力+动态规划
     *      dp(i1, j1, i2, j2) = dp(i1, j1, i2 - 1, j2) + dp(i1, j1, i2, j2 - 1)
     *                          - dp(i1, j1, i2 - 1, j2 - 1) + matrix[i2 - 1][j2 - 1]
     *      dp(i1, j1, i2, j2) 记录(i1, j1)到(i2, j2)的矩阵和
     * 
     *      从上述代码发现，每次更换左上角 (i, j) 之后，之前记录的值都没用过了;
     *      尝试每次更换左上角时就重复利用 dp，故只需记录右下角即可
     * 
     * 解决方案优化：暴力+动态规划+状态压缩（依然4层遍历）
     *      dp(i2, j2) = dp(i2 - 1, j2) + dp(i2, j2 - 1) - dp(i2 - 1, j2 - 1) + matrix[i2 - 1][j2 - 1]
     *      dp(i2, j2) 记录(i1, j1)到(i2, j2)的矩阵和
     *      起始位置：dp[i1][j1] = matrix[i1 - 1][j1 - 1];
     * 
     * 时间复杂度：O(m^2*n^2)
     * 空间复杂度：O(m*n)
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        outer: for (int i1 = 1; i1 <= rows; i1++) for (int j1 = 1; j1 <= cols; j1++) {
            int[][] dp = new int[rows + 1][cols + 1]; // renew  // from (i1,j1) to (i2,j2)
            dp[i1][j1] = matrix[i1 - 1][j1 - 1];
            for (int i2 = i1; i2 <= rows; i2++) for (int j2 = j1; j2 <= cols; j2++) {
                dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
                if (max == k) break outer;
            }
        }
        return max;
    }

    /*
     * 解决方案：数组滚动
     *      1. 先固定左右边界，不断压入行，累计数组rowSum：记录左右边界固定时，每一行的数字和
     *      2. 左边界先不动，右边界先动，很便捷的更新“每一行的数字和”
     *      3. 原问题转换为==>“在累计数组rowSum中找不超过K的最大子序和”
     *      4. 移动左边界，重新开始新一轮计算；
     * 
     * 时间复杂度：O(m^2*n^2) 
     * 空间复杂度：O(m*n)
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        
        outer : for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变，才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到dp
                    rowSum[i] += matrix[i][r];
                }

                // 在rowSum数组中找不超过K的最大子序和
                max = Math.max(max, dpMax(rowSum, k));
                if (max == k) break outer; // 早停
            }
        }

        return max;
    }

    // 在rowSum数组中找不超过K的最大子序和
    private int dpMax(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int sum = array[0], sumMax = sum;

        // 在不考虑K值情况下，计算在最大子序和
        // 此时时间复杂度较低
        for (int i = 1; i < array.length; i++) {
            if (sum > 0) sum += array[i];
            else sum = array[i];

            if (sum > sumMax) sumMax = sum;
        }

        // 早停：不超过K，立即返回即可
        if (sumMax <= k) return sumMax;

        // 超过K值后，需要通过枚举数组的左右边界来寻找最大子序列
        sumMax = Integer.MIN_VALUE;
        sum = 0;
        for (int l = 0; l < array.length; sum = 0, l++) for (int r = l; r < array.length; r++) {
            sum += array[r];
            if (sum > sumMax && sum <= k) sumMax = sum;
            if (sumMax == k) return k; // 早停
        }

        return sumMax;
    }
}
// @lc code=end

