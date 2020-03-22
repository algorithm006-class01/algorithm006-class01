#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

/* 类似62题，只不过状态转移方程变了
if grid[i][j] == 1: (不为空地)
    DP[i][j] =  0;
else:
    DP[i][j] = DP[i-1][j] + DP[i][j-1]
*/

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        long int dp[m][n]; //居然有一个值很大，导致溢出
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i-1][0] : 0;
        }
        for (int i = 1; i < n; i++){
            dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i-1] : 0;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
};


int main(int argc, char *argv[]){
    return 0;
}