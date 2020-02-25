/*
    类似于中序遍历，根据根-左-右的顺序递归
*/
class LeetCode_589_639 {
	public List<Integer> preorder(Node root) {
		List<Integer> res=new ArrayList<Integer>();
		public List<Integer> preorder(Node root) {
			helper(root);
			return res;
		}
		public void helper(Node root){
			if (root==null) return;
			res.add(root.val);
			for (int i = 0; i <root.children.size() ; i++) {
				helper(root.children.get(i));
			}
		}
	}
}