/*
 * @lc app=leetcode.cn id=746 lang=cpp
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int c1=cost[0],c2=cost[1],n=cost.size();
        for(int i=2;i<n;i++){
            int c3=min(c1,c2)+cost[i];
            c1=c2;
            c2=c3;
        }
        return min(c1,c2);
    }
};
// @lc code=end

