class Solution {
    public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		postorder_h(root, list);
		return list;
	}

	private void postorder_h(Node node, List<Integer> list) {
		if (node == null)
			return;
		for (Node tmp : node.children) {
			postorder_h(tmp, list);
		}
		list.add(node.val);
	}
	
	public List<Integer> postorder1(Node root) {
		  Stack<Node> stack = new Stack<>();
		  LinkedList<Integer> output = new LinkedList<>();
	        if (root == null) {
	            return output;
	        }

	      stack.add(root);
	      while (!stack.isEmpty()) {
	          Node node = stack.pop();
	          output.addFirst(node.val);
	          for (Node item : node.children) {
	              if (item != null) {
	                  stack.add(item);    
	              } 
	          }
	      }
	      return output;
	    }
}