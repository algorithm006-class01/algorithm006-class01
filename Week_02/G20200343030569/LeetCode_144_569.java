import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 144. Binary Tree Preorder Traversal
 * 二叉树的前序遍历
 */
public class LeetCode_144_569 {
	int index;
	
	TreeNode buildTreeNode(Integer data[]){
		if( index >= data.length )
			return null;
	    Integer value = data[index++];
	    TreeNode node = null;
	    if ( value != null ) {
	    	node = new TreeNode(value);
	    	node.left = buildTreeNode(data);
	    	node.right = buildTreeNode(data);        
	    }
	    return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输入: [1,null,2,3] 
		Integer[] treeData = { 1, null, 2, 3 };
		LeetCode_144_569 main = new LeetCode_144_569();
		TreeNode node = main.buildTreeNode(treeData);
		
		List<Integer> result = main.new Solution().preorderTraversal(node);
		for(Integer v: result)
			System.out.println(v);
	}
	


	public class TreeNode {
		int val;
		TreeNode left;
	 	TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	class Solution {
	    public List<Integer> preorderTraversal(TreeNode root) {
	    	List<Integer> result = new LinkedList<Integer>();
	    	Stack<TreeNode> stack = new Stack<TreeNode>();	    	
	    	if ( root == null )
	    		return result;	    	
	    	stack.push(root);
	    	while ( !stack.isEmpty() ) {
	    		TreeNode node = stack.pop();
	    		result.add( node.val );
	    		if ( node.right != null )
	    			stack.push( node.right );
	    		if ( node.left != null )
	    			stack.push( node.left );
	    	}
	    	
	    	return result;
	    }
	}
}
