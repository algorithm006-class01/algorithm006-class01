class Solution {
    // 暴力。先找到P的祖先，再找到q的祖先，最后看P，q的祖先最近的一个。
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || p == null || q == null)
			return null;

		ArrayList<TreeNode> pList = new ArrayList<>();
		boolean pfound =search(root, p,pList);
		ArrayList<TreeNode> qList = new ArrayList<>();
		boolean qfound =search(root, q,qList);

		if (!pfound && !qfound) {
			return null;
		}

		// 找到两个节点最近的一个相同的节点
		int psize = pList.size() - 1;
		int qsize = qList.size() - 1;
		for (int i = psize; i >= 0; i--) {
			for (int j = qsize; j >= 0; j--) {
				if (pList.get(i).val == qList.get(j).val) {
					return pList.get(i);
				}
			}
		}
		return null;
	}

	private boolean search(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
		// 递归终止条件
		if (root.val == node.val){
			list.add(root);
			return true;
		}
		// 当前处理
         list.add(root);
         boolean found =false;
		// 递归
         if(root.left!=null) found=search(root.left, node, list);
         if(!found&&root.right!=null) found=search(root.right, node, list);
		// 清除状态。
		if(!found) list.remove(list.size()-1);		
		return found;				
	}
	
	//简化版
		public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		return help(root, p, q);
	}

	private TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
		// 终止条件
		if (root == null || root == q || root == p)
			return root;
		// 当前处理
		// 递归
		TreeNode l = help(root.left, p, q);
		if (l != null && l != p && l != q)
			return l;
		TreeNode r = help(root.right, p, q);
		if (l != null && r != null)
			return root;
		else {
			return l == null ? r : l;
		}
	}
}