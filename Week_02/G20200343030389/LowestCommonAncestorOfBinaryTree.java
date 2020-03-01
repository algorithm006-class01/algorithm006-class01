package follow.phenix.ice.algorithm.weektwo;

import java.util.*;

/**
 * @author admin
 */
public class LowestCommonAncestorOfBinaryTree {

    private TreeNode answer;

    public TreeNode lowestCommonAncestorOne(TreeNode root, TreeNode p, TreeNode q) {
        hit(root, p, q);
        return answer;
    }

    private boolean hit(TreeNode self, TreeNode p, TreeNode q) {
        if (self == null) {
            return false;
        }
        boolean hitSelf;
        boolean hitLeft;
        boolean hitRight;
        hitSelf = (self == p || self == q);
        hitLeft = hit(self.left, p, q);
        hitRight = hit(self.right, p, q);
        boolean thisTreeNode = (hitSelf && hitLeft) || (hitSelf && hitRight) || (hitLeft && hitRight);
        if (thisTreeNode) {
            answer = self;
        }
        return hitSelf || hitLeft || hitRight;
    }

    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(20);
        parentMap.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                parentMap.put(pop.left, pop);
                stack.push(pop.left);
            }
            if (pop.right != null) {
                parentMap.put(pop.right, pop);
                stack.push(pop.right);
            }
        }
        List<TreeNode> pParentList = new ArrayList<>();
        TreeNode thisNode = p;
        while (thisNode != null) {
            pParentList.add(thisNode);
            thisNode = parentMap.get(thisNode);
        }
        thisNode = q;
        while (!pParentList.contains(thisNode)) {
            thisNode = parentMap.get(thisNode);
        }
        return thisNode;
    }
}
