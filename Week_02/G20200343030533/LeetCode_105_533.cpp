// 105. 从前序与中序遍历序列构造二叉树
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

 struct TreeNode {
   int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
    unordered_map<int, int> mp;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //记录inorder的值的位置，方便后续拆分
        for(int i = 0; i < inorder.size(); i++){
            mp[inorder[i]] = i;
        }
        return dc(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
    }
    /* 参数说明
     * pb, preorder begin
     * pe, preorder end
     * ib, inorder begin
     * ie, inorder end
     */ 
    TreeNode *dc(vector<int>& preorder, int pb, int pe, vector<int>& inorder, int ib, int ie){
        if( pb > pe ) return nullptr;

        TreeNode *root = new TreeNode(preorder[pb]);
        int rootIndex = mp[root->val]; //获取中序的位置
        int leftSize = rootIndex - ib; //左子树大小
        int rightSize = ie - rootIndex; //右子树大小
        root->left = dc(preorder,pb+1,pb+leftSize, inorder,ib, rootIndex-1); //新的左子树问题
        root->right = dc(preorder,pb+leftSize+1, pe, inorder, rootIndex+1, ie); //新的右子树问题

        return root;

    }
};
