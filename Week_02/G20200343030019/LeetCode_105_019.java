class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, new int[]{0}, new int[]{0}, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int[] pre, int[] index, int max) {
        if (index[0] == inorder.length || inorder[index[0]] == max) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre[0]]);
        pre[0] ++;
        TreeNode left = build(preorder, inorder, pre, index, node.val);

        index[0] ++;
        TreeNode right = build(preorder, inorder, pre, index, max);
        node.left = left;
        node.right = right;
        return node;
    }
}