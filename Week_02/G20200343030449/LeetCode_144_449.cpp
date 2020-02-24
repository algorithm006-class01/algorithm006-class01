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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        preorderCore(root, ret);

        return ret;
    }

    void preorderCore(TreeNode* node, vector<int>& result) {
        if (node!=nullptr) {
            result.push_back(node->val);
            preorderCore(node->left,result);
            preorderCore(node->right,result);
        }

        return;
    }
};
