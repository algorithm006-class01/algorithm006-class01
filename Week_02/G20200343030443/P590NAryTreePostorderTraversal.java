import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：N叉树的后序遍历
class P590NAryTreePostorderTraversal {

  public static void main(String[] args) {
    Solution solution = new P590NAryTreePostorderTraversal().new Solution();
    // TO TEST
  }

  // Definition for a Node.
  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  ;

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) { //递归写法，简便明了
      if (root != null) {
        for (int i = 0; i < root.children.size(); i++) {
          postorder(root.children.get(i));
        }
        result.add(root.val);
      }
      return result;
    }
  }

  class Solution1 {
    //迭代法，用栈辅助进行前右左遍历，再利用链表头插进行反序保存
    public List<Integer> postorder(Node root) {
      List<Integer> result = new LinkedList<>();
      Stack<Node> stack = new Stack<>();
      if (root == null) {
        return result;
      }
      stack.add(root);
      while (!stack.empty()) {
        Node father = stack.pop();
        result.add(0, father.val);//链表头插反序
        for (Node node : father.children) {
          stack.add(node);
        }
      }
      return result;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)
}