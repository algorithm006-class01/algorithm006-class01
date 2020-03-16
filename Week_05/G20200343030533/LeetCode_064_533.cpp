#include <string.h>
#include <stdlib.h>
#include <vector>
#include <iostream>

using namespace std;
/*
a. 子问题: 到i,j 最短路径到i-1,j与到i,j-1路径的最小值加上当前路径
b. 
c. 状态函数: opt[i][j] = min(opt[i-1][j], opt[i][j]) + a[i][j]
*/
class Solution {
public:
//解决方法1
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        // m x n
        vector<vector<int>> opt(m, vector<int>(n,0));
        //初始化第一列
        opt[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            opt[i][0] = opt[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++){
            opt[0][j] = opt[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                opt[i][j] = min(opt[i-1][j], opt[i][j-1]) + grid[i][j];
            }
        }
        return opt[m-1][n-1];
    }
};

int main(int argc, char *argv[]){
    Solution sol;

    vector<vector<int>> grid{
        {1,3,1},
        {1,5,1},
        {4,2,1}
    };
    cout << "minium path sum " << sol.minPathSum(grid) << '\n';
    
    return 0;
}