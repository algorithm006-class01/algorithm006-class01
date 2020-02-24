/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> result;

        _preorder(root, result);

        return result;
    }

    void _preorder(Node* node, vector<int>& ret) {
        // terminate
        if (node==nullptr) {
            return;
        }

        // next level
        ret.push_back(node->val);

        for (auto &i:node->children) {
            _preorder(i, ret);
        }
        
        return;
    }
};
