package com.aizain.jhome.computer.data.recursive;

/**
 * MyPow
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/3/1
 */
public class MyPow {

    /**
     * 审题：
     * 1 x,n有取值范围，都是整数，会有复数
     * 2 x^-n = 1/x^n
     * <p>
     * 思路：
     * 1 暴力
     * 2 分治
     * <p>
     * 反馈：
     * 1 牛顿迭代法
     * 2 复数可以最后用1/x解决
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // return directlySolution(x, n);
        // return divideSolution(x, n);
        return divideCleanSolution(x, n);
    }

    /**
     * 分治法简洁版
     * 1 ms	36.5 MB
     *
     * @param x
     * @param n
     * @return
     */
    private double divideCleanSolution(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / divideCleanSolution(x, -n);
        }
        return n % 2 == 1
                ? x * divideCleanSolution(x, n - 1)
                : divideCleanSolution(x * x, n / 2);
    }

    /**
     * 分治法
     * 1 ms	36.8 MB
     *
     * @param x
     * @param n
     * @return
     */
    private double divideSolution(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = divideGenerate(x, Math.abs((long) n));
        return n >= 0 ? v : 1 / v;
    }

    private double divideGenerate(double x, long n) {
        // 1 终止条件
        if (n < 2) {
            return x;
        }
        // 2 准备数据
        // 3 子问题
        double sub = divideGenerate(x, n / 2);
        // 4 合并
        // 5 清理
        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }

    /**
     * 暴力法
     * 2775 ms	37.4 MB
     *
     * @param x
     * @param n
     * @return
     */
    private double directlySolution(double x, int n) {
        if (x == 1) {
            return x;
        }
        double ret = 1;

        // 对 int 型数据 -2147483648 求绝对值，结果仍为 -2147483648
        if (n <= -2147483648) {
            n = -2147483647;
            if (x < 0) {
                // -1.00000 -2147483648 预期结果 1.0
                return 1.0;
            }
        }
        for (int i = 0; i < Math.abs(n); i++) {
            if (ret == 0) {
                return ret;
            }
            ret = n >= 0 ? ret * x : ret / x;
        }
        return ret;
    }


}
