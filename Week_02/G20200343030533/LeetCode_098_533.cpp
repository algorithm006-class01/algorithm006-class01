// 98. 验证二叉搜索树
//https://leetcode-cn.com/problems/validate-binary-search-tree/

//分别遍历左子树和右子树
// 保证左节点都小于根节点，右节点都大于根节点
// 注意点：一定要注意边界检查
class Solution {
public:
    bool isValidBST(TreeNode* root) {

        long long low = (long long)INT_MIN - 1;
        long long high= (long long)INT_MAX + 1;

        return DFS(root, low, high);
        
    }
    bool DFS(TreeNode* root, long long low, long long high){
        if ( root == nullptr) return true;
        if ( root->val <= low || root->val >= high) return false;

        //左树更新上界，右树更新下界
        return DFS(root->left, low, root->val) && DFS(root->right,root->val, high);
    }
};