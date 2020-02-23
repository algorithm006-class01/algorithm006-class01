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
    int root_preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

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
            this.idx_map.put(inorder[i], i);
        }
        return help(0, inorder.length);
    }

    /**
     * 递归
     *
     * @param inorder_left_start
     * @param left_inorder_length
     * @return
     */
    private TreeNode help(int inorder_left_start, int left_inorder_length) {
        //递归终止条件空数组
        if (inorder_left_start == left_inorder_length) {
            return null;
        }
        //根节点值
        int root_val = preorder[root_preorder];
        TreeNode root_node = new TreeNode(root_val);
        //以根节点下标分割中序遍历数组左右子树
        int root_idx_inorder = idx_map.get(root_val);
        //开始递归
        //前序遍历下一个根节点下标
        root_preorder++;
        //构建左子树
        root_node.left = help(inorder_left_start, root_idx_inorder);
        //构建右子树
        root_node.right = help(root_idx_inorder + 1, left_inorder_length);
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
