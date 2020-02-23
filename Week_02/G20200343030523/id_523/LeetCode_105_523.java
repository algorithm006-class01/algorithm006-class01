package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal01 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHeler(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHeler(int[] preorder, int pStart, int pEnd,
                                    int[] inorder, int iStart, int iEnd) {
        if (pStart >= pEnd) {
            return null;
        }

        if (iStart >= iEnd) {
            return null;
        }

        int value = preorder[pStart];
        int index = find(inorder, iStart, iEnd, value);

        int leftIndex = index - iStart;

        TreeNode node = new TreeNode(value);
        node.left = buildTreeHeler(preorder, pStart + 1, pStart + leftIndex + 1, inorder, iStart, index);
        node.right = buildTreeHeler(preorder, pStart + leftIndex + 1, pEnd, inorder, index + 1, iEnd);
        return node;
    }

    private int find(int[] inorder, int start, int end, int value) {
        int index = -1;
        for (int i = start; i < end; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 3, 1};

        ConstructBinaryTreeFromPreorderAndInorderTraversal01 tree = new ConstructBinaryTreeFromPreorderAndInorderTraversal01();
        TreeNode root = tree.buildTree(preorder, inorder);
    }

}
