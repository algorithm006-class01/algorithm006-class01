package week2.construct_binary_tree_from_preorder_and_inorder_traversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    public TreeNode recursion(int[] p,int[] i,int pb,int pe,int ib,int ie){
        if (pb==pe||ib==ie){
            return null;
        }
        TreeNode treeNode = new TreeNode(p[pb]);
        int temp = 0;
        for(int a=0;a<i.length;a++){
            if(i[a]==p[pb]){
                temp = a;
                break;
            }
        }
        int longnum = temp-ib;
        treeNode.left=recursion(p,i,pb+1,pb+1+longnum,ib,temp);
        treeNode.right=recursion(p,i,pb+1+longnum,pe,temp+1,ie);
        return treeNode;
    }
}
