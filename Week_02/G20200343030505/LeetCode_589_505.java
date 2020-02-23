/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:57:29
 */
class Solution_589_505 {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }

        Stack<Node> stacks = new Stack<Node>();
        stacks.add(root);
        Node curr = null;
        while (!stacks.isEmpty()) {
            curr = stacks.pop();
            result.add(curr.val);
            if (curr.children != null) {
                for (int i=curr.children.size() - 1;i>=0;--i) {
                    stacks.add(curr.children.get(i));
                }
            }
        }

        return result;
    }
}

/**
 * 递归
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:57:48
 */
class Solution_589_505_2 {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        preorderTree(root);
        return result;
    }

    public void preorderTree(Node root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        if (root.children != null) {
            for (Node node:root.children) {
                preorderTree(node);
            }
        }
    }
}