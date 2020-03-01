import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode_236_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode_236_569 main = new LeetCode_236_569();
		
		TreeNode result = main.new Solution().lowestCommonAncestor(null, null, null);
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	class Solution {
		TreeNode ancestor;
		
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    	recurseFind(root, p, q);
	    	return ancestor;
	    }
	    
	    int recurseFind(TreeNode node, TreeNode p, TreeNode q) {
	    	if ( node == null )
	    		return 0;
	    	if ( ancestor != null )
	    		return 0;
	    	
	    	int leftFlag = recurseFind(node.left, p, q);
	    	int rightFlag = recurseFind(node.right, p, q);
	    	int pFlag = (node == p || node==q) ? 1 : 0;
	    	
	    	if( leftFlag + rightFlag + pFlag >=2 )
	    		ancestor = node;
	    	
	    	return (leftFlag + rightFlag + pFlag)>0 ? 1 : 0;
	    }
	}
}
