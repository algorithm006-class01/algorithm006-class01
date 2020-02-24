class Solution {

    /**
     * N叉树的后序遍历
     * 递归 比较好想
     * @param root
     * @return
     */
     public List<Integer> postorder(Node root) {
         List<Integer> res = new ArrayList<>();
         helper(root, res);
         return res;
     }

     public void helper(Node root, List<Integer> res) {
         if (root != null) {
             if (root.children!=null) {
                 for (Node node : root.children) {
                     helper(node, res);
                 }
             }
             res.add(root.val);
         }
     }

    /**
     * N叉树的后序遍历
     * 迭代法
     * 要想用迭代法 肯定就得用 栈
     * 从 左右根 -> 栈中顺序为 根右左
     * 这样出的时候就可以 左右根 的顺序出栈了
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            //每次向结果链表的第一个位置添加，之前的所有数组元素后移
            //与逆序输出结果相同
            res.add(0, node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }











}