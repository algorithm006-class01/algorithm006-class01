class Solution {
    // 前序递归遍历
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		preorderTraversal_h(root, list);
		return list;
	}

	private void preorderTraversal_h(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		list.add(node.val);
		preorderTraversal_h(node.left, list);
		preorderTraversal_h(node.right, list);
	}

	// 前序的stack
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				list.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				node = node.left;
			}
			if (!stack.isEmpty())
				node = stack.pop();
		}
		return list;
	}
}