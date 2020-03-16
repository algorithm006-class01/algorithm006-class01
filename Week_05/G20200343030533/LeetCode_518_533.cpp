#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <unordered_map>
using namespace std;

//本题是研究所有可能, 322题目是最小硬币组合
//姊妹题: https://leetcode-cn.com/problems/coin-change/

/*
a. 子问题，状态数组, DP方程
凑齐i的组合总数 = 凑齐i-k个硬币的方法的和
DP[i]表示第总数为i的状态的硬币数
DP[i] += DP[i-coin]  for coin in coins
*/


//外层循环是硬币，也就是先找到能被对应硬币填充的位置进行填充。
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int dp[amount+1];
        memset(dp, 0, sizeof(dp));
        dp[0] = 1;
        for (int coin : coins){
            for (int j = 1; j <= amount; j++){
                if (j < coin) continue; //也就是2不能用5凑
                dp[j] += dp[j-coin];
                cout << "coin " << coin << " with amount " << j << "->" << dp[j] << '\n';
            }
        }
        return dp[amount];
    }
};

class Solution2 {
public:
    int change(int amount, vector<int>& coins) {
        int dp[amount+1][coins.size()+1];
        for (int i = 0; i < amount + 1; i++ ){
            for (int j = 0; j < coins.size() + 1; j++){
                dp[i][j]= 0;
            }
        }
        for (int i = 0 ; i < coins.size() + 1; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < amount+1; i++){
            for(int j = 1; j < coins.size() + 1; j++){
                if ( i >= coins[j-1]){
                    dp[i][j] = dp[i-coins[j-1]][j] + dp[i][j-1];
                } else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[amount][coins.size()];
    }
};

int main(int argc, char *argv[]){
    Solution sol;
    vector<int> vec{1,2};
    cout << sol.change(3, vec) << '\n';
    return 0;
}