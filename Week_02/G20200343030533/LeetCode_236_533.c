// C版本的解决方法
typedef struct TreeNode node;
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    if ( root == NULL || root == p || root == q ){
        return root;
    }
    node *left = lowestCommonAncestor(root->left, p, q);
    node *right = lowestCommonAncestor(root->right, p, q);

    if ( left != NULL && right != NULL) {
        return root;
    }
    
    return left != NULL ? left : right;
    
}