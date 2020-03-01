// 94.中序树的遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

//递归的方法
class Solution {
public:
    vector<int> res;
    void inOrder(TreeNode *root){
        if (root == nullptr) return;
        inOrder(root->left);
        res.push_back(root->val);
        inOrder(root->right);
    }
    vector<int> inorderTraversal(TreeNode* root) {
    
        inOrder(root);
        return res;
        
    }
};