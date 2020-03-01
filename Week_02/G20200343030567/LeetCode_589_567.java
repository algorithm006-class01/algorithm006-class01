public class Preorder {

  /**
   * 解题思路：
   * 1、递归实现前续遍历
   * 2、迭代法完成此题
   *
   * 前序遍历：根左右
   * 中序遍历：左根右
   * 后序遍历：左右根
   * ps: 前中后指的是根的遍历位置，这样就好记了
   *
   * @param root
   * @return
   */
  public List<Integer> preorder(Node root) {
      LinkedList<Integer> ret = new LinkedList<>();

      // 1 recursion terminator
      if (Objects.isNull(root)) {
          return ret;
      }
      if (Objects.isNull(root.children) || root.children.isEmpty()) {
          ret.add(root.val);
          return ret;
      }

      // 2 process logic in current level

      // 3 drill down
      // 根左右
      ret.add(root.val);
      for (Node node : root.children) {
          ret.addAll(preorder(node));
      }

      // 4 reverse the current level status if needed
      return ret;
  }

}
