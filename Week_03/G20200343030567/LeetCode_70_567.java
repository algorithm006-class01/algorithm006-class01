package com.aizain.jhome.computer.data.list;

/**
 * ClimbStairs
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/2/29
 */
public class ClimbStairs {

    private int[] fnCache = null;

    /**
     * 审题：
     * 1 n是正整数
     * 2 只输出不重复方法数量
     * 3 步长1、2
     * 4 结果是不超过int
     * <p>
     * 思路：
     * 1 无思路，直接看题解
     * 2 最近问题，最近重复性法，斐波拉契数列，递归
     * <p>
     * 反馈：
     * 1 中文站题解
     * 2 国际站题解
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // return fiboracciSolution(n);
        // return fiboracciCacheSolution(n);
        return divideAndConquerSolution(n);
    }

    /**
     * 分治思路
     *
     * @param n
     * @return
     */
    private int divideAndConquerSolution(int n) {
        // 1 终结条件
        if (n <= 1) {
            return 1;
        }
        // 2 准备数据，处理当前层
        int f1 = n - 1;
        int f2 = n - 2;
        // 3 下探处理子问题
        int f1Ret = divideAndConquerSolution(f1);
        int f2Ret = divideAndConquerSolution(f2);
        // 4 合并子问题结果
        int result = f1Ret + f2Ret;
        // 5 清理当前层
        return result;
    }

    /**
     * 斐波拉契数列，加缓存
     * 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36 MB, 在所有 Java 提交中击败了 5.21% 的用户
     *
     * @param n
     * @return
     */
    private int fiboracciCacheSolution(int n) {
        fnCache = new int[n];
        return fnUseCache(n);
    }

    private int fnUseCache(int n) {
        if (n <= 1) {
            return 1;
        }
        int f1 = n - 1;
        int f2 = n - 2;
        if (fnCache[f1] <= 0) {
            fnCache[f1] = fnUseCache(f1);
        }
        if (fnCache[f2] <= 0) {
            fnCache[f2] = fnUseCache(f2);
        }
        return fnCache[f1] + fnCache[f2];
    }

    /**
     * 斐波拉契数列
     * 能算，但是会超时
     *
     * @param n
     * @return
     */
    private int fiboracciSolution(int n) {
        if (n <= 1) {
            return 1;
        }
        return fiboracciSolution(n - 1) + fiboracciSolution(n - 2);
    }

}
