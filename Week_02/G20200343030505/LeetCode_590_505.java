/**
 * 递归
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:58:26
 */
class Solution_590_505 {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return result;
        }
        
        postorderTree(root);
        return result;
    }

    public void postorderTree(Node root) {
        if(root == null) {
            return;
        }

        if (root.children != null) {
            for (Node node:root.children) {
                postorder(node);
            }
        }

        result.add(root.val);
    }    
}

class Solution_590_505_2 {
    private LinkedList<Integer> result = new LinkedList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return result;
        }
        
        Stack<Node> stacks = new Stack<Node>();
        stacks.add(root);
        Node curr = null;
        while (!stacks.isEmpty()) {
            curr = stacks.pop();
            result.addFirst(curr.val);
            if (curr.children != null) {
                for(Node node:curr.children) {
                    stacks.add(node);
                }
            }
        }

        return result;
    } 
}
