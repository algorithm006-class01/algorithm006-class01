public class LeetCode_105_569 {

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = new LeetCode_105_569().new Solution().buildTree(preorder, inorder);
		System.out.println( root.val );
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	return recurseBuildTree(preorder, inorder);
	    }
	    
	    TreeNode recurseBuildTree(int[] preorder, int[] inorder )
	    {
	    	if( preorder.length == 0 )
	    		return null;
	    	TreeNode root = new TreeNode(preorder[0]);
	    	int idx = arraySearch(inorder, preorder[0]);
	    	root.left = recurseBuildTree(subArray(preorder,1,idx),subArray(inorder,0,idx));
	    	root.right = recurseBuildTree(subArray(preorder,idx+1,preorder.length-idx-1),subArray(inorder,idx+1,inorder.length-idx-1));
	    	return root;
	    }
	    
	    int[] subArray( int[] a, int begin, int length )
	    {
	    	if( a.length < length+begin )
	    		return new int[0];
	    	int[] sub = new int[length];
	    	System.arraycopy(a, begin, sub, 0, length);
	    	return sub;
	    }
	    
	    int arraySearch( int[] a, int key ) {
	    	for ( int i = 0; i < a.length; i++ ) {
	    		if ( a[i] == key )
	    			return i;
	    	}
	    	return -1;
	    }
	}
}
