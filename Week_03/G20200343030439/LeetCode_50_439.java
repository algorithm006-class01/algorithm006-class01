/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.64%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    54.2K
 * Total Submissions: 159.3K
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
         
    public static void main(String[] args) {
        double result = myPow2(2, 13);
        System.out.println(result); 
    }

    public static double myPow(double x, int n) {
        long copyN = n;
        if (copyN < 0) {
            x = 1 / x;
            copyN = -n;
        }
        double result = 1;
        for (int i = 0; i < copyN; i++) {
            result *= x;
        }
        return result;
    }

    
    // 分治
    private static double myPow2(double x, int n) {
        long copyN = n;
        if (copyN < 0) {
            x = 1 / x;
            copyN = -n;
        }
        return fastPow(x, copyN);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}
// @lc code=end
