/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
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
    vector<int> preorderTraversal(TreeNode* root) {
        stack<TreeNode*> s;
        vector<int> v;
        TreeNode* rt=root;
        while (rt||s.size())
        {
            /* code */while (rt)
            {
                /* code */s.push(rt->right);
                v.push_back(rt->val);
                rt=rt->left;
            }
            rt=s.top();
            s.pop();
            
        }
        return v;
    }
};
// @lc code=end

