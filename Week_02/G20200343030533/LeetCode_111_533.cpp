// 111. 二叉树的最小深度
// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/

//错误示范, 在碰到[0],[1,2]的时候直接错
class Solution {
public:
    int min = INT_MAX;
    void findMin(TreeNode *root, int n){
        if (root == nullptr) {
            if (n < min) min = n;
            return;
        }
        findMin(root->left, n+1);
        findMin(root->right, n+1);
        return;

    }
    int minDepth(TreeNode* root) {
        findMin(root, 0);
        return min;
        
    }
};

// 为了能够通过[0]和[1,2], 就直接在主函数修改，发现依旧出错
class Solution {

    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        if (root->left == nullptr && root->right == nullptr ) return 1;
        findMin(root, 0);
        
        return min == 1 ? 2 : min;
        
    }
}

/* 上面的代码想当然了，直接套用找最大深度的方法，没有认真思考过叶子节点的

叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
- 当 root 节点左右孩子都为空时，返回 1
- 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
- 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
*/

//重新理清思路后
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        //找左边最低深度
        int left = minDepth(root->left);
        //找右边最低深度
        int right = minDepth(root->right);
        // 如果左右子树有一个为空，说明当前不是叶子节点
        // 当前的深度就是左右节点中不为空（返回0）的节点深度+1
        if ( root->left == nullptr || root->right == nullptr){
            return left == 0 ? right + 1 : left + 1;
        }
        // 否则返回的是其中最小的+1
        return min(left, right) + 1;
        
    }
};