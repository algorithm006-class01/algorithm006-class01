题目:二叉树的最近公共祖先
解题思路:
001 如果root 就是p q 那么公告祖先 要么是p 要么是q
002 现在开始递归操作 从左子树开始递归 获得叶子节点l 从右子树找获得叶子节点r
003 如果l为空 那就看r那边 如果 r为空则看l那边 l 和 r都就看root;l r 都为空的话就返回NULL
参考链接:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/


解法:
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(!root || root == p || root == q) return root;
        TreeNode *l = lowestCommonAncestor(root->left,p,q);
        TreeNode *r = lowestCommonAncestor(root->right,p,q);
        
        if(!l)
            return r;
        else if (!r)
            return l;
        else
            return root;
    }
};
