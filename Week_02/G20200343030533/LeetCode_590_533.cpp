// 590. N叉树的后序遍历
// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/submissions/

// 方法1: 递归
// 把原来的两行代码改成循环就行了
class Solution {
public:
    vector<int> res;
    void helper(Node *root){
        if (root == nullptr) return ;
        vector<Node*> children = root->children;
        for( auto child : children){
            helper(child);
        }
        res.push_back(root->val);
    }
    vector<int> postorder(Node* root) {
        helper(root);
        return res;
    }
};