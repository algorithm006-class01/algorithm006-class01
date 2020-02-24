题目:二叉树的前序遍历
解法1:递归
递归的格式:
001 终止条件
002 具体执行操作
003 下一层执行的操作:层级增加,将相关元素带入
004 清扫当前状态

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        dfs(res,root);
        return res;
    }
    
    void dfs(vector<int>&res,TreeNode *root){
        if(!root) return;
        res.push_back(root->val);
        dfs(res,root->left);
        dfs(res,root->right);
    }
};

解法二:利用栈来管理递归调用 先放入右子树节点 再放左子树阶段 这样栈顶的元素就是左子树节点 出栈就是左子树先出来

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        TreeNode *temp = root;
        stack<TreeNode *>s;
        s.push(root);
        while(!s.empty()){
            temp = s.top();
            s.pop();
            res.push_back(temp->val);
            if(temp->right) s.push(temp->right);
            if(temp->left) s.push(temp->left);
        }
        return res;
    }
};
