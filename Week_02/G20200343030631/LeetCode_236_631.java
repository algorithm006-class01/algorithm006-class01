
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 解题思路: 递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 8 ms, 在所有 Java 提交中击败了99.67%的用户
     * 内存消耗: 42 MB, 在所有 Java 提交中击败了5.02%的用户
     *
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public static TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        // 边界条件
        if (null == root || null == p || null == q){
            return root;
        }
        recurseAncestorInternal(root, p, q);
        return result;
    }

    private static boolean recurseAncestorInternal(TreeNode current, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (null == current){
            return false;
        }

        // 递归下钻
        int findInLeft = recurseAncestorInternal(current.left, p, q) ? 1 : 0;
        int findInRight = recurseAncestorInternal(current.right, p, q) ? 1 : 0;

        // 本层处理
        int findArCurrent = (current == q || current == p) ? 1 : 0;

        // 如果在左右子树、当前节点任何两个中发现p q，则返回当前节点
        if ((findArCurrent + findInLeft + findInRight) >=2){
            result = current;
        }
        // 没有找到，返回当前节点下查找结果
        return (findArCurrent + findInLeft + findInRight) > 0 ;
    }

    /**
     * 解题思路: 分别找到从根节点到p q的节点路径，找到共同存在的一个节点
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 15 ms, 在所有 Java 提交中击败了18.20%的用户
     * 内存消耗: 41.2 MB, 在所有 Java 提交中击败了5.02%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        // 边界条件
        if (null == root || null == p || null == q){
            return root;
        }
        // 存放遍历时的节点
        Deque<TreeNode> nodeTraversStack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        // root的根为null
        parentMap.put(root, null);
        // root压入栈中
        nodeTraversStack.add(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)){
            TreeNode node = nodeTraversStack.pop();
            // 如果左子树不为空，左子树入栈，同时加入到parentMap中
            if (null != node.left){
                parentMap.put(node.left, node);
                nodeTraversStack.add(node.left);
            }
            // 如果右子树不为空，左子树入栈，同时加入到parentMap中
            if (null != node.right){
                parentMap.put(node.right, node);
                nodeTraversStack.add(node.right);
            }
        }
        // 存放节点p祖先
        Set<TreeNode> ancestors = new HashSet<>();
        // 循环将所有p的祖先加入set中
        while (p != null){
            ancestors.add(p);
            p = parentMap.get(p);
        }
        // 循环q的祖先，找到第一个q的祖先且在p的祖先set中的节点
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
