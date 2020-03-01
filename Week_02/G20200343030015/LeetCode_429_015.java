package G20200343030015.week_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_429_015 {

    //通过循环模拟递归的方式解决
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> datas = new ArrayList<List<Integer>>();
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node node = list.poll();
                level.add(node.val);
                list.addAll(node.children);
            }

            datas.add(level);
        }
        return datas;
    }
}
