/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    HashMap<Integer,Integer> map = new HashMap<>();
    int preIdx = 0;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (int i : inorder) {
            map.put(i,idx++);
        }
        return helper(0,inorder.length);
    }

    public TreeNode helper(int inLeft, int inRight){
        if(inLeft == inRight){
            return null;
        }
        int rootVal = this.preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int midIndex = map.get(rootVal);
        preIdx++;
        root.left = helper(inLeft,midIndex);
        root.right = helper(midIndex+1,inRight);
        return root;

    }
}