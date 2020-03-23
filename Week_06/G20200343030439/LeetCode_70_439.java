/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.49%)
 * Likes:    885
 * Dislikes: 0
 * Total Accepted:    155.5K
 * Total Submissions: 323.3K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
  // 暴力法-超时
  public static int climbStairs(int n) {
    return getUp(0, n);
  }

  public static int getUp(int i, int n) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    return getUp(i + 1, n) + getUp(i + 2, n);
  }

  // 记忆化递归
  public static int climbStairs2(int n) {
    int temp[] = new int[n + 1];
    return getUp2(0, n, temp);
  }

  public static int getUp2(int i, int n, int temp[]) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (temp[i] > 0) {
      return temp[i];
    }
    temp[i] = getUp2(i + 1, n, temp) + getUp2(i + 2, n, temp);
    return temp[i];
  }

  // 动态规划
  public static int climbStairs3(int n) {
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

}
// @lc code=end
