package G20200343030391;

import java.util.HashMap;

public class LeetCode_106_391 {

    public static void main(String[] args) {
        //中序遍历
        int[] inorder = {9, 3, 15, 20, 7};
        //后序遍历
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = new LeetCode_106_391().buildTree(inorder, postorder);
        System.out.println(treeNode);

    }

    int[] inorder;
    int[] postorder;
    int root_postorder;
    HashMap<Integer, Integer> inorder_index_map = new HashMap<Integer, Integer>();

    /**
     * 递归
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorder_index_map.put(inorder[i], i);
        }
        root_postorder = postorder.length - 1;
        return help(0, inorder.length - 1);
    }

    /**
     * @param inorder_start
     * @param inorder_end
     * @return
     */
    private TreeNode help(int inorder_start, int inorder_end) {
        // 数组长度=0 递归结束条件
        if (inorder_start > inorder_end) {
            return null;
        }
        // 根节点
        int root_val = postorder[root_postorder];
        TreeNode root = new TreeNode(root_val);
        int root_index_inorder = inorder_index_map.get(root_val);

        //开始递归
        root_postorder--;
        root.right = help(root_index_inorder + 1, inorder_end);
        root.left = help(inorder_start, root_index_inorder - 1);
        return root;
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
