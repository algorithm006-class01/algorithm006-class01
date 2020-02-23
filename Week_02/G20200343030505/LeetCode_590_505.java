class Solution_590_505 {
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