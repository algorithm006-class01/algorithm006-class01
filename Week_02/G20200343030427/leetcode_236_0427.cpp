class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL) return NULL;
        return dfs(root, p, q);
    }
    
    TreeNode* bfs(TreeNode* root, TreeNode* p, TreeNode* q) {

        if(root == NULL) return NULL;
        if(root == p) return p;
        if(root == q) return q;
        
        TreeNode* l = dfs(root -> left, p, q); 
        TreeNode* r = dfs(root -> right, p, q); 
        

        if(l != NULL && r != NULL) return root;
        else if(l != NULL) return l;
        else return r;
    }
};
