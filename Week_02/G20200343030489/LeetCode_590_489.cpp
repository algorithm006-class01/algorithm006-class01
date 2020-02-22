/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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
vector<int> v;
    vector<int> postorder(Node* root) {
        if (!root)
        {
            /* code */return {};
        }
        stack<Node *> sta;
        Node* tmp;
        sta.push(root);
        while (sta.size())
        {
            /* code */tmp=sta.top();
            sta.pop();
            v.push_back(tmp->val);
            for (Node* node : tmp->children)
            {
                /* code */sta.push(node);
            }          
        }
        reverse(v.begin(),v.end());
        return v;  
    }
};
// @lc code=end

