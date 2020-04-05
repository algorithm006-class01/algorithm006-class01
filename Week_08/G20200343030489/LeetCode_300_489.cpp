/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长上升子序列
 */

// @lc code=start
// class Solution {
// public:
//     int lengthOfLIS(vector<int>& nums) {
//         if(nums.size()==0)
//             return 0;
//         vector<int> dp(nums.size(),0);
//         for(int i=0;i<nums.size();i++){
//             dp[i]=1;
//             for(int j=0;j<i;j++)
//                 if(nums[j]<nums[i])
//                     dp[i]=max(dp[i],dp[j]+1);
//         }
//         return *max_element(dp.begin(),dp.end());
//     }
// };
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len=1,n=nums.size();
        if(n==0)
            return 0;
        vector<int> d(n+1,0);
        d[len]=nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>d[len])
                d[++len]=nums[i];
            else
            {
                int l=1,r=len,pos=0;
                while(l<=r){
                    int mid=(l+r)>>1;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        l=mid+1;
                    }
                    else
                        r=mid-1;
                    
                }
                d[pos+1]=nums[i];
            }
            
        }
        return len;
    }
};
// @lc code=end

