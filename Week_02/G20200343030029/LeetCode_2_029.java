class LeetCode_2_029 {

	// 题目：给定一个 N 叉树，返回其节点值的后序遍历（左右根）

	private static List<Integer> array = new ArrayList<Integer>();


	public static List<Integer> recursiveSolution(Node node){
		recursiveHelper(node);
		return array;
	}

	private static void recursiveHelper(Node node) {
		if(null == node) {
			return;
		}

		for(int i = 0; i < node.children.size(); i++) {
			recursiveHelper(node.children.get(i));
		}

		array.add(node.val);
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