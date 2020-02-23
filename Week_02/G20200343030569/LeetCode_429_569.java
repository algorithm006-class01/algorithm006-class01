import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LeetCode_429_569 {

	public static void main(String[] args) {
		LeetCode_429_569 main = new LeetCode_429_569();
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
		
		List<List<Integer>> result = main.new Solution().levelOrder(node1);
		for(List v: result)
			System.out.println(Arrays.toString(v.toArray()));
	}

	
	class Node {
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
	    public List<List<Integer>> levelOrder(Node root) {
	    	 List<List<Integer>> result = new ArrayList<>();
	         if (root == null) 
	        	 return result;
	         List<Node> levelNodes = new LinkedList<Node>();
	         levelNodes.add(root);
	         while( levelNodes.size() > 0 ) {
	        	 List<Node> nextLevelNodes = new LinkedList<Node>();
	        	 List<Integer> levelValues = new LinkedList<Integer>();
	        	 result.add(levelValues);
	        	 for( Node n : levelNodes ) {
	        		 levelValues.add(n.val);
	        		 for ( Node c : n.children ) {
	        			 nextLevelNodes.add(c);
	        		 }
	        	 }
	        	 levelNodes = nextLevelNodes;
	         }
	         return result;
	    }
	}
}
