class Solution {
    public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root ==null) return list;
		preorder_h(root,list);
		return list;
	}

	private void preorder_h(Node node, List<Integer> list) {
		if(node ==null) return;
		list.add(node.val);
		for(Node tmp:node.children){
			preorder_h(tmp,list);
		}		
	}
	//迭代
	public List<Integer> preorder1(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while(!stack.empty()){
        	Node node =stack.pop();
        	list.add(node.val);
            Collections.reverse(node.children);
            for(Node temp:node.children) stack.push(temp);
        }              
        return list;
	}
}