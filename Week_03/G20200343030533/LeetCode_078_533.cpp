// 78.子集
// https://leetcode-cn.com/problems/subsets/

// 题目求解思路是回溯, 每一次就试试不同可能性

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> subset;

        _DFS(nums, 0, subset, res);
        return res;

    }
    void _DFS(vector<int>& nums, int pos, vector<int>& subset, vector<vector<int>>& res){
        if (pos >= nums.size()) {
            res.push_back(subset);
            return;
        }
        //不增加元素
        _DFS(nums, pos+1, subset, res);
        //增加元素
        subset.push_back(nums[pos]);
        _DFS(nums, pos+1, subset, res);
        //重置状态
        subset.pop_back();
        return;
        

    }
};