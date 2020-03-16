package com.leetcode.week05;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

class Solution063_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution063_509 sol = new Solution063_509();
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else if (j > 0) {
                    dp[j] = dp[j] + dp[j -1];
                }
            }
        }

        return dp[n-1];
    }
}