package G20200343030379;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//429. N叉树的层序遍历
public class LeetCode_429_379 {
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

    //方法二：递归方式的广度优先搜索
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder2(Node root) {
        if (root != null) {
            traversNode(root,0);
        }
        return result;
    }

    private void traversNode(Node node, int level) {
        if(result.size()<=level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traversNode(child,level+1);
        }
    }

    //方法一：利用队列实现广度优先搜索
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> quere=new LinkedList<>();
        quere.add(root);
        while (!quere.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=quere.size();
            for (int i = 0; i < size; i++) {
                Node poll = quere.poll();
                level.add(poll.val);
                quere.addAll(poll.children);
            }

            result.add(level);
        }

        return result;
    }
}
