// 589. N叉树的前序遍历
// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
class Solution {
public:
    vector <int> res;
    void helper(Node *root){
        if (root == nullptr) return;
        res.push_back(root->val);
        vector<Node *> children = root->children;
        for( auto child : children){
            helper(child);
        }
    }
    vector<int> preorder(Node* root) {
        helper(root);
        return res;
    }
};