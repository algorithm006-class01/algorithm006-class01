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
}