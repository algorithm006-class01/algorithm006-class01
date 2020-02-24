import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 94. Binary Tree Inorder Traversal
 * 二叉树的中序遍历
 */
public class LeetCode_94_569 {

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
		LeetCode_94_569 main = new LeetCode_94_569();
		TreeNode node = main.buildTreeNode(treeData);
		
		List<Integer> result = main.new Solution().inorderTraversal(node);
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
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	List<Integer> result = new LinkedList<Integer>();
	    	Stack<TreeNode> stack = new Stack<TreeNode>();	  
	    	while ( !stack.isEmpty() || root != null ) {
	    		if ( root != null ) {
	    			stack.push(root);
	    			root = root.left;
	    		} else {
	    			TreeNode node = stack.pop();
	    			result.add(node.val);
	    			root = node.right;
	    		}
	    	}	    	
	    	return result;
	    }
	}
}
