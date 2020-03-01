//N叉树的层序遍历
//队列->广度优先搜索，栈->深度优先搜索

/*
// Definition for a Node.
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
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> values = new ArrayList<>();
        if (root == null){
            return values;
        }
        //用队列存放节点
        Queue<Node> queue = new LinkedList<>();
        //首先将根节点放到队列中
        queue.add(root);

        //如果队列不为空
        while (!queue.isEmpty){
            //用一个列表存放节点值
            List<Integer> level = new ArrayList<>();
            int size = queue.size;
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }

        return result;

    }
}