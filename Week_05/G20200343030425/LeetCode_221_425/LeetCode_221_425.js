/*
* address: https://leetcode-cn.com/problems/maximal-square/
*
*
* */
const maximalSquare = function(matrix) {
    let dp = [];
    let len = matrix.length;
    if(len === 0){
        return 0;
    }
    let len2 = matrix[0].length;
    let i,j;
    let max = 0;
    for(i = 0 ; i<len; i++){
        dp[i] = [];
    }
    dp[0][0] = parseInt(matrix[0][0]);
    max = Math.max(max, dp[0][0]);
    for(i = 0; i < len; i++){
        for(j = 0; j < len2; j++){
            if(i === 0 || j === 0){
                dp[i][j] = parseInt(matrix[i][j]);
                max = Math.max(max, dp[i][j]);
                continue;
            }
            if(matrix[i][j] === '1'){
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]) + 1
                max = Math.max(max,dp[i][j])
            }else{
                dp[i][j] = 0;
            }
        }
    }
    return max * max;
};
