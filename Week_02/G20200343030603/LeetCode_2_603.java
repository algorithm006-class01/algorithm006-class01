//N叉树后序遍历

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
    //方法一：递归
    // List<Integer> result = new ArrayList<>();
    // public List<Integer> postorder(Node root) {
    //     if (root != null){
    //         for (int i = 0; i < root.children.size(); i++){
    //             postorder(root.children.get(i));
    //         }
    //         result.add(root.val);
    //     }
    //     return result;
    // }


    // 方法二：迭代
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();//pollLast 返回最后一个元素
            output.addFirst(node.val);
            for (Node item : node.children){
                if (item != null){
                    stack.add(item);
                }
            }
        }
        return output;
    }
}