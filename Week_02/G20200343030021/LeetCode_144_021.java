import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    普通递归
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
//        递归终结条件是什么？ root == null ；递归每层的作用是什么？ 获取每层的值，按照中-前-后的前序遍历方式
        helper(0, root, list);
        return list;
    }

    private void helper(int n, TreeNode root, ArrayList<Integer> list) {
//        递归终止条件
        if (root == null) {
            System.out.println(list);
            return;
        }
//        当期层逻辑
        list.add(root.val);
//        进入下一层
        helper(n + 1, root.left, list);
        helper(n + 1, root.right, list);
//        清理当前层
    }


    //栈模拟递归 ，迭代
    public List<Integer> preorderTraversal(TreeNode root) {
//        用链表实现栈
        LinkedList<TreeNode> stack = new LinkedList<>();
//        输出的链表
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
//        存入根节点，中
        stack.add(root);
//        遍历栈，使用栈模拟递归，终结条件：栈不空
        while (!stack.isEmpty()) {
//            检索并删除此列表的最后一个元素，返回此列表的最后一个元素，如果此列表为空，则为{@codenull}
            TreeNode node = stack.pollLast();
//            中
            output.add(node.val);
//            栈：先入后出，取出时右结点最后出来
            if (node.right != null) {
                stack.add(node.right);
            }
//            同上
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}