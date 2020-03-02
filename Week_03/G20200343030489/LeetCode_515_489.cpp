/*
 * @lc app=leetcode.cn id=515 lang=cpp
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> res;
        dfs_(root,0,res);
        return res;
    }
    void dfs_(TreeNode* root,int level, vector<int>& res){
        if(!root)
            return;
        if(level==res.size())
            res.push_back(root->val);
        else
            res[level]=max(res[level],root->val);
        dfs_(root->left,level+1,res);
        dfs_(root->right,level+1,res);
    }
};
// @lc code=end

