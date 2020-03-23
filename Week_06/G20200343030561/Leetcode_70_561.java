/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @date Feb 13 2020
/* class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        var sol1 = 1;
        var sol2 = 2;
        var sol3 = 3;
        for (var i = 2; i < n; ++i) {
            sol3 = sol1 + sol2;
            sol1 = sol2;
            sol2 = sol3;
        }
        return sol3;
    }
} */

// @date Feb 20 2020
// @solution backtracking 2
// class Solution {
//     // an int is a primitive type and cannot be null
//     public Integer[] sol = new Integer[100];
//     public int climbStairs(int i) {
//         sol[1] = 1;
//         sol[2] = 2;
//         if (i <= 2) return sol[i];
//         if (sol[i - 1] == null) sol[i - 1] = climbStairs(i - 1);
//         if (sol[i - 2] == null) sol[i - 2] = climbStairs(i - 2);
//         return sol[i-1] + sol[i-2];
//     }
// }

// 斐波那契公式
// @date Mar 02 2020
// class Solution {
//     public int climbStairs(int i) {
//         int n = i + 1;
//         double sqrt_5 = Math.sqrt(5);
//         double fib_n = Math.pow((1 + sqrt_5) / 2, n) - Math.pow((1 - sqrt_5) / 2, n);
//         return (int)(fib_n / sqrt_5);
//     }
// }

// DP
// @date Mar 11 2020
// class Solution {
//     public int climbStairs(int n) {
//         if (n < 3) return n;
//         int[] dp = new int [n+1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++)
//             dp[i] = dp[i-1] + dp[i-2];
//         return dp[n];
//     }
// }

// @lc code=start
// @date Mar 22 2020
// @solution backtracking 1
class Solution {
    int[] sol = new int[100];
    public int climbStairs(int i) {
        sol[1] = 1;
        sol[2] = 2;
        if (i <= 2) return sol[i];
        if (sol[i] != 0) return sol[i];
        sol[i] = climbStairs(i - 1) + climbStairs(i - 2);
        return sol[i];
    }
}

// @lc code=end