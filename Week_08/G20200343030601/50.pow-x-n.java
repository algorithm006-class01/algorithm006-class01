/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (34.05%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    67K
 * Total Submissions: 194.5K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * 不考虑暴力法了，但要注意：
     *                      1. n < 0 是如何处理
     *                      2. n 为 -2^31时要如何处理（int型数值范围-2^31到2^31-1）
     * 解决方案：快速幂（递归）
     * 
     * 时间复杂度：O(logN)
     * 空间复杂度：O(logN) 递归栈空间
     */
    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / x / myPow(x, -(n + 1));  // 对应注意点2
        if ((n & 1) == 0) return myPow(x * x, n >> 1);
        return x * myPow(x, n - 1);
    }

    /*
     * 解决方案：快速幂(迭代法)
     * 
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public double myPow2(double x, int n) {
        long nLong = n;
        if (nLong < 0) {
            x = 1 / x;
            nLong = -nLong;
        }

        double ans = 1;
        for (; nLong > 0; nLong /= 2) {
            if (nLong % 2 == 1) ans = x * ans;  // 注意理解ans和x的变化
            x *= x;
        }

        return ans;
    }
    // 不使用long来处理边界，而是用个小技巧处理边界
    public double myPow(double x, int n) {
        double ans = 1;
        if (n < 0) {
            ans = 1 / x;  // 提前将一个x乘入结果
            x = 1 / x;
            n = -(n + 1);
        }
        for (; n > 0; n /= 2) {
            if (n % 2 == 1) ans *= x;
            x *= x;
        }

        return ans;
    }
}
// @lc code=end
