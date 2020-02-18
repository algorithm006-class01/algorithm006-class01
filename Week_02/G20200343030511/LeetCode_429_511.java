class Solution {
    public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			List<Integer> per = new ArrayList<Integer>();
			//这里通过固定的size判断层级
			int size =queue.size();
			for (int i = 0; i < size ; i++) {
				Node tmp = queue.poll();
				per.add(tmp.val);
				queue.addAll(tmp.children);				
			}
			list.add(per);		
		}
		return list;
	}
	
	
	
	public List<List<Integer>> levelOrder1(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		List<Node> pre = Arrays.asList(root);
		while(pre!=null&&pre.size()!=0){
			List<Integer> level = new ArrayList<>();
			List<Node> current =new ArrayList<>();
			for (Node tmp:pre) {
				level.add(tmp.val);
				current.addAll(tmp.children);
			}
			list.add(level);
			pre = current;
		}
			return list;
	}
	
	//递归 
	public List<List<Integer>> levelOrder3(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
         traverseNode(root, 0,list);
        return list;
    }

    private void traverseNode(Node node, int level,List<List<Integer>> result) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1,result);
        }
    }
}