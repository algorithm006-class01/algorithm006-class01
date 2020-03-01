class Solution {

    /**
     * 层次遍历
     * BFS
     * 一层一层的遍历 刚好符合层次遍历的题意
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;i++) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        _helper(root, 0, res);

        return res;
    }

    private void _helper(TreeNode root, int level, List<List<Integer>> res) {

        if (root == null) {
            return;
        }

        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);

        if (root.left != null) _helper(root.left, level+1, res);

        if (root.right != null) _helper(root.right, level+1, res);

    }

}