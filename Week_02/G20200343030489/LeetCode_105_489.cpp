/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        int pos = 0;
        return buildTree(preorder, pos, inorder, 0, inorder.size() - 1);
    }
    TreeNode *buildTree(vector<int> &preorder, int &pos, vector<int> &inorder, int left, int right)
    {
        if (pos >= preorder.size())
        {
            return 0;
        }
        int i = left;
        for (; i <= right; i++)
        {
            if (inorder[i] == preorder[pos])
            {
                break;
            }
        }
        TreeNode* node=new TreeNode(preorder[pos]);
        if (left<=i-1)
        {
            node->left=buildTree(preorder,++pos,inorder,left,i-1);
        }
        if (i+1<=right)
        {
            node->right=buildTree(preorder,++pos,inorder,i+1,right);
        }
        return node;
        
    }
};
// @lc code=end
