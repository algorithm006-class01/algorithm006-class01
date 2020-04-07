/*
* address: https://leetcode-cn.com/problems/unique-paths-ii/
* */

let uniquePathsWithObstacles = function(obstacleGrid) {
    let n = obstacleGrid.length;
    let m = obstacleGrid[0].length;
    let dp = new Array(n);
    for(let i = 0;i<n;i++){
        dp[i] = Array(m).fill(0);
    }
    dp[0][0] = obstacleGrid[0][0] === 0 ? 1 : 0;
    if(dp[0][0] === 0){
        return 0 ;
    }
    for(let j = 1;j < m;j++){
        if(obstacleGrid[0][j] !== 1){
            dp[0][j] = dp[0][j-1];
        }
    }
    for(let r = 1;r < n;r++){
        if(obstacleGrid[r][0] !== 1){
            dp[r][0] = dp[r-1][0];
        }
    }
    for(let i = 1;i < n;i++){
        for(let r = 1;r < m;r++){
            if(obstacleGrid[i][r] !== 1){
                dp[i][r] = dp[i-1][r] +dp[i][r-1];
            }
        }
    }
    return dp[n-1][m-1];
};
