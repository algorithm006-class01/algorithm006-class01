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
        vector<int> ve;
        if (!root) return ve;

        stack<Node*> st;
        st.push(root);
        while(!st.empty()) {
            Node *node = st.top();
            st.pop();

            if (node) {
                ve.emplace_back(node->val);
            } else {
                //continue;
            }
            
            if ( !node->children.empty() ) {
                int size = node->children.size();
                for ( int i=size-1; i>=0; i-- ) { //倒序 stack LIFO ,后压入先访问children
                    Node *n = node->children[i];
                    if (n) st.push(n);
                }
            }
        }
        return ve;
    }
};