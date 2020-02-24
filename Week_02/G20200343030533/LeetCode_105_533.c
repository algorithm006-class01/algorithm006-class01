#include<stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

typedef struct TreeNode Node;

Node* createNode(int val){
    Node *node = malloc(sizeof(Node));
    node->left = NULL;
    node->right = NULL;
    node->val = val;
    return node;
}

//寻找索引的函数，一定要注意，是一个等号
//因为最小区间起始和结果同一个位置
int findRoot(int val, int *inorder, int ib, int ie){
    for (int i = ib; i <= ie; i++){
        if ( inorder[i] == val){
            return i;
        }
    }
    return NULL;

}

//算法思想是分治， 难点是如何拆分数组
//先利用先序拆中序，然后用中旬拆前序
Node* DC(int* preorder, int pb, int pe, int* inorder, int ib, int ie){
    // 终止条件: 数组为空
    if (pb > pe ) return NULL;
    //利用preorder区间的第一个确定root
    Node *root = createNode(preorder[pb]);
    //利用root拆分inorder
    int rootIndex = findRoot(root->val, inorder, ib, ie);
    //确定左右子树大小
    int leftSize = rootIndex - ib;
    int rightSize = ie - rootIndex;

    root->left = DC(preorder, pb+1, pb+leftSize, inorder, ib, rootIndex-1);
    root->right = DC(preorder, pb+leftSize+1, pe, inorder, rootIndex+1, ie );
    
    return root;

}


struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){

    Node *root = DC(preorder, 0, preorderSize-1, inorder, 0, inorderSize);
    return root;
}


//优秀的代码
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    // 终止条件: 数组大小不同，或者前序为0
    if(preorderSize != inorderSize || preorderSize == 0)
        return NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = preorder[0];
    //遍历中序数组，找到分割点
    for(int i=0; i<inorderSize; i++)
    {
        if(inorder[i] == preorder[0])
        {
            //新的数组位置和大小
            root->left = buildTree(preorder+1, i, inorder, i);
            //对于右子树, 开始为+1+i, 结束就是-1-i
            root->right = buildTree(preorder+1+i, preorderSize-1-i, inorder+i+1,    
            preorderSize-1-i);
        }
    }
    return root;
}