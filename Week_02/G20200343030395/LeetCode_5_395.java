package Week_02.G20200343030395;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_5_395 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        //第一个节点放入队列
        queue.add(root);

        while(!queue.isEmpty()) {
            //新建一个这个等级的，用于保存
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i=0; i<size; i++) {
                Node node = queue.poll();
                level.add(node.val);

                //塞入下一层的
                queue.addAll(node.children);
            }

            result.add(level);
        }

        return result;
    }
}
