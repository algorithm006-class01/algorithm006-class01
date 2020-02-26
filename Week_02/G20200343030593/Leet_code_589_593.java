class Solution {
  List<Integer> result = new ArrayList<>();
  /*递归*/
  public List<Integer> preorder(Node root) {
    helper(root);
    return result;
  }

  public void helper(Node node) {
    if (node == null) {
      return;
    }
    result.add(node.val);
    List<Node> children = node.children;
    if (children != null) {
      for (Node n : children) {
        helper(n);
      }
    }
  }
}

class Solution {
  LinkedList<Integer> result = new LinkedList<>();
  /*递归*/
  public List<Integer> preorder(Node root) {
    if (root == null) {
      return result;
    }
    LinkedList<Node> stack = new LinkedList<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      Node n = stack.pollLast();
      result.add(n.val);
      List<Node> children = n.children;
      if (children != null) {
        for (int i = children.size() - 1; i >= 0; i--) {
          stack.add(children.get(i));
        }
      }
    }
    return result;
  }
}