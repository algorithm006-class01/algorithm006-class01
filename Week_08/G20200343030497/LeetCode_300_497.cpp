class Solution {
public:
    // 动态规划
    int lengthOfLIS(vector<int>& nums) {
        int size = nums.size();
        if (size == 0) { 
            return 0; 
        } 
        
        vector<int> dp(size, 1);
        int res = 1;
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
            res = max (res, dp[i]);
        }
        return res;
    }
};
