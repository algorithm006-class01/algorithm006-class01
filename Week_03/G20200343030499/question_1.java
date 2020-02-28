/**
 * LeetCode 515. Find Largest Value in Each Tree Row
 * 第一个代码只用了2ms
 * 第二个用了25ms
 * 但除了第一个单独写了helper函数之外逻辑上完全相同，时间空间复杂度也都相同。为什么会有那么大的运行时间差异？
 */
class Solution_2ms {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        helper(results, queue);
        return results;
    }

    private void helper(List<Integer> results, Queue<TreeNode> queue) {
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMax = Integer.MIN_VALUE;
            while (levelSize-- > 0) {
                TreeNode node = queue.remove();
                levelMax = Math.max(levelMax, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add(levelMax);
        }
    }
}

class Solution_25ms {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMax = Integer.MIN_VALUE;
            while (levelSize-- > 0) {
                System.out.println(levelSize);
                TreeNode node = queue.remove();
                levelMax = Math.max(levelMax, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add(levelMax);
        }
        return results;
    }
}