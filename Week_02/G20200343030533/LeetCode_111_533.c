//C的方法
int minDepth(struct TreeNode* root){

    if(root == NULL ) return 0;
    
    int left = minDepth(root->left);
    int right = minDepth(root->right);

	//左子树为空，left=0，当前高度为右子树+1
	//右子树为空，right=0，当前高度为左子树+1
	//两者都为空，left，right都为0, 那就是0+1
    if (root->left == NULL || root->right == NULL){
        return left > right ? left+1 : right +1;
    } else{
		//都不为空，就返回比较小的+1
        return left > right ? right + 1 : left + 1;
    }

    
}
