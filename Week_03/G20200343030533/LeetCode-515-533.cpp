// 515. 在每个树行中找最大值
//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

//这题思路和102题一样。因此会了102题之后就觉得很简单。
// 主要是队列中嵌套循环，每一次处理一层而不是一个。
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> res;
        if (root == NULL) return res;

        queue<TreeNode*> myque;
        myque.push(root);

        while ( ! myque.empty() ){
            int level_size = myque.size();
            int max = INT_MIN;
            for (int i = 0; i < level_size; i++){
                TreeNode *node = myque.front();
                myque.pop();
                max = node->val > max ? node->val : max;

                if (node->left != NULL) myque.push(node->left);
                if (node->right != NULL) myque.push(node->right); 
            }
            res.push_back(max);
        }
        return res;

    }
};

//深度优先代码，利用有序map存放结果（可以用数组）
class Solution {
public:

    vector<int> largestValues(TreeNode* root) {
        map<int, int> m;
        DFS(root, 0, m);
        //输出结果
        vector<int> res;
        for (auto &p : m){
            res.push_back(p.second);
        }
        return res;

    }

        void DFS(TreeNode* root, int d, map<int, int> & m){
        if (root == NULL) return;
        //利用字典记录深度
        m[d] = (m.count(d) == 0) ? root->val : max(m[d], root->val);
        
        DFS(root->left, d+1, m);
        DFS(root->right, d+1, m);
        return ;
    }

};