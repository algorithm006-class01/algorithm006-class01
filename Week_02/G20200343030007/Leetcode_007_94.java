public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if  (root.val != null) {
            if (root.left != null) {
                inorder(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inorder(root.right, res);
            }
        }
    }
