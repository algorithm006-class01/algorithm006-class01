package G20200343030375;

import java.util.ArrayList;
import java.util.List;

/**
 * leedcode 执行，时间复杂度还可以，空间复杂度，比较高
 * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.73% 的用户
 * 内存消耗 : 41.2 MB , 在所有 Java 提交中击败了 5.01% 的用户
 */
public class Leet_code_590_375 {
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root ==null){
            return result;
        }
        if(root.children !=null || root.children.size()>0) {
            recur(result, root);
        }else{
            result.add(root.val);
        }
        return result;
    }

    private static void recur(List<Integer> result, Node node) {
        if(node.children !=null &&node.children.size()>0) {
            for(Node childNode : node.children){
                recur(result, childNode);
            }
        }

        result.add(node.val);
        return;
    }
    private class Node {
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
    }
}
