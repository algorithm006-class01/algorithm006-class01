/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
// 无后向性
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++)
            dp[i][0] = Integer.MAX_VALUE;
        for (int j = 1; j <= m; j ++) 
            dp[0][j] = Integer.MAX_VALUE;
        
        int[] kadane = new int[n + 1];
        for (int i = 0; i < n; i ++)
            kadane[i + 1] = kadane[i] + nums[i];
        
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                dp[i][j] = Integer.MAX_VALUE;           
                for (int k = 0; k < i; k ++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], kadane[i] - kadane[k]));
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

