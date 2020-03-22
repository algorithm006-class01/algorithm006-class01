/*
 * @lc app=leetcode id=64 lang=c
 *
 * [64] Minimum Path Sum
 */
// find the minimal sum of all numbers along its path => 
// 路上的点到最后一个点的最小路径 = 从最下面的点走到最上面的最小路径
// f[i,j] = min(f[i+1,j],f[i,j+1])
// 
// @lc code=start
#include<stdio.h>
#include<stdlib.h>
int minPathSum(int** grid, int gridSize, int* gridColSize){
    int i, j;
    for(i=1;i<gridSize;i++){
        grid[i][0] += grid[i-1][0];
    }
    for(j=1;j<*gridColSize;j++){
        grid[0][j] += grid[0][j-1];
    }
    for(i=1;i < gridSize;i++){
        for(j=1;j<*gridColSize;j++){
            grid[i][j] += grid[i-1][j] < grid[i][j-1] ? grid[i-1][j]:grid[i][j-1];
        }
    }

    return grid[gridSize-1][*gridColSize-1];
}


// @lc code=end

