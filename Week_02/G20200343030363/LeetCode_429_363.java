package cn.geek.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * N叉树的层序遍历 BFS
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月23日 07:25:00
 */
public class LeetCode_429_363 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (null == root) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            //队列和栈不能放到for循环判断里面
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);

                // 队列里面放的,始终是同一级的节点
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}
