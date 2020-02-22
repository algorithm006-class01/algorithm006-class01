/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<vector<int>> res;
        backtrack(nums,res,0);
        return res;
    }
    void backtrack(vector<int> &nums, vector<vector<int>> &res, int i)
    {
        res.push_back(nums);
        if (i == nums.size())
        {
            return;
        }
        for (; i < nums.size() - 1; i++)
        {
            for (int j = i + 1; j < nums.size(); j++)
            {
                swap(nums[i], nums[j]);
                backtrack(nums, res, i + 1);
                swap(nums[i], nums[j]);
            }
        }
    }
    void swap(int &a,int &b){
        int tmp;
        tmp=a;
        a=b;
        b=tmp;
    }
};
// @lc code=end
