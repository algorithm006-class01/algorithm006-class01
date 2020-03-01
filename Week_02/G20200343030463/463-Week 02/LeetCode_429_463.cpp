题目: N叉树的层序遍历
解题思路:利用队列 将每一层的节点放入队列中,依次出队列 将元素放入当前数组中
参考资料L:
https://leetcode.com/problems/n-ary-tree-level-order-traversal/discuss/159086/Basic-C%2B%2B-iterative-solution-with-detailed-explanations.-Super-easy-for-beginners.
解法如下:
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(!root) return {};
        vector<vector<int>> res;
        Node *temp = root;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            vector<int>curLevel; //当前层级数组
            int size = q.size(); //队列进行遍历
            for(int i =0; i< size;i++){
                temp = q.front(); //huoqu
                q.pop();
                curLevel.push_back(temp->val); //遍历得到元素放入层级数组中
                for(auto n : temp->children){ //将每个节点的叶子节点放入队列中
                    q.push(n);
                }
            }
            res.push_back(curLevel); //将当前数组放入结果数组中
        }
        return res;
    }
};




