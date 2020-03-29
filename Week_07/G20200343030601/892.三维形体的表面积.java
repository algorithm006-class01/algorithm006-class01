/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 *
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (55.88%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    7.9K
 * Total Submissions: 13.3K
 * Testcase Example:  '[[2]]'
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 
 * 请你返回最终形体的表面积。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[2]]
 * 输出：10
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 
 * 
 * 示例 4：
 * 
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 
 * 
 * 示例 5：
 * 
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 */

// @lc code=start
class Solution {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    // 注意grid[x][y] = 0的情况处理
    public int surfaceArea1(int[][] grid) {
        if (null == grid || 0 == grid.length) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0},{1, 0}};
        int area = 2 * m * n;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] <= 0) {
                    area -= 2;
                    continue;
                }
                for (int[] dir : dirs) {
                    int dx = x + dir[0], dy = y + dir[1];
                    if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                        if (grid[dx][dy] < grid[x][y])
                            area += (grid[x][y] - grid[dx][dy]);
                    }
                    else
                        area += grid[x][y];
                }
            }
        }

        return area;
    }

    public int surfaceArea2(int[][] grid) {
        if (null == grid || 0 == grid.length) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1},{1, 0}};
        int area = 2 * m * n;  // 整体前后面积
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (0 == grid[x][y]) {
                    area -= 2; // 空洞，去除当前点的前后面积
                    continue;
                }
                area += 4 * grid[x][y];  // 前后左右面

                for (int[] dir : dirs) { // 去除前后左右要抵消的面积
                    int dx = dir[0] + x, dy = dir[1] + y;
                    if (dx < m && dy < n) {
                        area -= 2 * Math.min(grid[x][y], grid[dx][dy]);
                    }
                }
            }
        }

        return area;
    }

    public int surfaceArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) res += grid[i][j] * 4 + 2;
                if (i > 0) res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                if (j > 0) res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }
        }
        return res;
    }
}
// @lc code=end

