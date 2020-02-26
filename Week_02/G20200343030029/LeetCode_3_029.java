class LeetCode_3_029 {

	// 题目：给定一个 N 叉树，返回其节点值的前序遍历。（根左右）

	private static List<Integer> array = new ArrayList<Integer>();

	public List<Integer> postorder(Node root) {
		helper(root);
		return array;
	}

	private void helper(Node node) {

		if(null == node) {
			return;
		}

		array.add(node.val);

		for(int i = 0; i < node.children.size(); i++){
			helper(node.children.get(i));
		}

	// Node class
	private static class Node {

		public static int val;
		public static List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}