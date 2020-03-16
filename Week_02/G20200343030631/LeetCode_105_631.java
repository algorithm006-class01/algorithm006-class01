
public class Solution {
    private static int currentNodeIndexInPreOrder = 0;
    public static void main(String[] args) {
        int[] preOrder = new int[]{-1};
        int[] inOrder = new int[]{-1};
        Version1 version1 = new Version1();
        TreeNode node = version1.buildTree(preOrder, inOrder);
        System.out.println(node);
    }

    /**
     * 解题思路: 根据前序、中序的特点，递归找到根节点、子树根节点，构建树
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 2 ms, 在所有 Java 提交中击败了97.23%的用户
     * 内存消耗: 41.2 MB, 在所有 Java 提交中击败了39.96%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 静态变量，每次初始化为0
        currentNodeIndexInPreOrder = 0;
        // 边界条件，任何一个为空，或者大小为0，无法重建
        if (null == preorder || null == inorder
                || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 将中序结果倒排索引式map存放，以便后续对前序结果快速找到在中序数组中位置
        Map<Integer, Integer> inOrderMap = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTreeInternal(preorder, inOrderMap, 0, inorder.length);
    }

    /**
     * @param preorder 前序遍历数组
     * @param inOrderMap 中序遍历转换后的map
     * @param indexOfLeftTreeInInOrder 在中序遍历数组中左子树的边界索引
     * @param indexOfRightTreeInInOrder 在中序遍历数组中右子树的边界索引
     * @return 当前子树
     */
    private static TreeNode buildTreeInternal(int[] preorder,
                                              Map<Integer, Integer> inOrderMap,
                                              int indexOfLeftTreeInInOrder,
                                              int indexOfRightTreeInInOrder) {
        // 递归终止条件，所有的数组元素都已经递归处理
        if (indexOfLeftTreeInInOrder == indexOfRightTreeInInOrder) {
            return null;
        }

        int currentRootNodeVal = preorder[currentNodeIndexInPreOrder];
        TreeNode currentRoot = new TreeNode(currentRootNodeVal);

        int leftSubTreeEdgeIndex = inOrderMap.get(currentRootNodeVal);
        currentNodeIndexInPreOrder++;
        currentRoot.left = buildTreeInternal(preorder, inOrderMap, indexOfLeftTreeInInOrder, leftSubTreeEdgeIndex);
        currentRoot.right = buildTreeInternal(preorder, inOrderMap, leftSubTreeEdgeIndex + 1, indexOfRightTreeInInOrder);
        return currentRoot;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
