package G20200343030379;

import java.util.ArrayList;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//236. 二叉树的最近公共祖先
public class LeetCode_236_379 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recuresTree(root,p,q);
        return this.ans;
    }

    //方法一：递归
    private boolean recuresTree(TreeNode cur, TreeNode p, TreeNode q) {
        if(cur==null) return false;

        int left=recuresTree(cur.left,p,q)?1:0;
        int right=recuresTree(cur.right,p,q)?1:0;
        int mid=(cur==p ||cur==q)?1:0;

        if((left+right+mid)>=2){
            ans=cur;
        }

        return (left+mid+right)>0;
    }


}
