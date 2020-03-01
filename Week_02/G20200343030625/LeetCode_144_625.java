public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        travels(root, list);
        return list;
        //eturn travelsByIterator(root);
    }

    // 递归方式
    private void travels(TreeNode root, List<Integer> list) {
        if(root != null){
            list.add(root.val);
            if(root.left != null){
                travels(root.left, list);
            }
            if(root.right != null) {
                travels(root.right, list);
            }
        }
    }

    // 迭代方式
    private List<Integer> travelsByIterator(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            list.add(currentNode.val);
        }

        return list;
    }
}
