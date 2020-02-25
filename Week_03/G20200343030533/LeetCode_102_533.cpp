// 102. 二叉树的层次遍历
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

//和BFS模版不同处在于，在while循环内嵌套了一层for循环
//原来对每个循环处理一个node，现在每个循环处理一层node

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;
        if ( root == NULL ) return ret;

        queue<TreeNode*> myque;
        myque.push(root);
        
        while ( ! myque.empty() ){
            vector<int> curr;
            int level_size = myque.size();
            for (int i = 0; i < level_size; ++i){
                TreeNode *node = myque.front();
                myque.pop();
                curr.push_back(node->val);
                if (node->left != NULL ) myque.push(node->left);
                if (node->right != NULL ) myque.push(node->right);
            }
            ret.push_back(curr);
        }
        return ret;

    }
};