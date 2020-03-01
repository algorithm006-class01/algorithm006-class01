import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * N-ary Tree Postorder Traversal
 * N叉树的后序遍历
 */
public class LeetCode_590_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode_590_569 main = new LeetCode_590_569();
		Node node1 = main.new Node(1);
		Node node3 = main.new Node(3);
		Node node2 = main.new Node(2);
		Node node4 = main.new Node(4);
		Node node5 = main.new Node(5);
		Node node6 = main.new Node(6);
		node1.children = new ArrayList();
		node1.children.add(node3);
		node1.children.add(node2);
		node1.children.add(node4);
		node3.children = new ArrayList();
		node3.children.add(node5);
		node3.children.add(node6);
		
		node2.children = new ArrayList();
		node4.children = new ArrayList();
		node5.children = new ArrayList();
		node6.children = new ArrayList();
		
		List<Integer> result = main.new Solution().postorder(node1);
		for(Integer v: result)
			System.out.println(v);
	}

	
	
	public class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	class Solution {
	    public List<Integer> postorder(Node root) {
	    	LinkedList<Integer> result = new LinkedList<Integer>();
	    	LinkedList<Node> stack = new LinkedList<Node>();	
	    	if ( root == null )
	    		return result;
	    	stack.push(root);
	    	while ( !stack.isEmpty() ) {
	    		Node node = stack.pollLast();
	    		result.addFirst(node.val);
	    		for ( Node n : node.children ) {
	    			if ( n != null )
	    				stack.add(n);
	    		}
	    	}
	    	return result;
	    }
	}
}
