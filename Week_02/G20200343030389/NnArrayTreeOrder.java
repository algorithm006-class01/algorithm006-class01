package follow.phenix.ice.algorithm.weektwo;

import java.util.ArrayList;
import java.util.List;

;

/**
 * N叉树的后序遍历
 * 1：使用递归的方式
 * 2：官方题解中的迭代手动维护了一个栈，实际和递归是一样的，只不过递归是程序帮我们维护了一个栈
 * <p>
 * N叉树的前序遍历
 * 1：使用递归的方式
 *
 * @author double_ice
 */
@SuppressWarnings("unused")
public class NnArrayTreeOrder {

    public List<Integer> postOrderByRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postOrderRecursion(result, root);
        return result;
    }

    private void postOrderRecursion(List<Integer> valList, Node node) {
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                postOrderRecursion(valList, child);
            }
        }
        valList.add(node.val);
    }

    public List<Integer> prevOrderByRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        prevOrderRecursion(result, root);
        return result;
    }

    private void prevOrderRecursion(List<Integer> valList, Node node) {
        valList.add(node.val);
        List<Node> children = node.children;
        if (children == null) {
            return;
        }
        for (Node child : children) {
            prevOrderRecursion(valList, child);
        }
    }
}
