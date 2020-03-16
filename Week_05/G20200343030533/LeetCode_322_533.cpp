#include <string.h>
#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>
#include <unordered_map>
#include <queue>
using namespace std;
//零钱兑换
//暴力求解，一定超时
class Solution1 {
public:
    int MIN_COMB = INT_MAX;
    int coinChange(vector<int>& coins, int amount) {
        DFS(0, amount, coins);
        return MIN_COMB;
    }

    void DFS(int depth, int amount, vector<int>& coins){
        if (amount == 0){
            MIN_COMB = min(depth, MIN_COMB);
            return ;
        }
        for (auto coin : coins){
            if (amount - coin < 0 ) continue; //减枝
            DFS(depth+1, amount - coin, coins);
            
        }
        return ;
    }
};
// BFS,, 依旧超时
class Solution2 {
public:
    int coinChange(vector<int>& coins, int amount) {

        queue<pair<int,int>> q; //level and amount
        q.push({0, amount});

        while ( !q.empty()) {

            int level = q.front().first;
            int surplus = q.front().second;
            q.pop();

            for (auto c : coins){
                if ( surplus - c < 0 ) continue;
                if ( surplus - c == 0 ) return level + 1;
                q.push({level+1, surplus-c});
            }
        }
        return -1;


    }
};

//贪心算法，不一定能得到最优解
class Solution3 {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end(), std::greater<>());
        return DFS(0, amount, coins);
    }

    int DFS(int level, int amount, vector<int>& coins){
        if (amount <= 0){
            return amount == 0 ? level : -1;
        }
        for (auto coin : coins){
            int res = DFS(level+1, amount - coin, coins);
            if (res > 0 ) return res;
        }
        return -1;
    }
};

// 递归+记忆化
class Solution4 {
public:
    unordered_map<int, int> dict;
    int coinChange(vector<int>& coins, int amount) {
        if (amount < 1) return 0;
        return DFS(coins, amount);
    }
    int DFS(vector<int>& coins, int amount){
        if (amount < 0 ) return -1;
        if (amount == 0 ) return 0;
        if (dict.find(amount) != dict.end()) return dict[amount];

        int min = INT_MAX; //足够大的值
        for (int coin : coins){
            int res = DFS(coins, amount-coin);
            if (res >= 0 && res < min){
                min = res + 1;
            }
        }
        dict[amount] = (min == INT_MAX ? -1 : min);
        return dict[amount];
    }
};

//最终答案，动态递推
class Solution5 {
public:
    int coinChange(vector<int>& coins, int amount) {
        int MAX = amount + 1;// 只要保证比amount大即可, 因为后续要和当前最小的选择比较。
        vector<int> dp(amount+1, MAX); //DP数组
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.size(); j++){
                if (coins[j] <= i){ //举例, i = 2, 只能考虑coin=1,2, 排除5
                    dp[i] = min(dp[i], dp[i-coins[j]] + 1); 
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};
//优化的DP, 交换内外层循环, 通过枚举硬币省了判断语句
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int MAX = amount + 1;// 只要保证比amount大即可, 因为后续要和当前最小的选择比较。
        vector<int> dp(amount+1, MAX); //DP数组
        dp[0] = 0;
        for (int j = 0; j < coins.size(); j++){
            for (int i = coins[j]; j <= amount; i++){
                dp[i] = min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};


int main(int argc, char *argv[]){
    Solution4 sol;
    Solution sol2;
    vector<int> vec1{186,419,83,408};
    vector<int> vec2{1,2,5};
    cout << sol.coinChange(vec1, 11) << '\n';
    cout << sol2.coinChange(vec1, 6249) << '\n';
    return 0;
}