学习笔记

本周学习
    根据老师的课程再次复习了递归、分治、和回溯，对于老师的讲解有了更深的体会
递归是一种方式，分治和回溯就是不同角度的递归，本质上还是个递归。

而动态规划，是一个推导的过程，可以类比于数学归纳法，推导出dp方程之后，根据构造出的
dp的维度进行循环，并使用dp方程，有多少个维度就需要多少层循环

63-不同路径II的dp方程
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    // 有多少行
    var row = obstacleGrid.length;

    // 有多少列
    var col = obstacleGrid[0].length;

    // 初始化dp[][]数据
    var dp = new Array(row);

    for(var i = 0;i < row; i++){
        dp[i] = new Array(col).fill(0);
    }

    dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

    // 如果起点就是障碍物那就GG了
    if(dp[0][0] == 0){
        return 0 ;
    }
    // 第一行的数据
    for(var c = 1;c < col;c++){
        if(obstacleGrid[0][c] != 1){
            dp[0][c] = dp[0][c-1];
        }
    }
    // 第一列的数据
    for(var r = 1;r < row;r++){
        if(obstacleGrid[r][0] != 1){
            dp[r][0] = dp[r-1][0];
        }
    }
    // 动态递推
    for(var r = 1;r < row;r++){
        for(var c = 1;c < col;c++){
            if(obstacleGrid[r][c] != 1){
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
    }
    return dp[row-1][col-1];
};


