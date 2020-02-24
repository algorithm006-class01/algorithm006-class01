package follow.phenix.ice.algorithm.weektwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 */
public class NnArrayTreeLevelOrder {

    public List<List<Integer>> levelOrderByWhile(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Node> needCheckNodeList = new ArrayList<>();
        needCheckNodeList.add(root);
        while (needCheckNodeList.size() > 0) {
            List<Node> childrenList = new ArrayList<>();
            List<Integer> valList = new ArrayList<>();
            for (Node node : needCheckNodeList) {
                valList.add(node.val);
                List<Node> children = node.children;
                if (children != null) {
                    childrenList.addAll(node.children);
                }
            }
            result.add(valList);
            needCheckNodeList = childrenList;
        }
        return result;
    }

    public List<List<Integer>> levelOrderByRecursion(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, root, 0);
        return result;
    }

    private void recursion(List<List<Integer>> result, Node node, int level) {
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                recursion(result, child, level + 1);
            }
        }
    }
}
