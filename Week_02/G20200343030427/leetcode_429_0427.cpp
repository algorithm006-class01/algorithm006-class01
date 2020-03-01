//广度优先遍历
//先添加一层
//一层一层遍历
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> results;
        if (root == NULL) 
        	return results;
        queue<Node*> que;
        que.push(root);
        while (!que.empty()) {
            vector<int> level;
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Node* node = que.front();
                que.pop();
                level.push_back(node -> val);
                for (auto child : node -> children)
                	que.push(child);
            }
            results.push_back(level);
        }
        return results;
    }
};