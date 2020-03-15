/*
 * @lc app=leetcode id=221 lang=c
 *
 * [221] Maximal Square
 */ 
// transition dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
// note the the left-most column and top-most row can just form square with area 1.
// space complexity can be optimized according to the following link.
// https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
// @lc code=start
#include<stdio.h>
int maximalSquare(char** matrix, int matrixSize, int* matrixColSize){
    int dp[matrixSize][*matrixColSize]={0};
    int i,j,sz=0;
    for(i = 0;i < matrixSize;i++){
        for(j = 0;j < *matrixColSize;j++){
            if(i != 0 || j != 0 || matrix[i][j] == '0'){
                dp[i][j] = matrix[i][j] - '0';
            }
            else{
                dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]) + 1;
            }
            sz = dp[i][j] > sz ? dp[i][j] : sz;
        }
    }
    return sz * sz;
}

int  min(int a, int b,int c){
    int min_num = a < b ? a : b;
    return min_num < c ? min_num : c;
}


// @lc code=end

