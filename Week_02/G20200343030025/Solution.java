public class Solution {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class GroupAnagrams {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars).toLowerCase();
                List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
                list.add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     * <p>
     *  示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class BTreePreorderTraversal {

        /**
         * 迭代方式
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode tmp = root;
            while (tmp != null || !stack.isEmpty()) {
                // 所有的左子树
                while (tmp != null) {
                    res.add(tmp.val);
                    stack.push(tmp);
                    tmp = tmp.left;
                }
                tmp = stack.pop().right;
            }
            return res;
        }

        /**
         * 递归方式
         */
        public List<Integer> preorderTraversal0(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            doPreorderTraversal0(res, root);
            return res;
        }

        private void doPreorderTraversal0(List<Integer> res, TreeNode root) {
            if (root != null) {
                res.add(root.val);
                this.doPreorderTraversal0(res, root.left);
                this.doPreorderTraversal0(res, root.right);
            }
        }
    }

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     *
     * 例如，给定一个 3叉树 :
     *
     * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png
     *
     *
     * 返回其层序遍历:
     *
     * [
     *      [1],
     *      [3,2,4],
     *      [5,6]
     * ]
     *  
     *
     * 说明:
     *
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class NTreeLevelOrder {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int leveSize = queue.size();
                List<Integer> list = new ArrayList<>(leveSize);
                for (int i = 0; i < leveSize; i++) {
                    Node node = queue.removeFirst();
                    list.add(node.val);
                    List<Node> children = node.children;
                    for (Node child : children) {
                        if (child == null) {
                            continue;
                        }
                        queue.add(child);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}