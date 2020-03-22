/*
 * @lc app=leetcode.cn id=410 lang=cpp
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        int n=nums.size();
        vector<vector<long int>> f(n+1,vector<long int>(m+1,INT_MAX));
        vector<long int> sub(n+1,0);
        for(int i=0;i<n;i++)
            sub[i+1]=sub[i]+nums[i];
        f[0][0]=0;
        for(int i=0;i<=n;i++)
            for(int j=1;j<=m;j++)
                for(int k=0;k<i;k++)
                    f[i][j]=min(f[i][j],max(f[k][j-1],sub[i]-sub[k]));
        return f[n][m];
    }
};
// @lc code=end
