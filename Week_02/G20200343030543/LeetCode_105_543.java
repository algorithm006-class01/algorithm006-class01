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
    //前序遍历结果遍历指针
    int pre_idx = 0;
    //左子树
    int[] preorder;
    //右子树
    int[] inorder;
    //存储中序遍历
    HashMap<Integer,Integer> idx_map = new HashMap<Integer,Integer>();

    public TreeNode helper(int in_left,int in_right){
        if(in_left == in_right){
            return null;
        }
        //取出前序遍历的第一个元素(必为根)
        int root_val = preorder[pre_idx];

        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        //递归
        pre_idx++;

        //中序遍历分割左右子树
        root.left = helper(in_left,index);
        root.right = helper(index + 1,in_right);


        return root;


    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int index = 0;
        for(Integer val : inorder){
            idx_map.put(val,index++);
        }
        return helper(0,preorder.length);
    }
}