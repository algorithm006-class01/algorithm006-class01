/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
/*
 * 最简单代码可以用递归，直接返回 climbStairs(n - 1) + climbStairs(n - 2)。
 * 但代码会超时，因为大概有一半重复计算。计算climbStairs(n - 1)时其实已经计算了下一个数的climbStairs(n - 2)。
 * 所以用一个数组进行动态规划：dbArray[n] = climbStairs(n)。
 * 时间复杂度：O(2^n) 动态规划树中每一个节点计算一次
 * 空间复杂度：O(n) 只占用了动态规划数组的空间
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dbArray = new int[n];
        dbArray[0] = 0;
        dbArray[1] = 1;
        dbArray[2] = 2;
        for (int i = 3; i < n; i++) {
            dbArray[i] = dbArray[i - 1] + dbArray[i - 2];
        }
        return dbArray[n - 1] + dbArray[n - 2];
    }
}
// @lc code=end
