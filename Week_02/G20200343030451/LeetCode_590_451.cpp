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
	vector<int> postorder(Node* root) {

		vector<int> ve;
        if (!root) return ve;

        stack<Node*> st;
        st.push(root);
        
        while (!st.empty()) {
            Node *node = st.top();
            st.pop();

            if (node) {
                ve.emplace_back(node->val);	//正序存vector val,再反转
                
                vector<Node*> chs = node->children;
                if (!chs.empty()) {
                    int size = chs.size();
                    for (int i =0; i< size; i++) {
                        Node *n =  chs[i];
                        if (n) st.push(n);	//stack为了倒序访问Node
                    }
                }
            }
        }
        reverse(ve.begin(),ve.end());
        return ve;
	}
};

