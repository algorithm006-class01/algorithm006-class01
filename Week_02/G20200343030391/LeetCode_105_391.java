package G20200343030391;

import java.util.HashMap;

public class LeetCode_105_391 {
    public static void main(String[] args) {
        //前序遍历
        int[] preorder = {3, 9, 20, 15, 7};
        //中序遍历
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = new LeetCode_105_391().buildTree(preorder, inorder);
        System.out.println(treeNode);

    }

    int[] preorder;
    int[] inorder;
    int root_preorder = 0;
    HashMap<Integer, Integer> inorder_idx_map = new HashMap<Integer, Integer>();

    /**
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
//        中序遍历数组作为左右子树拆分的入口
        for (int i = 0; i < inorder.length; i++) {
            this.inorder_idx_map.put(inorder[i], i);
        }
        return help(0, inorder.length - 1);
    }

    /**
     * 递归
     *
     * @param inorder_start
     * @param inorder_end
     * @return
     */
    private TreeNode help(int inorder_start, int inorder_end) {
        //递归终止条件
        if (inorder_start > inorder_end) {
            return null;
        }
        //根节点值
        int root_val = preorder[root_preorder];
        TreeNode root_node = new TreeNode(root_val);
        //以根节点下标分割中序遍历数组左右子树
        int root_idx_inorder = inorder_idx_map.get(root_val);
        //开始递归
        //前序遍历下一个根节点下标
        root_preorder++;
        //构建左子树
        root_node.left = help(inorder_start, root_idx_inorder - 1);
        //构建右子树
        root_node.right = help(root_idx_inorder + 1, inorder_end);
        return root_node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
