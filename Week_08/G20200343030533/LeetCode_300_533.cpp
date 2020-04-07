#include <vector>
#include <iostream>

using std::vector;
using std::cout;
using std::endl;

int max(int a, int b){
    return a > b ? a : b;
}

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if ( nums.size() == 0 ) return 0;
        vector<int> dp(nums.size(), 1);
        dp[0] = 1;
        for (int i = 1; i < nums.size(); i++){
            for (int j = 0;  j < i; j++){
                if ( nums[i] > nums[j] ){
                    dp[i] = max(dp[j]+1, dp[i]);
                } 
            }
        }
        int max_out = 0;
        for ( auto n : dp){
            max_out = max(n, max_out);
        }
        return max_out;

    }
};


int main(int argc, char const *argv[])
{
    Solution sol;
    vector<int> test1{1,2,3,4,5,6};
    vector<int> test2{5,4,3,2,1};
    vector<int> test3;
    vector<int> test4{1,3,6,7,9,4,10,5,6};

    cout << sol.lengthOfLIS(test1) <<endl;
    cout << sol.lengthOfLIS(test2) <<endl;
    cout << sol.lengthOfLIS(test3) <<endl;
    cout << sol.lengthOfLIS(test4) <<endl;
    /* code */
    return 0;
}


//最长上升子序列
/*
DP[i]: [从0..i的最长子序列
以此检查之前元素，如果小于当前元素，那么就是之前的最大长度+1
输出: 遍历数组所有元素得到的最大值
*/