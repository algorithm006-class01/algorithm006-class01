package secondWork;
//借助leetcode的解法
import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Stack;

public class work105 {

	private int pre=0;
	private int in=0;
	public TreeNode buildTree(int [] preorder, int [] inorder) {
		return buildTree(preorder,inorder,Integer.MAX_VALUE+1);
	}
	public TreeNode buildTree(int [] preorder,int [] inorder,long stop){
		if(pre==preorder.length){
			return null;
		}
		if(inorder[in]==stop){
			in++;
			return null;
		}
		int val=preorder[pre++];
		TreeNode root= new TreeNode(val);
		root.left=buildTree(preorder,inorder,val);
		root.right=buildTree(preorder,inorder,stop);
		return root;
	}
	}

