package cn.geek.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * N叉树的后序遍历
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月22日 22:39:00
 */
public class LeetCode_590_363 {

    /**
     * Postorder list.
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        conver(root, res);
        return res;
    }

    private void conver(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node children : root.children) {
                conver(children, res);
            }
        }
        res.add(root.val);
    }
}
