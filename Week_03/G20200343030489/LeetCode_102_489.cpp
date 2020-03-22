/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层次遍历
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
class Solution
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> res;
        if (!root)
        {
            return res;
        }
        queue<TreeNode *> que;
        TreeNode *tree;
        que.push(root);
        while (!que.empty())
        {
            vector<int> tmp;
            int width = que.size();
            for (int i = 0; i < width; i++)
            {
                tree = que.front();
                tmp.push_back(tree->val);
                que.pop();
                if (tree->left)
                {
                    que.push(tree->left);
                }
                if (tree->right)
                {
                    que.push(tree->right);
                }
            }
            res.push_back(tmp);
        }
        return res;
    }
};
// @lc code=end
