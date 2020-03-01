// 236. 二叉树的最近公共祖先
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //如果当前节点为空, 或者是p,q的一个，返回该节点
        if( root == nullptr|| root == p || root == q){
            return root;
        }
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        //在左右分别找到了p和q, 那么当前节点就是LCA
        if ( left != nullptr && right != nullptr) {
            return root;
        }
        // 否则说明，在一边上找到了p和q
        return left != nullptr ? left : right;
        
    }
};