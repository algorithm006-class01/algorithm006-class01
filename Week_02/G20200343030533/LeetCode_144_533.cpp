// 44. 二叉树的前序遍历
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal
class Solution {
public:
    vector<int> res;
    void preOrder(TreeNode* root){
        if (root == nullptr) return;
        res.push_back(root->val);
        preOrder(root->left);
        preOrder(root->right);
    }
    vector<int> preorderTraversal(TreeNode* root) {

        preOrder(root);
        return res;
        
    }
};