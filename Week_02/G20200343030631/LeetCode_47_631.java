
public class Solution {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> subTree1 = new LinkedList<>();
        subTree1.add(node3);
        subTree1.add(node2);
        subTree1.add(node4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> subTree2 = new LinkedList<>();
        subTree2.add(node5);
        subTree2.add(node6);
        node3.children = subTree2;
        root.children = subTree1;
        List<Integer> result = preorder(root);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    /**
     * 解题思路: 递归方式
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 执行用时: 1 ms, 在所有 Java 提交中击败了99.62%的用户
     * 内存消耗: 41.5 MB, 在所有 Java 提交中击败了5.02%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public static List<Integer> preorderV1(Node root) {
        // 前序遍历结果集
        List<Integer> result = new ArrayList<>();
        // 边界条件，如果root为null，直接返回空集合
        if (null == root){
            return result;
        }
        // 前序遍历辅助函数
        preOrderInternal(root, result);
        return result;
    }

    /**
     * @param root 要进行前序遍历的节点
     * @param result 遍历后的节点结果值集合
     * @return
     */
    private static void preOrderInternal(Node root, List<Integer> result) {
        // 递归终止条件
        if (root == null){
            return;
        }
        // 当前层处理：1. 将当前结果加入result， 2. 如果子节点为空则返回，不为空遍历当前节点的子节点
        result.add(root.val);
        List<Node> childrens = root.children;
        if (null == childrens){
            return;
        }
        // 子节点不为空，继续遍历子节点
        for (Node child : childrens) {
            preOrderInternal(child, result);
        }
    }

    /**
     * 解题思路: 使用栈的迭代方式
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 7 ms, 在所有 Java 提交中击败了5.62%的用户
     * 内存消耗: 41.5 MB, 在所有 Java 提交中击败了5.02%的用户
     *
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public static List<Integer> preorderV2(Node root) {
        // 前序遍历结果集
        List<Integer> result = new ArrayList<>();
        // 边界条件，如果root为null，直接返回空集合
        if (null == root) {
            return result;
        }
        // 记录节点的辅助栈
        Stack<Node> nodeRecordQueue = new Stack<>();
        // 首先将root节点压入栈中
        nodeRecordQueue.push(root);
        // 栈不为空，说明还有节点需要遍历，继续循环
        while (!nodeRecordQueue.isEmpty()) {
            Node tmpNode = nodeRecordQueue.pop();
            result.add(tmpNode.val);
            List<Node> childrens = tmpNode.children;
            if (null != childrens) {
                // 使用栈，先进后出，为保证前序根左右的顺序，从右侧开始压入栈
                for (int i = (childrens.size() - 1); i >= 0; i--) {
                    nodeRecordQueue.add(childrens.get(i));
                }
            }
        }
        return result;
    }


    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
