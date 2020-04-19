 /*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 *
 * https://leetcode-cn.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (37.92%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    26.1K
 * Total Submissions: 59.9K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 
 * 两个相邻元素间的距离为 1 。
 * 
 * 示例 1: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 示例 2: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * 解决方案：广度优先搜索BFS
     *        要点：起始为“超级零集合”
     *             将matrix所有为1的地方置为-1，充当visited矩阵
     * 
     *        或者：起始为“超级零旁的1集合”
     *             之后只关注原值为1的位置即可
     * 
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     */
    public int[][] updateMatrix1(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == matrix[i][j])
                    queue.offer(new int[]{i, j});
                else
                    matrix[i][j] = -1;
            }
        }

        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0], newY = y + dirs[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    /*
     * 解决方案：动态规划
     *        递推方程：f(i, j) = 1 + min(f(i-1, j), f(i+1, j), f(i, j-1), f(i, j+1)))  if matrix[i][j]==1
     *                        = 0                                                     if matrix[i][j]==0
     *        
     *        递推方程虽简洁明了，但需要解决两个问题：
     *          1. 开始都是0或1，递推时，得到的值要么是0要么是1或者是2，如何解决；
     *          2. 递推时，有的是离左边0近，有的是离右边0近，有的是离上边0近，有的是离下边0近；
     *        解决措施：
     *          1. 题目说明了元素总数不超过10000，则将所有为1的地方都置为10000后，再递推
     *          2(1). 从四个角各递推一遍，解决四个方向的问题；
     *          2(2). 从左上和右下各递推一遍，也能起到解决四个方向的问题：从左上角开始时，找到的是左、上方向最近的0；
     *                                                          从右下角开始时，找到的是右、下方向最近的0；
     *            详细解释2(2)原因：
     *                首先从左上角开始递推 dp[i][j]dp[i][j] 是由其 「左方」和 「左上方」的最优子状态决定的；
     *                然后从右下角开始递推 dp[i][j]dp[i][j] 是由其 「右方」和 「右下方」的最优子状态决定的；
     *                看起来第一次递推的时候，把「右上方」的最优子状态给漏掉了，其实不是的，因为第二次递推的时候「右方」的状态在第一次递推时已经包含了「右上方」的最优子状态了；
     *                看起来第二次递推的时候，把「左下方」的最优子状态给漏掉了，其实不是的，因为第二次递推的时候「右下方」的状态在第一次递推时已经包含了「左下方」的最优子状态了。
     * 
     * 
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) for (int j = 0; j < n; j++)
        //     dp[i][j] = matrix[i][j] == 0 ? 0: 10000;

        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            dp[i][j] = matrix[i][j] == 0 ? 0: 10000;
            if (i >= 1)
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            if (j >= 1)
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
        }
        for (int i = m - 1; i >= 0; i--) for (int j = n - 1; j >= 0; j--) {
            if (i + 1 < m)
                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
            if (j + 1 < n)
                dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
        }
        return dp;
    }
}
// @lc code=end

