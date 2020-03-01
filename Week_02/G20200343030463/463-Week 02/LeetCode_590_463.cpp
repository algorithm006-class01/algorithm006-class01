//
题目:N叉树的后序遍历

解法1:利用深度递归遍历的方式

class Solution {
public:
    vector<int> postorder(Node* root) {
        
        vector<int>res;
        dfs(res,root);
        return res;
    }
    
    void dfs(vector<int>&res,Node *root){
        if(!root) return;
        for(int i=0; i < root->children.size();i++){
            Node *node = root->children[i];
            if(node) dfs(res,node);
        }
        res.push_back(root->val);
    }
    
};
解法2:空间换时间的思路 通过栈模拟递归的调用 这里需要注意一段代码就是reverse(res.begin(), res.end());
    递归存入vector中的元素是和后序遍历相反的顺序 所以需要翻转一下

class Solution {
public:
    vector<int> postorder(Node* root) {
        
        if(root==NULL) return {};
        vector<int> res;
        stack<Node*> stk;
        stk.push(root);
        while(!stk.empty())
        {
            Node* temp=stk.top();
            stk.pop();
            for(int i=0;i<temp->children.size();i++) stk.push(temp->children[i]);
            res.push_back(temp->val);
        }
        reverse(res.begin(), res.end());
        return res;
    }
    
};
