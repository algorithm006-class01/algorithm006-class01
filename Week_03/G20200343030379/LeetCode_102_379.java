package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

/**
 *  102. 二叉树的层次遍历
 *  给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树:?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：
 */



public class LeetCode_102_379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //迭代法-广度优先搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue=new LinkedList();
        //1 添加头结点
        queue.add(root);

        //2.迭代
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            //2.1 遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //2.1.1 选中前面元素
                temp.add(node.val);

                //2.1.2 查询所有关联
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            //2.2 收集每一层的数据
            res.add(temp);
        }

        return res;
    }

    //递归法-深度优先搜素
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();


        helper(res,root,0);

        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if(root==null) return;
        if(depth==res.size()) res.add(new ArrayList<>());
        res.get(depth).add(root.val);

        //递归
        if(root.left!=null) helper(res,root.left,depth+1);
        if(root.right!=null) helper(res,root.right,depth+1);
    }


}
