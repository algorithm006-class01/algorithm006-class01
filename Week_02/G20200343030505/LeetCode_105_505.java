class LeetCode_105_505 {
	   private Map<Integer, Integer> map = new HashMap();
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        for (int i=0;i<inorder.length;++i) {
	            map.put(inorder[i], i);
	        }

	        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	    }

	    public TreeNode buildTree(int[] preorder, int p_left, int p_right, int[] inorder, int i_left, int i_right) {
	        //递归终止条件
	        if (p_left > p_right) {
	            return null;
	        }

	        TreeNode root = new TreeNode(preorder[p_left]);
	        int i_index = map.get(preorder[p_left]);
	        int leftNum = i_index - i_left;
	        root.left = buildTree(preorder, p_left + 1, p_left + leftNum, inorder, i_left, i_index - 1);
	        root.right = buildTree(preorder, p_left + leftNum + 1, p_right, inorder, i_index+1, i_right);

	        return root;
	    }
}