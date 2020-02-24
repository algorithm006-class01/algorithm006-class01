// 104. 二叉树的最大深度
// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
// 递归 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

// 用辅助函数，用全局变量
class Solution {
public:
    int max = 0;
    int maxDepth(TreeNode* root) {
        
        findMax(root, 0);
        return max;
    }
    void findMax(TreeNode* root, int n){
        if (root == nullptr) {
            if ( n > max ) max = n;
            return;
        }
        findMax(root->left, n+1);
        findMax(root->right, n+1);
        
        return;
    }
};

//用辅助函数，不用全局变量
class Solution {
public:

    int maxDepth(TreeNode* root) {
        
        int max = findMax(root,  0);
        return max;
    }
    int findMax(TreeNode* root, int n){
        if (root == nullptr) {
            return n;
        }
        int left = findMax(root->left, n+1);
        int right =findMax(root->right, n+1);
        
        return max(left, right);
    }
};

//不用辅助函数，不用全局变量
class Solution {
public:

    int maxDepth(TreeNode* root) {
        if ( root == nullptr){
            return 0;
        }
        int left = maxDepth(root->left);
        int right = maxDepth(root->right);

        return max(left, right) + 1;
    }

};