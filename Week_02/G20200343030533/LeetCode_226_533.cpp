// 226. 翻转二叉树
//https://leetcode-cn.com/problems/invert-binary-tree/submissions/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//一开始好无头绪，后来想到老师说的重复子问题，拒绝人肉暴力递归
//于是就发现问题变得简单起来，也就是每一层就是反转当前的两个子节点，然后分别对这两个子节点对后代进行反转
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        _invertTree(root);
        return root;
    }
    void _invertTree(TreeNode *root){
        //terminator
        if (root == nullptr) return;
        // process logical
        TreeNode *temp;
        temp = root->left;
        root->left = root->right;
        root->right =temp;
        //drill down
        _invertTree(root->left);
        _invertTree(root->right);
        return ;
    }
};