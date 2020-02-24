题目: N叉树的前序遍历
思路一:递归调用
解法一:
class Solution {
public:
    vector<int> preorder(Node* root) {
        
        vector<int> res;
        recupreorder(res,root);
        return res;
    }
    
    void recupreorder( vector<int>& res, Node*root){
        if(!root) return;
        res.push_back(root->val);
        for(int i =0;i<root->children.size();i++){
            Node* item = root->children[i];
            if(!item) continue;
            recupreorder(res,item);
        }
    }
};

解法二: 将解法一中的循环for(int i =0;i<root->children.size();i++) 改为  for(Node* item : root->children)
class Solution {
public:
    vector<int> res;
    vector<int> preorder(Node* root) {
        recupreorder(root);
        return res;
    }
    
    void recupreorder( Node*root){
        if(!root) return;
        res.push_back(root->val);
        for(Node* item : root->children){
            recupreorder(item);
        }
    }
};
思路二:利用栈的特质进行模拟递归调用
class Solution {
public:
    
    vector<int> preorder(Node* root) {
        vector<int> result;
        if (root == nullptr) {
            return result;
        }
        
        stack<Node*> stk;
        stk.push(root);
        while (!stk.empty()) {
            Node* cur = stk.top();
            stk.pop();
            result.push_back(cur -> val);
            for (int i = cur -> children.size() - 1; i >= 0; i--) {
                if (cur -> children[i] != nullptr) {
                    stk.push(cur -> children[i]);
                }
            }
        }
        return result;
    }

};

