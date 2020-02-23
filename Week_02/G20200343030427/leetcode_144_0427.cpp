class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
		if (root == NULL) 
        	return nodes;
        nodes.push_back(root -> val);
        preorderTraversal(root -> left);
        preorderTraversal(root -> right);
        return nodes;
    }
private:
	vector<int> nodes;
};