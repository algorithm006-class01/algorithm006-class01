#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

/*
子问题/状态数组/转移方程， a[i,j] = a[i-1,j] + a[i,j-1]
*/

class Solution {
public:
    int uniquePaths(int m, int n) {
        int dp[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
};

int main(int argc, char *argv[]){
    Solution sol;
    cout <<  sol.uniquePaths(3,2) << '\n';
    return 0;
}