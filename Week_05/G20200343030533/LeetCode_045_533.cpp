#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
using namespace std;

/*
子问题: 抵达第i个位置的最少步数 = 0..i-1中的最小步数 + 1
DP方程: DP[i] = min(DP[0..i-1],  j + a[j] > i )
*/

//代码没错，就是时间复杂度是O(n^2), 就有变态的数据不能AC
// 90 / 92 个通过测试用例
class Solution1 {
public:
    int jump(vector<int>& nums) {
        int dp[nums.size()];
        int MAX = nums.size() + 1;
        for (int i = 0; i < nums.size(); i++) dp[i] = MAX;
        dp[0] = 0; //初始化第一个位置
        for (int i = 1 ;i < nums.size() ; i++){
            for(int j = 0; j < i ; j++){
                if (nums[j] + j >= i){
                    dp[i] = min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.size()-1];
    }
};
//92 / 92 个通过测试用例
class Solution2 {
public:
    int jump(vector<int>& nums) {
        int dp[nums.size()];
        int num_len = nums.size() ;
        for (int i = 0; i < nums.size(); i++) dp[i] = INT_MAX;
        dp[0] = 0; //初始化第一个位置

        for (int i = 0 ;i < nums.size() ; i++){
            for(int j = 1; j <= nums[i] ; j++){
                int next = min(i+j, num_len-1); //不能越界
                dp[next] = min(dp[next],dp[i]+1);
            }
        }
        return dp[nums.size()-1];
    }
};

//剪枝
class Solution {
public:
    int jump(vector<int>& nums) {
        int num_len = nums.size() ;
        if ( num_len <= 1) return 0;
        int farthest = 0;
        int dp[num_len];
        for (int i = 0; i < num_len ; i++) dp[i] = INT_MAX - 1;
        dp[0] = 0; //初始化第一个位置

        for (int i = 0 ;i < num_len ; i++){
            if ((i+nums[i]+1)>= num_len) return dp[i]+1;
            for(int j = farthest-i; j <= nums[i] && nums[i] + i > farthest; j++){
                int next = i + j; //抵达的最后位置
                dp[next] = min(dp[next],dp[i]+1);
            }
            farthest = i + nums[i];
        }
        return dp[num_len-1];
    }
};

int main(int argc, char *argv[]){
    vector<int> vec{2,3,1,1,4};
    Solution sol;
    cout <<  sol.jump(vec) << '\n';
    return 0;
}