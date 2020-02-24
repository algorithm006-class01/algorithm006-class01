/**
 * 144 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    // 使用迭代
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    vector<int> preorderTraversal(TreeNode* root) {
        if(root == NULL){
            return vector<int>();
        }

        vector<int> res;
        stack<TreeNode *> treeStack;
        treeStack.push(root);  //将根节点入栈

        while(!treeStack.empty()){
            TreeNode *tmp = treeStack.top();
            res.push_back(tmp->val);
            treeStack.pop();

            // 先将右节点入栈
            if(tmp->right != NULL){
                treeStack.push(tmp->right);
            }
            // 将左节点入栈
            if(tmp->left != NULL){
                treeStack.push(tmp->left);
            }
        }

        return res;
    }

    // 使用递归
    vector<int> preorderTraversal1(TreeNode* root) {
        vector<int> res;
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode* root, vector<int>& node){
        if(!root){
            return;
        }
        node.push_back(root->val);
        inorder(root->left, node);
        inorder(root->right, node);
    }
};