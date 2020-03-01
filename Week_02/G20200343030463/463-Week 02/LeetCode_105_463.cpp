题目:从前序与中序遍历序列构造二叉树
解题思路:
官方题解https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-he-zhong-xu-bian-li-xu-lie-gou-zao-er/
代码入下:
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        int preIndex =0;
        return recurTree(preorder,preIndex,inorder,0,inorder.size()-1);
        
    }
    
    TreeNode *recurTree(vector<int>& preorder,int &preIndex,vector<int>& inorder,int left, int right){
        if (preIndex == preorder.size()) return 0;
        int i = left;
        for(i=left;i<=right;++i){ //从中序遍历中找到前序遍历的元素的索引
            if(inorder[i]==preorder[preIndex]) break;
        }
        
        TreeNode *node = new TreeNode(preorder[preIndex]);
        //将中序遍历以索引i一分为二
        //左子树就从中序遍历前半个数组中开始找
        //右子树就从中序遍历后半个数组中开始找
        if(left<=i-1) node->left = recurTree(preorder,++preIndex,inorder,left,i-1);
        if(right>=i+1) node->right = recurTree(preorder,++preIndex,inorder,i+1,right);
        return node;
    }
    
    
};
