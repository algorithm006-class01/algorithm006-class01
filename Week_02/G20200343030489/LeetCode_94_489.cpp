/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
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
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> s;
        vector<int> v;
        TreeNode* rt=root;
        while (rt||s.size())
        {
            /* code */while (rt)
            {
                /* code */s.push(rt);
                rt=rt->left;
            }
            rt=s.top();
            s.pop();
            v.push_back(rt->val);
            rt=rt->right;          
        }
        return v;
    }
};
// @lc code=end
