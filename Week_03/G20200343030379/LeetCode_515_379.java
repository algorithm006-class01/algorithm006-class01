package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  515. 在每个树行中找最大值
 *
 *  您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：
 */



public class LeetCode_515_379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
    }

    /**
     * 迭代法-广度优先搜索(注意：加了运行日志会变成很慢，注意不要加)
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 82.08% 的用户
     * 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        //每一层最大的值
        while (!queue.isEmpty()){
            int maxValue=Integer.MIN_VALUE;
            int size = queue.size();
            //遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //日志打印会影响 执行用时，最好去掉执行日志
                //System.out.println("测试");
                //获取当前层的最大值
                if(node.val>maxValue) {
                    maxValue=node.val;
                }

                //获取关联的下一层子节点
                if(node.left!=null) {queue.add(node.left);}
                if (node.right != null) {queue.add(node.right);}

            }
            res.add(maxValue);
        }

        return res;
    }


    /**
     *  递归法-深度优先搜索
     *  执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *  内存消耗 : 42.6 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     *  参考题解：
     *  https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/java-di-gui-xie-fa-hao-shi-2ms-by-ou-ran-zz/
     *  https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971/9ms-JAVA-DFS-solution
     *
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(res,root,0);

        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int level) {
        if(root==null){
            return;
        }
        if(level==res.size()){
            res.add(root.val);
        }else{
            res.set(level,Math.max(res.get(level),root.val));
        }

        if(root.left!=null){
            dfs(res,root.left,level+1);
        }
        if(root.right!=null){
            dfs(res,root.right,level+1);
        }
    }


}
