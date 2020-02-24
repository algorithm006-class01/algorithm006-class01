class Solution {
     //后序遍历,实际上就是层序遍历,每一层逆着输出就好
	public List<Integer> postorderTraversal(TreeNode root) {
		//输入的时候，做栈输入，输出的时候做list
		LinkedList<Integer> list = new LinkedList<>();
		if(root==null) return list;
		Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
        	root =stack.pop();
        	list.addFirst(root.val);
        	if(root.left!=null) stack.push(root.left); 
        	if(root.right!=null) stack.push(root.right);          	        	      	      	
        }
		return list;
	}
	
	//后序遍历
	
	public List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode cur = root;
	    TreeNode last = null;
	    while (cur != null || !stack.isEmpty()) {
	        if (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        } else {
	            TreeNode temp = stack.peek();
	            //如果右子树不为空，并且 temp.right != last(这个说明,这个节点不是从右子树回来的.)       
	            //所以要变到右子树.
	            if (temp.right != null && temp.right != last) {
	                cur = temp.right;
	            } else {
	            	/*这个节点左子树肯定为空，如果右子树为空，说明是叶子节点，可以输出。
	            	 * 如果右子树是上次访问的节点，说明右子树已经输出，这个是根，需要输出了。
	            	 * */
	                list.add(temp.val);
	                last = temp;
	                /*为什么只在这种情况下对last进行赋值呢？
	                 * 因为当前情况，这个节点肯定没有左子树。所以只考虑右子树的情况。
	                 * 如果第一次遍历，这个节点就肯定是叶子节点。
	                 * 如果是左孩子。实际上没有用。
	                 * 如果是右孩子，则意味着输出了右孩子后，还需要回到父亲节点。
*/	                stack.pop();
	            }
	        }
	    }
	    return list;
	}
}