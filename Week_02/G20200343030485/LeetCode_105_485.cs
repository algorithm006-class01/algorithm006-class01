/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int preIndex = 0;
    public int[] _preoder;
    public int[] _inorder;
    Dictionary<int, int> indexDict = new Dictionary<int, int>();

    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        _preoder = preorder;
        _inorder = inorder;
        for (int i = 0; i < inorder.Length; i++) {
            indexDict[inorder[i]] = i;
        }

        TreeNode node = RecusiveTree(0, inorder.Length);
        return node;
    }

    public TreeNode RecusiveTree(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }

        int val = _preoder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(val);
        int index = indexDict[root.val];
        root.left = RecusiveTree(leftIndex, index);
        root.right = RecusiveTree(index + 1, rightIndex);

        return root;
    }
}