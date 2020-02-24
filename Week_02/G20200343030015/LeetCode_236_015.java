package G20200343030015.week_02;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_236_015 {

    private TreeNode ans;

    public boolean doSearch(TreeNode root, TreeNode p, TreeNode q) {
        //处理边界值
        if (root == null) {
            return false;
        }
        //处理本次循环数据
        int currStatus = (root.val == p.val || root.val == q.val) ? 1 : 0;

        //进入下一次迭代
        int leftStatus = doSearch(root.left, p, q) ? 1 : 0;
        int rightStatus = doSearch(root.right, p, q) ? 1 : 0;
        if ((currStatus + leftStatus + rightStatus) == 2) {
            this.ans = root;
            return true;
        }

        return (currStatus + leftStatus + rightStatus) > 0;
    }

    //暴力破解，判断左子树和右子树是否有包含p或q，假如在一个根节点处 左子树+右子树 == 2 就表示找到该节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doSearch(root, p, q);

        return this.ans;
    }
}
