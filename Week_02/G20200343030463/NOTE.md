学习笔记

二叉树的中序遍历 后序遍历 前序遍历
树的解法是通常使用递归:节点的定义和重复性
一部电影<<盗梦空间>>
递归的特点:
001 向下进入不同的递归层,向上又回到原来一层
002 通过声音同步到上一层,所谓同步就是用参数来进行函数不同层之间的传递变量
003 每一层的环境和周围的人都是一份拷贝,主角等几个人(参数和全局变量)穿越不同层级的梦境(发生和携带变化)

中序遍历:
/**
* Definition for a binary tree node.
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
class Solution {
public:
vector<int> inorderTraversal(TreeNode* root) {
vector<int> res;
dfs(res,root);
return res;
}
void dfs(vector<int>&res, TreeNode* root){
if(root ==NULL) return;
dfs(res,root->left);
res.push_back(root->val);
dfs(res,root->right);
}
};

中序遍历:
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
二叉树后序遍历:
class Solution {
public:
vector<int> postorderTraversal(TreeNode* root) {
vector<int> res;
dfs(res,root);
return res;
}
void dfs(vector<int>&res,TreeNode *root){
if(!root) return
dfs(res,root->left);
dfs(res,root->right);
res.push_back(root->val);
}
};

N叉树的后序遍历
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



