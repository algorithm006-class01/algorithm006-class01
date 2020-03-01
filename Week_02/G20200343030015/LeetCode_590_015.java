package G20200343030015.week_02;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_590_015 {

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pollLast();
            output.addFirst(tmp.val);
            for (Node child : tmp.children) {
                if (child != null) {
                    stack.add(child);
                }
            }
        }

        return output;
    }
}
