import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (63.77%)
 * Likes:    328
 * Dislikes: 0
 * Total Accepted:    43.6K
 * Total Submissions: 68.3K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return MTRecursive(triangle, 0 , 0);
        
        // int[][] mem = new int[triangle.size()][triangle.size()];
        // Arrays.stream(mem).forEach(line -> Arrays.fill(line, Integer.MIN_VALUE)); // 没有想到更好的初始化方式
        // return MTRecursiveMem(triangle, 0, 0, mem);

        // return MTDP1(triangle);

        // return MTDP2(triangle);

        return MTDP3(triangle);

        // return MTDP4(triangle);
    }

    // 递归：mininum(i, j) = Math.min(mininum(i + 1, j), mininum(i + 1, j + 1)) + v[i][j]
    // 调用方式： mininum(v, 0, 0);
    // 递归会有存在重复计算：如某子triangle会被其left父节点和right父节点重复计算；
    private int MTRecursive(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1 || j == triangle.size() - 1) 
            return triangle.get(i).get(j);

        int left = MTRecursive(triangle, i + 1, j);
        int right = MTRecursive(triangle, i + 1, j + 1);
        return Math.min(left, right) + triangle.get(i).get(j);
    }

    // 递归 + 备忘录
    private int MTRecursiveMem(List<List<Integer>> triangle, int i, int j, int[][] mem) {
        if (i == triangle.size() - 1 || j == triangle.size() - 1) 
            return mem[i][j] = triangle.get(i).get(j);
        
        if (mem[i][j] != Integer.MIN_VALUE)
            return mem[i][j];
        
        int left = MTRecursiveMem(triangle, i + 1, j, mem);
        int right = MTRecursiveMem(triangle, i + 1, j + 1, mem);
        return mem[i][j] = Math.min(left, right) + triangle.get(i).get(j);        
    }

    // 动态规划：自底向上，n^2空间复杂度
    // 状态转移方程dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + v[i][j]
    private int MTDP1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // 处理边界值
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i); // 对角线位置的，不能从上部下来，只能从斜上部下来；
        }

        // 遍历最底层，找出最短路径和
        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (minTotal > dp[n - 1][i]) minTotal = dp[n - 1][i];
        }
        return minTotal;
    }

    // 动态规划：自顶向下，n^2空间复杂度
    // 状态转移方程：dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
    private int MTDP2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        // 处理边界
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    // 动态规划：自顶向下，n空间复杂度
    private int MTDP3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];  // 想想为什么不需要处理边界问题

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    // 动态规划：自顶向下
    // 直接在原二维数组上进行修改，不占用额外空间；（项目中不推荐使用）
    private int MTDP4(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int value = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, value);
            }
        }

        return triangle.size() > 0 ? triangle.get(0).get(0) : 0;
    }
}
// @lc code=end

