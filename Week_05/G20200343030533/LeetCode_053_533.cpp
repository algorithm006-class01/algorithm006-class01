#include <string.h>
#include <vector>
#include <iostream>
using namespace std;

/*
DP方程: dp[i] = max(dp[i-1], 0) + a[i]
如果前一个状态比较小，立刻止损，只用当前最大值
*/
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int m = nums.size();
        int dp[m];
        dp[0] = nums[0];
        for (int i = 1; i < m; i++){
            dp[i] = max(dp[i-1], 0) + nums[i];
        }

        int max_num = dp[0];
        for (int i = 1; i < m; i++){
            max_num = max(max_num, dp[i]);
        }
        return max_num;
    }
};

int main(int argc, char *argv[]){
    Solution sol;
    vector<int> nums{-2,1,-3,4,-1,2,1,-5,4};
    cout <<  sol.maxSubArray(nums) << '\n';
    return 0;
}